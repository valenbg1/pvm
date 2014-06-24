package pvm.compiler.abstractsyntax.designador;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.Node;

public class DesignaId extends Designador {
	private Node vinculo;
	
	private String id;
	
	private int row;
	
	public DesignaId(String id, int row) {
		this.row = row;
		
		this.id = id;
	}
	
	public Node getVinculo() {
		return vinculo;
	}

	@Override
	public String toString() {
		return id;
	}

	public String getId() {
		return id;
	}

	public int getRow() {
		return row;
	}

	public void setVinculo(Node vinculo) {
		this.vinculo = vinculo;
	}

	@Override
	public void vincula() {
		this.setVinculo(sym_t.declaracion(this.getId()));
		
		if (this.getVinculo() == null)
			ErrorsHandler.vinculaUndeclaredId(this.getId(), this.getRow());
	}

	@Override
	public void vinculaDefPunteros() {	
	}
}