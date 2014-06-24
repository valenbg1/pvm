package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoPointer extends Tipo {
	private Tipo tipo;
	
	private Node vinculo;
	private int row;
	
	public TipoPointer(Tipo tipo, int row) {
		this.row = row;
		
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "pointer " + tipo;
	}

	public Tipo getTipo() {
		return tipo;
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

	@Override
	public void vincula() {
		if (!(this.getTipo() instanceof TipoId))
			this.getTipo().vincula();
		
	}

	@Override
	public void vinculaDefPunteros() {
		if (this.getTipo() instanceof TipoId)
			this.getTipo().vincula();
		else
			this.getTipo().vinculaDefPunteros();
		
	}

	@Override
	public void chequea() {
		this.getTipo().chequea();
	}
}