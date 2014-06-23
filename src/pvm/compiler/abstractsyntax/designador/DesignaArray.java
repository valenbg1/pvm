package pvm.compiler.abstractsyntax.designador;

import pvm.compiler.abstractsyntax.exp.Exp;

public class DesignaArray extends Designador {
	public DesignaArray(Designador desig, Exp exp) {
		super();
		
		this.childs.add(desig);
		this.childs.add(exp);
	}

	@Override
	public String toString() {
		return childs.get(0) + "[" + childs.get(1) + "]";
	}
}