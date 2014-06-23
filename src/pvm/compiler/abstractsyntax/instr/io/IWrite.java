package pvm.compiler.abstractsyntax.instr.io;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class IWrite extends Instruccion {
	private Exp exp;
	
	public IWrite(Exp exp) {
		super();
		
		this.exp = exp;
		
		this.childs.add(exp);
	}

	@Override
	public String toString() {
		return "write " + exp + ";";
	}

	public Exp getExp() {
		return exp;
	}
}