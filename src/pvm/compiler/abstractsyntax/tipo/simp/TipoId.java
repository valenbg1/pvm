package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoId extends Tipo {
	private Node vinculo;
	private int row;
	
	public TipoId(String id, int row) {
		this.row = row;
		
		this.id = id;
	}

	private String id;

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}

	public Node getVinculo() {
		return vinculo;
	}

	public void setVinculo(Node vinculo) {
		this.vinculo = vinculo;
	}

	public int getRow() {
		return row;
	}
}