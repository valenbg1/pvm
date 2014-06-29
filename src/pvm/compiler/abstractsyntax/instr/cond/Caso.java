package pvm.compiler.abstractsyntax.instr.cond;

import java.util.ArrayList;
import java.util.List;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;

public class Caso extends Node {
	private Exp exp;
	private List<Instruccion> instrs;
	
	public Caso(Exp exp, List<Instruccion> instrs) {
		this.exp = exp;
		this.instrs = instrs;
	}

	@Override
	public int anidamientoDe() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void asignaEspacio() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void chequea() {
		exp.chequea();
		
		if (!exp.getTipo_infer().esBooleano())
			ErrorsHandler.chequeaExpresionNoEsDeTipo("boolean", exp, row);
		
		for (Instruccion instr : instrs)
			instr.chequea();
	}

	public Exp getExp() {
		return exp;
	}

	public List<Instruccion> getInstrs() {
		return instrs;
	}

	@Override
	public void simplificaDefTipos() {}

	@Override
	public String toString() {
		String ret = exp + " : {\n";
		
		for (Instruccion inst : instrs)
			ret += "\t" + inst + "\n";
		
		ret += "}";
		
		return ret;
	}
	
	@Override
	public void vincula() {
		exp.vincula();
		
		for (Instruccion instr : instrs)
			instr.vincula();
	}
	
	@Override
	public void vinculaDefPunteros() {}

	@Override
	public void codigo() {
		inicio = cinst;
		exp.codigo();
		cinst += numeroInstruccionesDeControl();
		for (Instruccion instr : instrs)
			instr.codigo();
		cinst += numeroInstruccionesDeControl();
		
		fin = cinst;
		
		cod = new ArrayList<Instruction>();
		cod.addAll(exp.getCod());
		cod.add(new IntArgInstruction(IntInstruction_t.IR_F, fin));
		for (Instruccion instr : instrs)
			cod.addAll(instr.getCod());
	}
	
	private int numeroInstruccionesDeControl() {
		return 1;
	}


}