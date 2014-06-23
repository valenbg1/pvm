package pvm.compiler.abstractsyntax.exp;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.exp.Exp;

public class ExpDesignador extends Exp {
	private Designador desig;
	
	public ExpDesignador(Designador desig) {
		super();
		
		this.desig = desig;
		
		this.childs.add(desig);
	}

	@Override
	public String toString() {
		return desig.toString();
	}

	public Designador getDesig() {
		return desig;
	}
}