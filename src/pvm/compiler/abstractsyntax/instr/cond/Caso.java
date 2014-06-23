package pvm.compiler.abstractsyntax.instr.cond;

import java.util.List;

import pvm.compiler.abstractsyntax.ListNode;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class Caso extends Node {
	private Exp exp;
	private List<Instruccion> instrs;
	
	public Caso(Exp exp, List<Instruccion> instrs) {
		super();
		
		this.exp = exp;
		this.instrs = instrs;
		
		this.childs.add(exp);
		this.childs.add(new ListNode<Instruccion>(instrs));
	}

	@Override
	public String toString() {
		String ret = exp + " : {\n";
		
		for (Instruccion inst : instrs)
			ret += "\t" + inst + "\n";
		
		ret += "}";
		
		return ret;
	}

	public Exp getExp() {
		return exp;
	}

	public List<Instruccion> getInstrs() {
		return instrs;
	}
}