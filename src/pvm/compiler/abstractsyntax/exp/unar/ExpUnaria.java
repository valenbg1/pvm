package pvm.compiler.abstractsyntax.exp.unar;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public abstract class ExpUnaria extends Exp {
	protected String op;
	
	protected Exp exp;
	
	protected ExpUnaria(Exp exp, String op) {
		this.op = op;
		this.exp = exp;
	}

	@Override
	public void chequea() {
		exp.chequea();
		
		if ((exp.getTipo_infer() != null)) {
			Tipo tipo = operacionValida();
			
			if (tipo != null)
				tipo_infer = tipo;
		}
		
		if (tipo_infer == null)
			errorTiposNoValidos();
	}

	protected abstract void errorTiposNoValidos();

	public Exp getExp() {
		return exp;
	}
	
	
	public String getOp() {
		return op;
	}
	
	protected abstract Tipo operacionValida();
	
	@Override
	public String toString() {
		return "(" + op + " " + exp + ")";
	}

	@Override
	public void vincula() {
		exp.vincula();	
	}
}