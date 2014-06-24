package pvm.compiler.abstractsyntax.exp.unar.arithm;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.unar.ExpUnaria;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;
import pvm.compiler.exceptions.CheckFailException;

public class Menos extends ExpUnaria {
	public Menos(Exp exp) {
		super(exp, "-");
	}

	@Override
	public void chequea() throws CheckFailException {
		if((exp.getTipo() != TipoInt.TIPO) &&
				   (exp.getTipo() != TipoDouble.TIPO))
			throw new CheckFailException("Operación menos no soportada con tipo "+getExp().getTipo());
	}
}