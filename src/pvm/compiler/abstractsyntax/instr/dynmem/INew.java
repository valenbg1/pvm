package pvm.compiler.abstractsyntax.instr.dynmem;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class INew extends Instruccion {
	private Designador desig;
	
	public INew(Designador desig) {
		this.desig = desig;
	}

	@Override
	public void chequea() {
		if((desig != null) && (desig.getTipo_infer().esPointer()))
			ErrorsHandler.chequeaDesignadorNoEsDeTipo("pointer", desig, row);
	}
	
	public Designador getDesig() {
		return desig;
	}

	@Override
	public String toString() {
		return "NEW " + desig + ";";
	}

	@Override
	public void vincula() {
		desig.vincula();
	}
}