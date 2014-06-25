package pvm.compiler.abstractsyntax.instr;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.exceptions.CheckFailException;

public class IAsig extends Instruccion {
	private Designador desig;
	private Exp exp;
	
	public IAsig(Designador desig, Exp exp) {
		this.desig = desig;
		this.exp = exp;
	}

	@Override
	public String toString() {
		return desig + " = " + exp + ";";
	}

	public Designador getDesig() {
		return desig;
	}

	public Exp getExp() {
		return exp;
	}

	@Override
	public void vincula() {
		this.getDesig().vincula();
		this.getExp().vincula();
	}

	@Override
	public void vinculaDefPunteros() {	
	}

	@Override
	public void chequea() throws CheckFailException {
		this.getDesig().chequea();
		this.getExp().chequea();
		
		if(this.getDesig().getTipo_infer() != this.getExp().getTipo())
			throw new CheckFailException("asignación, tipo no coincide, se esperaba "+this.getDesig().getTipo_infer());
	}
}