package pvm.compiler.abstractsyntax.exp.unar.cast;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.unar.ExpUnaria;

public class ToInt extends ExpUnaria {
	public ToInt(Exp exp) {
		super(exp, "toint");
	}
}