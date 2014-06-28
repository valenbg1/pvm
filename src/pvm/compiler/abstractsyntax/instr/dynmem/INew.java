package pvm.compiler.abstractsyntax.instr.dynmem;

import java.util.ArrayList;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.vm.instructions.Instruction;

public class INew extends Instruccion {
	private Designador desig;
	
	public INew(Designador desig) {
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
		return "NEW " + desig + ";";
	}

	@Override
	public void vincula() {
		desig.vincula();
	}
	
	@Override
	public void codigo() {
		inicio = cinst;
		desig.codigo();
		cinst += numeroInstruccionesFinNew();
		fin = cinst;
		cod = new ArrayList<>();
		cod.addAll(desig.getCod());
		cod.addAll(codigoFinNew());
		
	}

	private ArrayList<Instruction> codigoFinNew() {
		// TODO Auto-generated method stub
		return null;
	}

	private int numeroInstruccionesFinNew() {
		// TODO Auto-generated method stub
		return 0;
	}
}