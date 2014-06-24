package pvm.compiler.abstractsyntax.exp.bin.arithm;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.bin.ExpBin;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;
import pvm.compiler.exceptions.CheckFailException;

public class Multiplicacion extends ExpBin {
	public Multiplicacion(Exp exp0, Exp exp1) {
		super(exp0, exp1, "*");
	}

	@Override
	public void chequea() throws CheckFailException {
		if(!exp0.getTipo().esNumero() || !exp0.getTipo().esNumero())
			throw new CheckFailException("no se pueden multiplicar cosas no numéricas ");
	}

	@Override
	public Tipo getTipo() {
		if(exp0.getTipo() == TipoDouble.TIPO || exp1.getTipo() == TipoDouble.TIPO )
			return TipoDouble.TIPO;
		else
			return exp0.getTipo();
	}
}