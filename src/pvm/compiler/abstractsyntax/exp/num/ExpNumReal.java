package pvm.compiler.abstractsyntax.exp.num;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;

public class ExpNumReal extends Exp {
	private double numreal;
	
	public ExpNumReal(double numreal) {
		this.numreal = numreal;
	}

	@Override
	public void chequea() {
		tipo_infer = new TipoDouble();
	}

	public double getNumReal() {
		return numreal;
	}

	@Override
	public String toString() {
		return Double.toString(numreal);
	}

	@Override
	public void vincula() {}
}