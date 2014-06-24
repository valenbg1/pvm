package pvm.compiler.abstractsyntax.exp;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public abstract class Exp implements Node {
	@Override
	public void vincula() {
	}

	@Override
	public void vinculaDefPunteros() {
	}
	
	public abstract Tipo getTipo();
}