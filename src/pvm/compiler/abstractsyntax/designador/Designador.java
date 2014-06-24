package pvm.compiler.abstractsyntax.designador;

import pvm.compiler.abstractsyntax.Node;

public abstract class Designador extends Node {
	protected Node vinculo;
	protected int vinculo_row, vinculo_col;
	
	public Designador() {
		super();
	}

	public Node getVinculo() {
		return vinculo;
	}

	public void setVinculo(Node vinculo) {
		this.vinculo = vinculo;
	}

	public int getVinculo_row() {
		return vinculo_row;
	}

	public void setVinculo_row(int vinculo_row) {
		this.vinculo_row = vinculo_row;
	}

	public int getVinculo_col() {
		return vinculo_col;
	}

	public void setVinculo_col(int vinculo_col) {
		this.vinculo_col = vinculo_col;
	}
}