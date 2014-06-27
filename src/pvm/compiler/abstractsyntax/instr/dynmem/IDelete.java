package pvm.compiler.abstractsyntax.instr.dynmem;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class IDelete extends Instruccion {
	private Designador desig;
	
	public IDelete(Designador desig) {
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
		return "DELETE " + desig + ";";
	}

	@Override
	public void vincula() {
		desig.vincula();
	}
}