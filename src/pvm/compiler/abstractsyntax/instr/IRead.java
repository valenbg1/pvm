package pvm.compiler.abstractsyntax.instr;

import pvm.compiler.abstractsyntax.designador.Designador;

public class IRead extends Instruccion {
	public IRead(Designador desig) {
		super();
		
		this.childs.add(desig);
	}

	@Override
	public String toString() {
		return "read " + childs.get(0) + ";";
	}
}