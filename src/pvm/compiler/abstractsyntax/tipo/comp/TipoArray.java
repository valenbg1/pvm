package pvm.compiler.abstractsyntax.tipo.comp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoArray extends Tipo {
	private int num;
	
	private Tipo tipo;
	
	public TipoArray(Tipo tipo, int num) {
		this.num = num;
		
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "ARRAY " + tipo + "[" + num + "]";
	}

	public int getNum() {
		return num;
	}

	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public void vincula() {
		this.getTipo().vincula();
	}

	@Override
	public void vinculaDefPunteros() {
		this.getTipo().vinculaDefPunteros();
	}
}