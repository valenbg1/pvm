package pvm.compiler.abstractsyntax.instr.dynmem;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;

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