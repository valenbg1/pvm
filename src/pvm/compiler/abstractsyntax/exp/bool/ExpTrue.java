package pvm.compiler.abstractsyntax.exp.bool;

import pvm.compiler.abstractsyntax.exp.Exp;

public class ExpTrue extends Exp {
	public ExpTrue() {
		super();
	}

	@Override
	public String toString() {
		return "TRUE";
	}
}