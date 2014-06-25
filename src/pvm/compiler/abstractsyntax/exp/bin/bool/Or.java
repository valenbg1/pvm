package pvm.compiler.abstractsyntax.exp.bin.bool;

import pvm.compiler.abstractsyntax.exp.Exp;

public class Or extends ExpBinBool {
	public Or(Exp exp0, Exp exp1) {
		super(exp0, exp1, "OR");
	}
}