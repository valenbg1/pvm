package pvm.compiler.abstractsyntax.subprog.param;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public abstract class Parametro extends Node {
	private String id;
	
	protected Parametro(String id, Tipo tipo) {
		super();
		
		this.id = id;
		
		this.childs.add(tipo);
	}

	@Override
	public String toString() {
		return id + " : " + childs.get(0).toString();
	}

	public String getId() {
		return id;
	}
}