package pvm.compiler.abstractsyntax.exp.bin.comp;

import pvm.compiler.abstractsyntax.exp.Exp;

public class MenorOigual extends ExpBinComp {
	public MenorOigual(Exp exp0, Exp exp1) {
		super(exp0, exp1, "<=");
	}
}