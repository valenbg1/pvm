package pvm.compiler.abstractsyntax.instr.dynmem;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class IDelete extends Instruccion {
	private Designador desig;
	
	public IDelete(Designador desig) {
		this.desig = desig;
	}

	@Override
	public String toString() {
		return "DELETE " + desig + ";";
	}

	public Designador getDesig() {
		return desig;
	}

	@Override
	public void vincula() {
		this.getDesig().vincula();
	}

	@Override
	public void vinculaDefPunteros() {	
	}
}