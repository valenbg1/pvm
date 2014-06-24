package pvm.compiler.abstractsyntax.instr.io;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class IRead extends Instruccion {
	private Designador desig;
	
	public IRead(Designador desig) {
		this.desig = desig;
	}

	@Override
	public String toString() {
		return "READ " + desig + ";";
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