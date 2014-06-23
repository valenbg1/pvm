package pvm.compiler.abstractsyntax.exp.num;

import pvm.compiler.abstractsyntax.exp.Exp;

public class ExpNumReal extends Exp {
	private double numreal;
	
	public ExpNumReal(double numreal) {
		super();
		this.numreal = numreal;
	}

	@Override
	public String toString() {
		return Double.toString(numreal);
	}

	public double getNumReal() {
		return numreal;
	}
}