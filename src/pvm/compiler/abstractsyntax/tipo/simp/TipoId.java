package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoId extends Tipo {
	public TipoId(String id) {
		this.id = id;
	}

	private String id;

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}
}