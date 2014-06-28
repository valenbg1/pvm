package pvm.compiler.abstractsyntax;

import java.util.ArrayList;

import pvm.compiler.SymbolsTable;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.vm.instructions.Instruction;

public abstract class Node {
	public static SymbolsTable sym_t = null;
	public static int nivel;
	public static int dir;
	public static int cinst = 0;

	protected Tipo tipo_infer = null;
	protected Node vinculo = null;
	protected int row = -1;
	
	protected int n_dir;
	protected int n_nivel;
	
	protected ArrayList<Instruction> cod;
	protected int inicio;
	protected int fin;
	
	public ArrayList<Instruction> getCod() {
		return cod;
	}

	public void setCod(ArrayList<Instruction> cod) {
		this.cod = cod;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

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
	
	public abstract void codigo();
}