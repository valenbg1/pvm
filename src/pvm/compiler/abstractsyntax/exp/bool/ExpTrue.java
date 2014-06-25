package pvm.compiler.abstractsyntax.exp.bool;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;

public class ExpTrue extends Exp {
	@Override
	public void chequea() {
		tipo_infer = new TipoBoolean();
	}

	@Override
	public String toString() {
		return "TRUE";
	}

	@Override
	public void vincula() {}
}