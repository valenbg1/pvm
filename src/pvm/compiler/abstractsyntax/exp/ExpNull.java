package pvm.compiler.abstractsyntax.exp;

import pvm.compiler.abstractsyntax.tipo.simp.TipoPointer;


public class ExpNull extends Exp {
	@Override
	public void chequea() {
		tipo_infer = TipoPointer.TipoPointerNull();
	}

	@Override
	public String toString() {
		return "NULL";
	}

	@Override
	public void vincula() {}
}