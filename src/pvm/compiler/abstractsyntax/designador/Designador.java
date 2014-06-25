package pvm.compiler.abstractsyntax.designador;

import pvm.compiler.abstractsyntax.Node;

public abstract class Designador extends Node {
	@Override
	public void simplificaDefTipos() {}
	
	@Override
	public void vinculaDefPunteros() {}
}