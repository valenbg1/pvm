package pvm.compiler.abstractsyntax.tipo.comp;

import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.exceptions.CheckFailException;

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

	public Tipo getTipoBase() {
		return tipo;
	}

	@Override
	public void vincula() {
		this.getTipoBase().vincula();
	}

	@Override
	public void vinculaDefPunteros() {
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