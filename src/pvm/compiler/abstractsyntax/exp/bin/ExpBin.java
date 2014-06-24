package pvm.compiler.abstractsyntax.exp.bin;

import pvm.compiler.abstractsyntax.exp.Exp;

public abstract class ExpBin extends Exp {
	protected String op;
	
	protected Exp exp0;
	protected Exp exp1;
	
	public ExpBin(Exp exp0, Exp exp1, String op) {
		super();
		
		this.op = op;
		this.exp0 = exp0;
		this.exp1 = exp1;
		
		this.childs.add(exp0);
		this.childs.add(exp1);
	}

	@Override
	public String toString() {
		return "(" + exp0 + " " + op + " " + exp1 + ")";
	}

	public String getOp() {
		return op;
	}

	public Exp getExp0() {
		return exp0;
	}

	public Exp getExp1() {
		return exp1;
	}
}