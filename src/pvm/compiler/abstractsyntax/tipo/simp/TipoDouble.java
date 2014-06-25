package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoDouble extends Tipo {
	@Override
	public void chequea() {}

	@Override
	public boolean esDouble() {
		return true;
	}
	
	@Override
	public Tipo tipoSimplificado() {
		return this;
	}

	@Override
	public String toString() {
		return "double";
	}

	@Override
	public void vincula() {}

	@Override
	public void vinculaDefPunteros() {}
}