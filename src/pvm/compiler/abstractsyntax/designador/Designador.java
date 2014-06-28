package pvm.compiler.abstractsyntax.designador;

import pvm.compiler.abstractsyntax.Node;

public abstract class Designador extends Node {
	@Override
	public int anidamientoDe() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void asignaEspacio() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void simplificaDefTipos() {}
	
	@Override
	public void vinculaDefPunteros() {}
}