package pvm.compiler.abstractsyntax.exp.bin.bool;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.bin.ExpBin;

public class And extends ExpBin {
	public And(Exp exp0, Exp exp1) {
		super(exp0, exp1, "AND");
	}
}