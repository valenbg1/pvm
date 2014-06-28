package pvm.compiler.abstractsyntax.instr.io;

import java.util.ArrayList;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.vm.instructions.Instruction;

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
		// TODO Auto-generated method stub
		return null;
	}

	private int numeroInstruccionesFinRead() {
		// TODO Auto-generated method stub
		return 0;
	}
}