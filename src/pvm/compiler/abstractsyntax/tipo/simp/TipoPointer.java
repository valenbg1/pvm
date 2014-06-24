package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.exceptions.CheckFailException;

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

	public Tipo getTipoBase() {
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
		if (!(this.getTipoBase() instanceof TipoId))
			this.getTipoBase().vincula();
		
	}

	@Override
	public void vinculaDefPunteros() {
		if (this.getTipoBase() instanceof TipoId)
			this.getTipoBase().vincula();
		else
			this.getTipoBase().vinculaDefPunteros();
		
	}

	@Override
	public void chequea() throws CheckFailException {
		this.getTipoBase().chequea();
	}

	@Override
	public void simplificaDefTipos() {
		this.getTipoBase().simplificaDefTipos();
	}
}