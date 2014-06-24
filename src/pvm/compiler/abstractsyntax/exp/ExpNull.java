package pvm.compiler.abstractsyntax.exp;


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
}