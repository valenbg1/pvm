package pvm.compiler.abstractsyntax.tipo.comp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoArray extends Tipo {
	private int num;
	
	public TipoArray(Tipo tipo, int num) {
		super();
		
		this.num = num;
		
		this.childs.add(tipo);
	}

	@Override
	public String toString() {
		return "array " + childs.get(0) + "[" + num + "]";
	}

	public int getNum() {
		return num;
	}
}