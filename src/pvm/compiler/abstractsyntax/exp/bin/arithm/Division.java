package pvm.compiler.abstractsyntax.exp.bin.arithm;

import pvm.compiler.abstractsyntax.exp.Exp;

public class Division extends ExpBinArithm {
	public Division(Exp exp0, Exp exp1) {
		super(exp0, exp1, "/");
	}
}