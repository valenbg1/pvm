package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoPointer extends Tipo {
	public TipoPointer(Tipo tipo) {
		super();
		
		this.childs.add(tipo);
	}

	@Override
	public String toString() {
		return "pointer " + childs.get(0);
	}
}