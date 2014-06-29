package pvm.compiler.abstractsyntax.instr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.ExpDesignador;
import pvm.compiler.abstractsyntax.subprog.DecSubprograma;
import pvm.compiler.abstractsyntax.subprog.param.Parametro;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;
import pvm.vm.instructions.PointerInstruction;
import pvm.vm.instructions.PointerInstruction.PointerInstruction_t;
import pvm.vm.instructions.VoidArgInstruction;
import pvm.vm.instructions.VoidArgInstruction.VoidInstruction_t;

public class ILlamada extends Instruccion {
	private String id;
	
	private List<Exp> args;
	
	public ILlamada(String id, List<Exp> args, int row) {
		this.id = id;
		
		this.args = args;
		
		this.row = row;
	}

	@Override
	public void chequea() {
		if(!(vinculo instanceof DecSubprograma))
			ErrorsHandler.chequeaIdentificadorNoEsSubprograma(id, row);
		
		for(Exp e : args)
			e.chequea();
		
		DecSubprograma vinc = (DecSubprograma) this.vinculo;
		
		if (this.args.size() != vinc.getParams().size())
			ErrorsHandler.error("Número de parámetros distintos al llamar a "+ id +" "+ row);
		
		int i = 1;
		Iterator<Exp> iter = args.iterator();
		
		for (Parametro param : vinc.getParams()) {
			Exp exp = iter.next();
			
			if (param.esRefer() && !(exp instanceof ExpDesignador))
				ErrorsHandler.error("El parámetro " + i + " en '" + this
						+ "' no es un designador " + row);
			else if (!param.getTipo_infer().equals(exp.getTipo_infer()))
				ErrorsHandler.error("El parámetro " + i + " en '" + this
						+ "' no tiene tipo compatible con "
						+ param.getTipo_infer() + " en la linea " + row);

			++i;
		}
	}

	public List<Exp> getArgs() {
		return args;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		String args_s = "";
		
		for (Exp arg : args)
			args_s += arg + ", ";
		
		return id + "(" + args_s + ")" + ";";
	}

	@Override
	public void vincula() {
		vinculo = sym_t.declaracion(id);
		
		if (vinculo == null)
			ErrorsHandler.vinculaUndeclaredId(id, row);
		
		for (Exp exp : args)
			exp.vincula();
	}

	@Override
	public void codigo() {
		inicio = cinst;
		cod = codigoCompienzoPasoParam();
		cinst +=  cod.size();
		
		for (Exp exp : args){
			cod.add(new VoidArgInstruction(VoidInstruction_t.DUP));
			cinst++;
			exp.codigo();
			cod.addAll(codigoPasoParámetro(exp));
			cinst += numeroInstruccionesPasoParam(exp);
		}
		
		cinst += numeroInstruccionesFinLlamada();
		fin = cinst;
		
		cod.addAll(codigoFinLlamada());
	}

	private ArrayList<Instruction> codigoFinLlamada() {
		ArrayList<Instruction> ret = new ArrayList<Instruction>();
		ret.add(new IntArgInstruction(IntInstruction_t.APILA_DIR, 0));
		ret.add(new IntArgInstruction(IntInstruction_t.APILA, 1));
		ret.add(new VoidArgInstruction(VoidInstruction_t.SUMA));
		ret.add(new IntArgInstruction(IntInstruction_t.APILA_DIR, this.fin));
		ret.add(new PointerInstruction(PointerInstruction_t.DESAPILA_IND));
		ret.add(new IntArgInstruction(IntInstruction_t.IR_A, ((DecSubprograma)vinculo).getDirComienzo()));
		
		return ret;
	}

	private int numeroInstruccionesFinLlamada() {	
		return 6;
	}

	private int numeroInstruccionesPasoParam(Exp exp) {
		return 3 + exp.getCod().size();
	}

	private ArrayList<Instruction> codigoPasoParámetro(Exp exp) {
		int index = args.indexOf(exp);
		ArrayList<Instruction> ret = new ArrayList<Instruction>();
		
		ret.add(new IntArgInstruction(IntInstruction_t.APILA, index));
		ret.add(new VoidArgInstruction(VoidInstruction_t.SUMA));
		ret.addAll(exp.getCod());
		
		if(((DecSubprograma)vinculo).getParams().get(index).esValor() && (exp instanceof ExpDesignador))
			ret.add(new IntArgInstruction(IntInstruction_t.CLONA, exp.getTipo_infer().getTam()));
		else
			ret.add(new PointerInstruction(PointerInstruction_t.DESAPILA_IND));
				
		return ret;
	}

	private ArrayList<Instruction> codigoCompienzoPasoParam() {
		ArrayList<Instruction> ret = new ArrayList<Instruction>();
		ret.add(new IntArgInstruction(IntInstruction_t.APILA_DIR, 0));
		ret.add(new IntArgInstruction(IntInstruction_t.APILA, 3));
		ret.add(new VoidArgInstruction(VoidInstruction_t.SUMA));
		return ret;
	}
}