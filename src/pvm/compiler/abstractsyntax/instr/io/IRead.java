package pvm.compiler.abstractsyntax.instr.io;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class IRead extends Instruccion {
	private Designador desig;
	
	public IRead(Designador desig) {
		this.desig = desig;
	}

	@Override
	public void chequea() {
		if((!desig.getTipo_infer().esBooleano()) &&
		   (!desig.getTipo_infer().esDouble())  &&
		   (!desig.getTipo_infer().esInt()))
		   ErrorsHandler.error("El tipo " + desig.getTipo_infer() + " no se puede leer");
	}
	
	public Designador getDesig() {
		return desig;
	}

	@Override
	public String toString() {
		return "READ " + desig + ";";
	}

	@Override
	public void vincula() {
		desig.vincula();		
	}
}