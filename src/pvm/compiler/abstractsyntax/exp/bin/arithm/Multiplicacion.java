package pvm.compiler.abstractsyntax.exp.bin.arithm;

import pvm.compiler.abstractsyntax.exp.Exp;

public class Multiplicacion extends ExpBinArithm {
	public Multiplicacion(Exp exp0, Exp exp1) {
		super(exp0, exp1, "*");
	}
}