package pvm.compiler.abstractsyntax.instr.dynmem;

import java.util.ArrayList;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;
import pvm.vm.instructions.PointerInstruction;
import pvm.vm.instructions.PointerInstruction.PointerInstruction_t;

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
		ArrayList<Instruction> ret = new ArrayList<>();
		ret.add(new IntArgInstruction(IntInstruction_t.RESERVA, vinculo.getTipo_infer().getTam()));
		ret.add(new PointerInstruction(PointerInstruction_t.DESAPILA_IND));
		return ret;
	}

	private int numeroInstruccionesFinNew() {
		return 2;
	}
}