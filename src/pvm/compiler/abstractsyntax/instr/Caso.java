package pvm.compiler.abstractsyntax.instr;

import java.util.List;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.exp.Exp;

public class Caso extends Node {
	public Caso(Exp exp, List<Instruccion> instrs) {
		super();
		
		this.childs.add(exp);
		
		for (Instruccion inst : instrs)
			this.childs.add(inst);
	}

	@Override
	public String toString() {
		String ret = childs.get(0).toString() + " : {\n";
		
		for (int i = 1; i < childs.size(); ++i)
			ret += "\t" + childs.get(i).toString() + "\n";
		
		ret += "}";
		
		return ret;
	}
}