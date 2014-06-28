package pvm.compiler.abstractsyntax.subprog.param;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class ParamValor extends Parametro {
	public ParamValor(String id, Tipo tipo) {
		super(id, tipo);
	}
	
	@Override
	public boolean esValor() {
		return true;
	}

	@Override
	public void codigo() {
	}
}