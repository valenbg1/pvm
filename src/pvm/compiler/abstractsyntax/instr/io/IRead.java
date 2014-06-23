package pvm.compiler.abstractsyntax.instr.io;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;

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