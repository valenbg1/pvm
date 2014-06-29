package pvm.compiler.abstractsyntax.designador;

import java.util.ArrayList;

import pvm.compiler.ErrorsHandler;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.PointerInstruction;
import pvm.vm.instructions.PointerInstruction.PointerInstruction_t;


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
		inicio = cinst;
		desig.codigo();
		
		cod = new ArrayList<Instruction>();
		
		cod.addAll(desig.getCod());
		cod.addAll(codigoDereferencia());
		cinst += numeroInstruccionesDereferencia();
		fin = cinst;
	}

	private int numeroInstruccionesDereferencia() {
		return 1;
	}

	private ArrayList<Instruction> codigoDereferencia() {
		ArrayList<Instruction> ret = new ArrayList<Instruction>();
		ret.add(new PointerInstruction(PointerInstruction_t.APILA_IND));
		return ret;
	}
}