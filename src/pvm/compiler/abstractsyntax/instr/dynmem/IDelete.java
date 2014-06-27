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
		desig.chequea();
		
		if (desig != null) {
			if (desig.getTipo_infer().esPointer())
				return;
			else if (desig.getTipo_infer().esId() && desig.getTipo_infer()
							.getVinculo().getTipo_infer().esPointer())
				return;
				
			ErrorsHandler.chequeaDesignadorNoEsDeTipo("pointer", desig, desig.getRow());
		}
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