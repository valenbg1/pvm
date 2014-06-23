package pvm.compiler.abstractsyntax.exp.unar;

import pvm.compiler.abstractsyntax.exp.Exp;

public abstract class ExpUnaria extends Exp {
	protected String op;
	
	public ExpUnaria(Exp exp, String op) {
		super();
		
		this.op = op;
		
		this.childs.add(exp);
	}

	@Override
	public String toString() {
		return op + " " + childs.get(0);
	}

	public String getOp() {
		return op;
	}
}