package pvm.compiler.abstractsyntax.tipo;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.Node;

public class DecTipo implements Node {
	private String id;
	
	private Tipo tipo;
	
	private int row;
	
	public DecTipo(String id, Tipo tipo, int row) {
		this.id = id;
		
		this.row = row;
		
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return id + ": " + tipo + ";";
	}

	public String getId() {
		return id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public int getRow() {
		return row;
	}

	@Override
	public void vincula()  {
		this.getTipo().vincula();
		
		if (!sym_t.insertaId(this.getId(), this.getTipo()))
			ErrorsHandler.vinculaDuplicatedId(this.getId(), this.getRow());
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