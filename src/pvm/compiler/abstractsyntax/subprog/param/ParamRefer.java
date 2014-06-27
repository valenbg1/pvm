package pvm.compiler.abstractsyntax.subprog.param;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class ParamRefer extends Parametro {
	public ParamRefer(String id, Tipo tipo) {
		super(id, tipo);
	}
	
	@Override
	public boolean esRefer() {
		return true;
	}

	@Override
	public String toString() {
		return "& " + super.toString();
	}
}