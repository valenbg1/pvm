package pvm.compiler.abstractsyntax.exp.bool;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;

public class ExpFalse extends Exp {
	@Override
	public void chequea() {
		tipo_infer = new TipoBoolean();
	}

	@Override
	public String toString() {
		return "FALSE";
	}

	@Override
	public void vincula() {}
}