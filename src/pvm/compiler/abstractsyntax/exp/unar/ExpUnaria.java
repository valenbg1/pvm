package pvm.compiler.abstractsyntax.exp.unar;

import pvm.compiler.abstractsyntax.exp.Exp;

public abstract class ExpUnaria extends Exp {
	protected String op;
	
	protected Exp exp;
	
	public ExpUnaria(Exp exp, String op) {
		super();
		
		this.op = op;
		this.exp = exp;
		
		this.childs.add(exp);
	}

	@Override
	public String toString() {
		return op + " " + exp;
	}

	public String getOp() {
		return op;
	}

	public Exp getExp() {
		return exp;
	}
}