package pvm.compiler.abstractsyntax.tipo;

import pvm.compiler.abstractsyntax.Node;

public abstract class Tipo implements Node {
	@Override
	public void vincula()  {
	}

	@Override
	public void vinculaDefPunteros()  {		
	}
	
	public abstract void simplificaDefTipos();
	public abstract boolean esNumero();
	public abstract boolean esBooleano();
	public abstract boolean esEntradaSalida();
	
	
}