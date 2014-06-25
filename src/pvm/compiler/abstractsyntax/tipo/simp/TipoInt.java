package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoInt extends Tipo {
	@Override
	public void chequea() {}

	@Override
	public boolean esInt() {
		return true;
	}
	
	@Override
	public Tipo tipoSimplificado() {
		return this;
	}

	@Override
	public String toString() {
		return "int";
	}

	@Override
	public void vincula() {}

	@Override
	public void vinculaDefPunteros() {}
}