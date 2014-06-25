package pvm.compiler.abstractsyntax.exp.bin.bool;

import pvm.compiler.abstractsyntax.exp.Exp;

public class And extends ExpBinBool {
	public And(Exp exp0, Exp exp1) {
		super(exp0, exp1, "AND");
	}
}