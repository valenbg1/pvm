package pvm.compiler.abstractsyntax.instr;

import java.util.ArrayList;
import java.util.Collection;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.vm.instructions.Instruction;

public class IAsig extends Instruccion {
	private Designador desig;
	private Exp exp;
	
	public IAsig(Designador desig, Exp exp) {
		this.desig = desig;
		this.exp = exp;
	}

	@Override
	public void chequea() {
		desig.chequea();
		exp.chequea();

		if (!desig.getTipo_infer().equals(exp.getTipo_infer()))
			ErrorsHandler.chequeaTiposNoCompatibles(this, desig.getTipo_infer(),
					exp.getTipo_infer(), row);

	}

	public Designador getDesig() {
		return desig;
	}

	public Exp getExp() {
		return exp;
	}

	@Override
	public String toString() {
		return desig + " = " + exp + ";";
	}

	@Override
	public void vincula() {
		desig.vincula();
		exp.vincula();
	}

	@Override
	public void codigo() {
		inicio = cinst;
		desig.codigo();
		exp.codigo();
		cinst += numeroInstruccionesFinAsig();
		fin = cinst;
		cod = new ArrayList<>();
		cod.addAll(desig.getCod());
		cod.addAll(exp.getCod());
		cod.addAll(codigoFinAsig());
		
	}

	private ArrayList<Instruction> codigoFinAsig() {
		// TODO Auto-generated method stub
		return null;
	}

	private int numeroInstruccionesFinAsig() {
		// TODO Auto-generated method stub
		return 0;
	}
}