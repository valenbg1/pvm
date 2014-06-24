package pvm.compiler.abstractsyntax.exp.bin.bool;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.bin.ExpBin;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;
import pvm.compiler.exceptions.CheckFailException;

public class Or extends ExpBin {
	public Or(Exp exp0, Exp exp1) {
		super(exp0, exp1, "OR");
	}
	
	
	@Override
	public void chequea() throws CheckFailException {
		if(!exp0.getTipo().esBooleano() || !exp0.getTipo().esBooleano())
			throw new CheckFailException("no se pueden OR cosas no Boool ");
	}

	@Override
	public Tipo getTipo() {
		return TipoBoolean.TIPO;
	}
}