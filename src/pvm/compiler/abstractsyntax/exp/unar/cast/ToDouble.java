package pvm.compiler.abstractsyntax.exp.unar.cast;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.unar.ExpUnaria;

public class ToDouble extends ExpUnaria {
	public ToDouble(Exp exp) {
		super(exp, "TODOUBLE");
	}
}