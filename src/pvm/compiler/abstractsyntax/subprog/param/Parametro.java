package pvm.compiler.abstractsyntax.subprog.param;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public abstract class Parametro extends Node {
	protected String id;
	
	protected Tipo tipo;
	
	protected Parametro(String id, Tipo tipo) {
		super();
		
		this.id = id;
		
		this.tipo = tipo;
		
		this.childs.add(tipo);
	}

	@Override
	public String toString() {
		return id + " : " + tipo;
	}

	public String getId() {
		return id;
	}

	public Tipo getTipo() {
		return tipo;
	}
}