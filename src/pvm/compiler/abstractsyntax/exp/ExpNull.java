package pvm.compiler.abstractsyntax.exp;

import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.exceptions.CheckFailException;


public class ExpNull extends Exp {
	@Override
	public String toString() {
		return "NULL";
	}

	@Override
	public void vincula() {
	}

	@Override
	public void vinculaDefPunteros() {
	}

	@Override
	public void chequea() throws CheckFailException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tipo getTipo() {		
		// TODO Auto-generated method stub
		return null;
	}
}