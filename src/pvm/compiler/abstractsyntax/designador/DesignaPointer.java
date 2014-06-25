package pvm.compiler.abstractsyntax.designador;

import pvm.compiler.ErrorsHandler;


public class DesignaPointer extends Designador {
	private Designador desig;
	
	public DesignaPointer(Designador desig, int row) {
		this.desig = desig;
		this.row = row;
	}

	@Override
	public void chequea() {
		desig.chequea();
		
		if ((desig.getTipo_infer() != null) &&
				(desig.getTipo_infer().esPointer()))
			tipo_infer = desig.getTipo_infer().getTipo_infer();
		else
			ErrorsHandler.chequeaDesignadorNoEsDeTipo("pointer", desig, row);
	}

	public Designador getDesig() {
		return desig;
	}

	@Override
	public String toString() {
		return desig + "->";
	}

	@Override
	public void vincula() {
		desig.vincula();
	}
}