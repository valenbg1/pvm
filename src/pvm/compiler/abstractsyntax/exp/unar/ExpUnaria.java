package pvm.compiler.abstractsyntax.exp.unar;

import pvm.compiler.abstractsyntax.exp.Exp;

public abstract class ExpUnaria extends Exp {
	protected String op;
	
	protected Exp exp;
	
	protected ExpUnaria(Exp exp, String op) {
		this.op = op;
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "(" + op + " " + exp + ")";
	}

	public String getOp() {
		return op;
	}

	public Exp getExp() {
		return exp;
	}
	
	@Override
	public void vincula() {
		this.getExp().vincula();
	}
	
	@Override
	public void vinculaDefPunteros() {
	}
}