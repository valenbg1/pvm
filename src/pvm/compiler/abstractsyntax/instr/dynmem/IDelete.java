package pvm.compiler.abstractsyntax.instr.dynmem;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;

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