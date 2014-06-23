package pvm.compiler.abstractsyntax.instr.io;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.instr.Instruccion;

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