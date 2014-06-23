package pvm.compiler.abstractsyntax.tipo;

import pvm.compiler.abstractsyntax.Node;

public class DecTipo extends Node {
	private String id;
	
	private Tipo tipo;
	
	public DecTipo(String id, Tipo tipo) {
		super();
		
		this.id = id;
		
		this.tipo = tipo;
		
		this.childs.add(tipo);
	}

	@Override
	public String toString() {
		return id + " : " + tipo + ";";
	}

	public String getId() {
		return id;
	}

	public Tipo getTipo() {
		return tipo;
	}
}