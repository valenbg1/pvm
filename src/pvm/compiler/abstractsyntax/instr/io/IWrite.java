package pvm.compiler.abstractsyntax.instr.io;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;
import pvm.compiler.exceptions.CheckFailException;

public class IWrite extends Instruccion {
	private Exp exp;
	
	public IWrite(Exp exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "WRITE " + exp + ";";
	}

	public Exp getExp() {
		return exp;
	}

	@Override
	public void vincula() {
		this.getExp().vincula();
	}

	@Override
	public void vinculaDefPunteros() {	
	}

	@Override
	public void chequea() throws CheckFailException {
		if((exp.getTipo() != TipoBoolean.TIPO) &&
				   (exp.getTipo() != TipoDouble.TIPO)  &&
				   (exp.getTipo() != TipoInt.TIPO))
					throw new CheckFailException("El tipo "+exp.getTipo()+" no se puede escribir");
	}
}