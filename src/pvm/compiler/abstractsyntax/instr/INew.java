package pvm.compiler.abstractsyntax.instr;

import pvm.compiler.abstractsyntax.designador.Designador;

public class INew extends Instruccion {
	public INew(Designador desig) {
		super();
		
		this.childs.add(desig);
	}

	@Override
	public String toString() {
		return "new " + childs.get(0) + ";";
	}
}