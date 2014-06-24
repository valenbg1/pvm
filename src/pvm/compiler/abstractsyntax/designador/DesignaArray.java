package pvm.compiler.abstractsyntax.designador;

import pvm.compiler.abstractsyntax.exp.Exp;

public class DesignaArray extends Designador {
	private Designador desig;
	private Exp exp;
	
	public DesignaArray(Designador desig, Exp exp) {
		this.desig = desig;
		this.exp = exp;
	}

	@Override
	public String toString() {
		return desig + "[" + exp + "]";
	}

	public Designador getDesig() {
		return desig;
	}

	public Exp getExp() {
		return exp;
	}
}