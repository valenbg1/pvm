package pvm.compiler.abstractsyntax.exp.bool;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;

public class ExpFalse extends Exp {
	@Override
	public String toString() {
		return "FALSE";
	}

	@Override
	public void chequea() {
	}

	@Override
	public Tipo getTipo() {
		return TipoBoolean.TIPO;
	}
}