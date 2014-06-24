package pvm.compiler.abstractsyntax.instr.io;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class IWrite extends Instruccion {
	private Exp exp;
	
	public IWrite(Exp exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "WRITE " + exp + ";";
	}

	public Exp getExp() {
		return exp;
	}

	@Override
	public void vincula() {
		this.getExp().vincula();
	}

	@Override
	public void vinculaDefPunteros() {	
	}
}