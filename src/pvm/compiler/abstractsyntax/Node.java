package pvm.compiler.abstractsyntax;

import pvm.compiler.SymbolsTable;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public abstract class Node {
	public static SymbolsTable sym_t = null;
	public static int nivel;
	public static int dir;
	
	protected Tipo tipo_infer = null;
	protected Node vinculo = null;
	protected int row = -1;
	
	protected int n_dir;
	protected int n_nivel;
	
	public abstract int anidamientoDe();
	
	public abstract void asignaEspacio();
	
	public abstract void chequea();
	
	public boolean esParametro() {
		return false;
	}
	
	public boolean esVariable() {
		return false;
	}
	
	public int getN_dir() {
		return n_dir;
	}
	
	public int getN_nivel() {
		return n_nivel;
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

	public void setN_dir(int n_dir) {
		this.n_dir = n_dir;
	}

	public void setN_nivel(int n_nivel) {
		this.n_nivel = n_nivel;
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