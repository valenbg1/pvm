package pvm.compiler.abstractsyntax.instr.cond;

import java.util.List;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class Caso implements Node {
	private Exp exp;
	private List<Instruccion> instrs;
	
	public Caso(Exp exp, List<Instruccion> instrs) {
		this.exp = exp;
		this.instrs = instrs;
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