package pvm.compiler.abstractsyntax.instr;

import pvm.compiler.abstractsyntax.exp.Exp;

public class IWrite extends Instruccion {
	public IWrite(Exp exp) {
		super();
		
		this.childs.add(exp);
	}

	@Override
	public String toString() {
		return "write " + childs.get(0) + ";";
	}
}