package pvm.compiler.abstractsyntax.subprog.param;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.exceptions.CheckFailException;

public abstract class Parametro extends Node {
	protected String id;
	
	protected Tipo tipo;
	
	protected Parametro(String id, Tipo tipo) {
		this.id = id;
		
		this.tipo = tipo;
	}
	
	@Override
	public boolean esParametro() {
		return true;
	}

	@Override
	public String toString() {
		return id + ": " + tipo;
	}

	public String getId() {
		return id;
	}

	public Tipo getTipo() {
		return tipo;
	}
	
	@Override
	public void vincula() {
		this.getTipo().vincula();
	}

	@Override
	public void vinculaDefPunteros() {
		this.getTipo().vinculaDefPunteros();
	}
	
	@Override
	public void chequea() {
		this.getTipo().chequea();
	}
}