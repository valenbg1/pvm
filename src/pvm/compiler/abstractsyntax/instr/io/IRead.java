package pvm.compiler.abstractsyntax.instr.io;

import java.util.ArrayList;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.vm.instructions.IOInstruction;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IOInstruction.IOInstruction_t;
import pvm.vm.instructions.PointerInstruction.PointerInstruction_t;
import pvm.vm.instructions.PointerInstruction;

public class IRead extends Instruccion {
	private Designador desig;
	
	public IRead(Designador desig) {
		this.desig = desig;
	}

	@Override
	public void chequea() {
		desig.chequea();
		
		if ((!desig.getTipo_infer().ioValid()))
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
	
	@Override
	public void codigo() {
		inicio = cinst;
		desig.codigo();
		cinst += numeroInstruccionesFinRead();
		fin = cinst;
		cod = new ArrayList<>();
		cod.addAll(desig.getCod());
		cod.addAll(codigoFinRead());
		
	}

	private ArrayList<Instruction> codigoFinRead() {
		ArrayList<Instruction> ret = new ArrayList<>();
		ret.add(new IOInstruction(IOInstruction_t.LEE));
		ret.add(new PointerInstruction(PointerInstruction_t.DESAPILA_IND));
		return ret;
	}

	private int numeroInstruccionesFinRead() {
		return 2;
	}
}