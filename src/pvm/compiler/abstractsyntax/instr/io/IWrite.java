package pvm.compiler.abstractsyntax.instr.io;

import java.util.ArrayList;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.vm.instructions.Instruction;

public class IWrite extends Instruccion {
	private Exp exp;
	
	public IWrite(Exp exp) {
		this.exp = exp;
	}

	@Override
	public void chequea() {
		exp.chequea();
		
		if ((!exp.getTipo_infer().ioValid()))
		   ErrorsHandler.error("El tipo " + exp.getTipo_infer() + " no se puede escribir");
	}

	public Exp getExp() {
		return exp;
	}

	@Override
	public String toString() {
		return "WRITE " + exp + ";";
	}

	@Override
	public void vincula() {
		exp.vincula();
	}
	
	@Override
	public void codigo() {
		inicio = cinst;
		exp.codigo();
		cinst += numeroInstruccionesFinWrite();
		fin = cinst;
		cod = new ArrayList<>();
		cod.addAll(exp.getCod());
		cod.addAll(codigoFinWrite());
		
	}

	private ArrayList<Instruction> codigoFinWrite() {
		// TODO Auto-generated method stub
		return null;
	}

	private int numeroInstruccionesFinWrite() {
		// TODO Auto-generated method stub
		return 0;
	}
}