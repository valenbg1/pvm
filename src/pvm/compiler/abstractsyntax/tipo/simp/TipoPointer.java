package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoPointer extends Tipo {
	private Tipo tipo;
	
	public TipoPointer(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "pointer " + tipo;
	}

	public Tipo getTipo() {
		return tipo;
	}
}