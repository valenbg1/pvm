package pvm.compiler.abstractsyntax.instr.io;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class IWrite extends Instruccion {
	private Exp exp;
	
	public IWrite(Exp exp) {
		this.exp = exp;
	}

	@Override
	public void chequea() {
		if((!exp.getTipo_infer().esBooleano()) &&
		   (!exp.getTipo_infer().esDouble())  &&
		   (!exp.getTipo_infer().esInt()))
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
}