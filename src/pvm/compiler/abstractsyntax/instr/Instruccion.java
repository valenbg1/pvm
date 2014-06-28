package pvm.compiler.abstractsyntax.instr;

import pvm.compiler.abstractsyntax.Node;

public abstract class Instruccion extends Node {
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