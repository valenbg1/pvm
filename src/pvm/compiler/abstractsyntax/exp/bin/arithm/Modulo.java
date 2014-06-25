package pvm.compiler.abstractsyntax.exp.bin.arithm;

import pvm.compiler.abstractsyntax.exp.Exp;

public class Modulo extends ExpBinArithm {
	public Modulo(Exp exp0, Exp exp1) {
		super(exp0, exp1, "%");
	}
}