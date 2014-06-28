package pvm.compiler.abstractsyntax.designador;

import java.util.ArrayList;

import pvm.compiler.ErrorsHandler;
import pvm.vm.instructions.Instruction;


public class DesignaPointer extends Designador {
	private Designador desig;
	
	public DesignaPointer(Designador desig, int row) {
		this.desig = desig;
		this.row = row;
	}

	@Override
	public void chequea() {
		desig.chequea();
		
		if (desig != null) {
			if (desig.getTipo_infer().esPointer())
				tipo_infer = desig.getTipo_infer().getTipo_infer();	
			else
				ErrorsHandler.chequeaDesignadorNoEsDeTipo("pointer", desig, desig.getRow());
		}
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

	@Override
	public void codigo() {
		desig.codigo();
		
		cod.addAll(desig.getCod());
		cod.addAll(codigoDereferencia());
		cinst += numeroInstruccionesDereferencia();
	}

	private int numeroInstruccionesDereferencia() {
		// TODO Auto-generated method stub
		return 0;
	}

	private ArrayList<Instruction> codigoDereferencia() {
		// TODO Auto-generated method stub
		return null;
	}
}