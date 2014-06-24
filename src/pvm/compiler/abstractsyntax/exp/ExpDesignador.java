package pvm.compiler.abstractsyntax.exp;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.exceptions.CheckFailException;

public class ExpDesignador extends Exp {
	private Designador desig;
	
	public ExpDesignador(Designador desig) {
		this.desig = desig;
	}

	@Override
	public String toString() {
		return desig.toString();
	}

	public Designador getDesig() {
		return desig;
	}

	@Override
	public void vincula() {
		this.getDesig().vincula();
	}

	@Override
	public void vinculaDefPunteros() {
	}

	@Override
	public void chequea() throws CheckFailException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tipo getTipo() {
		return getDesig().getTipo();
	}
}