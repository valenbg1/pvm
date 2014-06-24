package pvm.compiler.abstractsyntax.exp.bin.arithm;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.bin.ExpBin;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;
import pvm.compiler.exceptions.CheckFailException;

public class Modulo extends ExpBin {
	public Modulo(Exp exp0, Exp exp1) {
		super(exp0, exp1, "%");
	}

	@Override
	public void chequea() throws CheckFailException {
		if(exp0.getTipo() != TipoInt.TIPO || exp1.getTipo() != TipoInt.TIPO )
			throw new CheckFailException("modulo entre no enteros");
		
	}

	@Override
	public Tipo getTipo() {
		return TipoInt.TIPO;
	}
}