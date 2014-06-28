package pvm.compiler.abstractsyntax.instr;

import java.util.ArrayList;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.ExpDesignador;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;
import pvm.vm.instructions.PointerInstruction;
import pvm.vm.instructions.PointerInstruction.PointerInstruction_t;

public class IAsig extends Instruccion {
	private Designador desig;
	private Exp exp;
	
	public IAsig(Designador desig, Exp exp) {
		this.desig = desig;
		this.exp = exp;
	}

	@Override
	public void chequea() {
		desig.chequea();
		exp.chequea();

		if (!desig.getTipo_infer().equals(exp.getTipo_infer()))
			ErrorsHandler.chequeaTiposNoCompatibles(this, desig.getTipo_infer(),
					exp.getTipo_infer(), row);

	}

	public Designador getDesig() {
		return desig;
	}

	public Exp getExp() {
		return exp;
	}

	@Override
	public String toString() {
		return desig + " = " + exp + ";";
	}

	@Override
	public void vincula() {
		desig.vincula();
		exp.vincula();
	}

	@Override
	public void codigo() {
		inicio = cinst;
		desig.codigo();
		exp.codigo();
		cinst += numeroInstruccionesFinAsig();
		fin = cinst;
		cod = new ArrayList<>();
		cod.addAll(desig.getCod());
		cod.addAll(exp.getCod());
		cod.addAll(codigoFinAsig());
		
	}

	private ArrayList<Instruction> codigoFinAsig() {
		ArrayList<Instruction> ret = new ArrayList<Instruction>();
		
		if(exp instanceof ExpDesignador){
			ret.add(new IntArgInstruction(IntInstruction_t.CLONA, exp.getTipo_infer().getTam()));
		}else{
			ret.add(new PointerInstruction(PointerInstruction_t.DESAPILA_IND));
		}
		
		return ret;
	}

	private int numeroInstruccionesFinAsig() {
		return 1;
	}
}