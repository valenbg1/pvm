package pvm.compiler.abstractsyntax.exp.bool;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;

public class ExpTrue extends Exp {
	@Override
	public String toString() {
		return "TRUE";
	}
	
	@Override
	public void chequea() {
	}

	@Override
	public Tipo getTipo() {
		return TipoBoolean.TIPO;
	}
}