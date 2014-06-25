package pvm.compiler.abstractsyntax.exp.bin.comp;

import pvm.compiler.abstractsyntax.exp.Exp;

public class Desigualdad extends ExpBinComp {
	public Desigualdad(Exp exp0, Exp exp1) {
		super(exp0, exp1, "!=");
	}
}