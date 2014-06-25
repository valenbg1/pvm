package pvm.compiler.abstractsyntax.exp;

import pvm.compiler.abstractsyntax.Node;

public abstract class Exp extends Node {
	@Override
	public void simplificaDefTipos() {}
	
	@Override
	public void vinculaDefPunteros() {}
}