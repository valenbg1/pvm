package pvm.compiler.abstractsyntax.tipo;

import pvm.compiler.abstractsyntax.Node;

public class DecTipo extends Node {
	private String id;
	
	public DecTipo(String id, Tipo tipo) {
		super();
		
		this.id = id;
		
		this.childs.add(tipo);
	}

	@Override
	public String toString() {
		return id + " : " + childs.get(0) + ";";
	}

	public String getId() {
		return id;
	}
}