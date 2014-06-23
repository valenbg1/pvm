package pvm.compiler.abstractsyntax.exp.bin;

import pvm.compiler.abstractsyntax.exp.Exp;

public abstract class ExpBin extends Exp {
	protected String op;
	
	public ExpBin(Exp exp0, Exp exp1, String op) {
		super();
		
		this.op = op;
		
		this.childs.add(exp0);
		this.childs.add(exp1);
	}

	@Override
	public String toString() {
		return childs.get(0).toString() + " " + op + " " + childs.get(1).toString();
	}

	public String getOp() {
		return op;
	}
}