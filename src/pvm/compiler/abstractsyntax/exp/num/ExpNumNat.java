package pvm.compiler.abstractsyntax.exp.num;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;

public class ExpNumNat extends Exp {
	private int numnat;
	
	public ExpNumNat(int numnat) {
		this.numnat = numnat;
	}

	@Override
	public void chequea() {
		tipo_infer = new TipoInt();
	}

	public int getNumNat() {
		return numnat;
	}

	@Override
	public String toString() {
		return Integer.toString(numnat);
	}

	@Override
	public void vincula() {}
}