package pvm.compiler.abstractsyntax.instr;

import pvm.compiler.abstractsyntax.designador.Designador;

public class IDelete extends Instruccion {
	public IDelete(Designador desig) {
		super();
		
		this.childs.add(desig);
	}

	@Override
	public String toString() {
		return "delete " + childs.get(0) + ";";
	}
}