package pvm.compiler.abstractsyntax.exp.bin.comp;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.bin.ExpBin;

public class MenorOigual extends ExpBin {
	public MenorOigual(Exp exp0, Exp exp1) {
		super(exp0, exp1, "<=");
	}
}