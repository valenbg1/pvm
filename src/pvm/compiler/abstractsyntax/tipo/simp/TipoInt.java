package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoInt extends Tipo {
	public static final Tipo TIPO = new TipoInt();
	
	@Override
	public void asignaEspacio() {
		tam = 1;
	}

	@Override
	public void chequea() {}
	
	@Override
	public boolean equals(Tipo other) {
		return other instanceof TipoInt;
	}

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