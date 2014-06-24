package pvm.compiler.abstractsyntax.instr;

import java.util.List;

import pvm.compiler.abstractsyntax.ListNode;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.exp.Exp;

public class ILlamada extends Instruccion {
	private String id;
	
	private List<Exp> args;
	
	private Node vinculo;
	private int vinculo_row, vinculo_col;
	
	public ILlamada(String id, List<Exp> args) {
		super();
		
		this.id = id;
		
		this.args = args;
		
		this.childs.add(new ListNode<Exp>(args));
	}

	@Override
	public String toString() {
		String args_s = "";
		
		for (Exp arg : args)
			args_s += arg + ", ";
		
		args_s = args_s.subSequence(0, args_s.length()-2).toString();
		
		return id + "(" + args_s + ")" + ";";
	}

	public String getId() {
		return id;
	}

	public List<Exp> getArgs() {
		return args;
	}

	public Node getVinculo() {
		return vinculo;
	}

	public void setVinculo(Node vinculo) {
		this.vinculo = vinculo;
	}

	public int getVinculo_row() {
		return vinculo_row;
	}

	public void setVinculo_row(int vinculo_row) {
		this.vinculo_row = vinculo_row;
	}

	public int getVinculo_col() {
		return vinculo_col;
	}

	public void setVinculo_col(int vinculo_col) {
		this.vinculo_col = vinculo_col;
	}
}