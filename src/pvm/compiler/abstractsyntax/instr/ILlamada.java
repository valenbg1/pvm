package pvm.compiler.abstractsyntax.instr;

import java.util.List;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.exp.Exp;

public class ILlamada extends Instruccion {
	private String id;
	
	private List<Exp> args;
	
	private Node vinculo;
	private int row;
	
	public ILlamada(String id, List<Exp> args, int row) {
		this.id = id;
		
		this.args = args;
		
		this.row = row;
	}

	@Override
	public String toString() {
		String args_s = "";
		
		for (Exp arg : args)
			args_s += arg + ", ";
		
		return id + "(" + args_s + ")" + ";";
	}

	public String getId() {
		return id;
	}

	public List<Exp> getArgs() {
		return args;
	}

	public int getRow() {
		return row;
	}

	public Node getVinculo() {
		return vinculo;
	}

	public void setVinculo(Node vinculo) {
		this.vinculo = vinculo;
	}

	@Override
	public void vincula() {
		this.setVinculo(sym_t.declaracion(this.getId()));
		
		if (this.getVinculo() == null){
			ErrorsHandler.vinculaUndeclaredId(this.getId(), this.getRow());
			return;
		}
		
		for (Exp exp : this.getArgs())
			exp.vincula();
	}

	@Override
	public void vinculaDefPunteros() {
	}
}