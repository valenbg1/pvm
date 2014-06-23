package pvm.compiler.abstractsyntax.exp.unar.arithm;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.unar.ExpUnaria;

public class Menos extends ExpUnaria {
	public Menos(Exp exp) {
		super(exp, "-");
	}
}