package pvm.compiler.abstractsyntax.designador;

import pvm.compiler.abstractsyntax.Node;

public abstract class Designador extends Node {
	protected Node vinculo;
	
	public Designador() {
		super();
	}

	public Node getVinculo() {
		return vinculo;
	}

	public void setVinculo(Node vinculo) {
		this.vinculo = vinculo;
	}
}