package pvm.compiler.abstractsyntax.exp.bin.bool;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.bin.ExpBin;

public class Or extends ExpBin {
	public Or(Exp exp0, Exp exp1) {
		super(exp0, exp1, "OR");
	}
}