package pvm.compiler.abstractsyntax.exp;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.exp.Exp;

public class ExpDesignador extends Exp {
	public ExpDesignador(Designador desig) {
		super();
		this.childs.add(desig);
	}

	@Override
	public String toString() {
		return childs.get(0).toString();
	}
}