package pvm.compiler.abstractsyntax.exp.bin.arithm;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.bin.ExpBin;

public class Multiplicacion extends ExpBin {
	public Multiplicacion(Exp exp0, Exp exp1) {
		super(exp0, exp1, "*");
	}
}