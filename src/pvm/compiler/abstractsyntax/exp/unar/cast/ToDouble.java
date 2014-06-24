package pvm.compiler.abstractsyntax.exp.unar.cast;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.unar.ExpUnaria;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;
import pvm.compiler.exceptions.CheckFailException;

public class ToDouble extends ExpUnaria {
	public ToDouble(Exp exp) {
		super(exp, "TODOUBLE");
	}

	@Override
	public void chequea() throws CheckFailException {
		if((exp.getTipo() != TipoDouble.TIPO)  &&
				   (exp.getTipo() != TipoInt.TIPO))
			throw new CheckFailException("casting de tipo "+exp.getTipo()+ " a double no soportado");
	}
	
	@Override
	public Tipo getTipo() {
		return TipoDouble.TIPO;
	}
}