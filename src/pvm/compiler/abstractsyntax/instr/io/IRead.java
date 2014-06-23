package pvm.compiler.abstractsyntax.instr.io;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class IRead extends Instruccion {
	private Designador desig;
	
	public IRead(Designador desig) {
		super();
		
		this.desig = desig;
		
		this.childs.add(desig);
	}

	@Override
	public String toString() {
		return "read " + desig + ";";
	}
	
	public Designador getDesig() {
		return desig;
	}
}