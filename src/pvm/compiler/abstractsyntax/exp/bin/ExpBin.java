package pvm.compiler.abstractsyntax.exp.bin;

import java.util.ArrayList;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.vm.instructions.Instruction;

public abstract class ExpBin extends Exp {
	protected String op;
	
	protected Exp exp0;
	protected Exp exp1;
	
	protected ExpBin(Exp exp0, Exp exp1, String op) {
		this.op = op;
		this.exp0 = exp0;
		this.exp1 = exp1;
	}

	@Override
	public void chequea() {
		exp0.chequea();
		exp1.chequea();
		
		if ((exp0.getTipo_infer() != null) &&
				(exp1.getTipo_infer() != null)) {
			Tipo tipo = operacionValida();
			
			if (tipo != null)
				tipo_infer = tipo;
		}
		
		if (tipo_infer == null)
			errorTiposNoValidos();
	}

	protected abstract void errorTiposNoValidos();

	public Exp getExp0() {
		return exp0;
	}

	public Exp getExp1() {
		return exp1;
	}
	
	public String getOp() {
		return op;
	}
	
	protected abstract Tipo operacionValida();
	
	@Override
	public String toString() {
		return "(" + exp0 + " " + op + " " + exp1 + ")";
	}

	@Override
	public void vincula() {
		exp0.vincula();
		exp1.vincula();	
	}
	
	@Override
	public void codigo() {
		exp0.codigo();
		exp1.codigo();
		cinst += exp0.numInstruccionesAccesoValor() + exp1.numInstruccionesAccesoValor();
		cinst++;
		
		cod = new ArrayList<Instruction>();
		
		cod.addAll(exp0.getCod());
		cod.addAll(exp0.codigoAccesoAlValor());
		cod.addAll(exp1.getCod());
		cod.addAll(exp0.codigoAccesoAlValor());
		
		cod.add(codigoDeOperacion());
	}
	
	protected abstract Instruction codigoDeOperacion();
}