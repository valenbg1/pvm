package pvm.compiler.abstractsyntax.exp;

import pvm.compiler.abstractsyntax.designador.Designador;

public class ExpDesignador extends Exp {
	private Designador desig;
	
	public ExpDesignador(Designador desig) {
		this.desig = desig;
	}

	@Override
	public void chequea() {
		desig.chequea();
		
		tipo_infer = desig.getTipo_infer();
	}

	public Designador getDesig() {
		return desig;
	}

	@Override
	public String toString() {
		return desig.toString();
	}

	@Override
	public void vincula() {
		desig.vincula();
	}

	@Override
	public void codigo() {
		desig.codigo();
		cod = desig.getCod();
	}
}