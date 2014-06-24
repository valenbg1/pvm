package pvm.compiler.abstractsyntax.exp.bin.bool;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.bin.ExpBin;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;
import pvm.compiler.exceptions.CheckFailException;

public class And extends ExpBin {
	public And(Exp exp0, Exp exp1) {
		super(exp0, exp1, "AND");
	}
	
	@Override
	public void chequea() throws CheckFailException {
		if(!exp0.getTipo().esBooleano() || !exp0.getTipo().esBooleano())
			throw new CheckFailException("no se pueden AND cosas no Boool ");
	}

	@Override
	public Tipo getTipo() {
		return TipoBoolean.TIPO;
	}
}