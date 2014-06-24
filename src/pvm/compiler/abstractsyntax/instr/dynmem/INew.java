package pvm.compiler.abstractsyntax.instr.dynmem;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class INew extends Instruccion {
	private Designador desig;
	
	public INew(Designador desig) {
		this.desig = desig;
	}

	@Override
	public String toString() {
		return "NEW " + desig + ";";
	}
	
	public Designador getDesig() {
		return desig;
	}
}