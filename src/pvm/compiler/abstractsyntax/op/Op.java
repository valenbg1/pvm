package pvm.compiler.abstractsyntax.op;

import pvm.compiler.abstractsyntax.Node;

public abstract class Op extends Node {
	protected String op;

	protected Op(String op) {
		super();

		this.op = op;
	}

	public String getOp() {
		return op;
	}

	@Override
	public String toString() {
		return op;
	}
}