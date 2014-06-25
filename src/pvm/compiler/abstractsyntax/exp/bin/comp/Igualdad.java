package pvm.compiler.abstractsyntax.exp.bin.comp;

import pvm.compiler.abstractsyntax.exp.Exp;

public class Igualdad extends ExpBinComp {
	public Igualdad(Exp exp0, Exp exp1) {
		super(exp0, exp1, "==");
	}
}