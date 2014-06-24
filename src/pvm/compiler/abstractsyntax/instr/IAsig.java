package pvm.compiler.abstractsyntax.instr;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.exp.Exp;

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
}