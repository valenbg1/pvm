package pvm.compiler.abstractsyntax.tipo.comp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoArray extends Tipo {
	private int num;
	
	private Tipo tipo;
	
	public TipoArray(Tipo tipo, int num) {
		super();
		
		this.num = num;
		
		this.tipo = tipo;
		
		this.childs.add(tipo);
	}

	@Override
	public String toString() {
		return "array " + tipo + "[" + num + "]";
	}

	public int getNum() {
		return num;
	}

	public Tipo getTipo() {
		return tipo;
	}
}