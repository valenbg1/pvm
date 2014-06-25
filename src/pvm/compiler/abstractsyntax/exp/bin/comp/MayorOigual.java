package pvm.compiler.abstractsyntax.exp.bin.comp;

import pvm.compiler.abstractsyntax.exp.Exp;

public class MayorOigual extends ExpBinComp {
	public MayorOigual(Exp exp0, Exp exp1) {
		super(exp0, exp1, ">=");
	}
}