package pvm.compiler.abstractsyntax.exp.bin.comp;

import pvm.compiler.abstractsyntax.exp.Exp;

public class Mayor extends ExpBinComp {
	public Mayor(Exp exp0, Exp exp1) {
		super(exp0, exp1, ">");
	}
}