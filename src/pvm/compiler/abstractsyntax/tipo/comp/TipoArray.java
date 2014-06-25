package pvm.compiler.abstractsyntax.tipo.comp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoArray extends Tipo {
	private int num;
	
	public TipoArray(Tipo tipo, int num) {
		this.num = num;
		
		this.tipo_infer = tipo;
	}

	@Override
	public void chequea() {
		tipo_infer.chequea();
	}

	@Override
	public boolean esArray() {
		return true;
	}

	public int getNum() {
		return num;
	}

	@Override
	public Tipo tipoSimplificado() {
		tipo_infer = tipo_infer.tipoSimplificado();
		
		return this;
	}

	@Override
	public String toString() {
		return "ARRAY " + tipo_infer + "[" + num + "]";
	}
	
	@Override
	public void vincula() {
		tipo_infer.vincula();
	}

	@Override
	public void vinculaDefPunteros() {
		tipo_infer.vinculaDefPunteros();
	}
}