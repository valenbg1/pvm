package pvm.compiler.abstractsyntax.exp.bool;

import pvm.compiler.abstractsyntax.exp.Exp;

public class ExpFalse extends Exp {
	public ExpFalse() {
		super();
	}

	@Override
	public String toString() {
		return "false";
	}
}