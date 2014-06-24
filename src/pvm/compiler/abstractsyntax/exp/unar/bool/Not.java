package pvm.compiler.abstractsyntax.exp.unar.bool;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.unar.ExpUnaria;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;
import pvm.compiler.exceptions.CheckFailException;

public class Not extends ExpUnaria {
	public Not(Exp exp) {
		super(exp, "NOT");
	}

	@Override
	public void chequea() throws CheckFailException {
		if(getExp().getTipo() != TipoBoolean.TIPO)
			throw new CheckFailException("Expected type "+TipoBoolean.TIPO.toString());
	}
}