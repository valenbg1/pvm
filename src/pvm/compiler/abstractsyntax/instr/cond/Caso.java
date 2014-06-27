package pvm.compiler.abstractsyntax.instr.cond;

import java.util.List;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class Caso extends Node {
	private Exp exp;
	private List<Instruccion> instrs;
	
	public Caso(Exp exp, List<Instruccion> instrs) {
		this.exp = exp;
		this.instrs = instrs;
	}

	@Override
	public void chequea() {
		if (!exp.getTipo_infer().esBooleano())
			ErrorsHandler.chequeaExpresionNoEsDeTipo("boolean", exp, row);
		
		for (Instruccion instr : instrs)
			instr.chequea();
	}

	public Exp getExp() {
		return exp;
	}

	public List<Instruccion> getInstrs() {
		return instrs;
	}

	@Override
	public void simplificaDefTipos() {}

	@Override
	public String toString() {
		String ret = exp + " : {\n";
		
		for (Instruccion inst : instrs)
			ret += "\t" + inst + "\n";
		
		ret += "}";
		
		return ret;
	}

	@Override
	public void vincula() {
		for (Instruccion instr : instrs)
			instr.vincula();
	}

	@Override
	public void vinculaDefPunteros() {}
}