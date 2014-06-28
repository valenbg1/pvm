package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoDouble extends Tipo {
	@Override
	public void asignaEspacio() {
		tam = 1;
	}

	@Override
	public void chequea() {}
	
	@Override
	public boolean equals(Tipo other) {
		return other instanceof TipoDouble;
	}

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