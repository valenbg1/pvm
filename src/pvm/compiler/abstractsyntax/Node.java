package pvm.compiler.abstractsyntax;

import pvm.compiler.SymbolsTable;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public abstract class Node {
	public static SymbolsTable sym_t = null;
	
	protected Tipo tipo_infer = null;
	protected Node vinculo = null;
	protected int row = -1;
	
	public abstract void chequea();
	
	public boolean esParametro() {
		return false;
	}
	
	public boolean esVariable() {
		return false;
	}
	
	public int getRow() {
		return row;
	}
	
	public Tipo getTipo_infer() {
		return tipo_infer;
	}
	
	public Node getVinculo() {
		return vinculo;
	}
	
	public void setTipo_infer(Tipo tipo_infer) {
		this.tipo_infer = tipo_infer;
	}

	public void setVinculo(Node vinculo) {
		this.vinculo = vinculo;
	}

	public abstract void simplificaDefTipos();

	@Override
	public abstract String toString();

	public abstract void vincula();

	public abstract void vinculaDefPunteros();
}