package pvm.compiler.abstractsyntax.exp.num;

import pvm.compiler.abstractsyntax.exp.Exp;

public class ExpNumNat extends Exp {
	private int numnat;
	
	public ExpNumNat(int numnat) {
		super();
		this.numnat = numnat;
	}

	@Override
	public String toString() {
		return Integer.toString(numnat);
	}

	public int getNumNat() {
		return numnat;
	}
}