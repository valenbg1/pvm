package pvm.compiler.abstractsyntax.exp.unar.bool;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.unar.ExpUnaria;

public class Not extends ExpUnaria {
	public Not(Exp exp) {
		super(exp, "not");
	}
}