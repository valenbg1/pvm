package pvm.compiler.abstractsyntax.exp.bin.comp;

import pvm.compiler.abstractsyntax.exp.Exp;

public class Menor extends ExpBinComp {
	public Menor(Exp exp0, Exp exp1) {
		super(exp0, exp1, "<");
	}
}