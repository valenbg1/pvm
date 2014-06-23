package pvm.compiler.abstractsyntax.instr;

import java.util.List;

import pvm.compiler.abstractsyntax.exp.Exp;

public class ILlamada extends Instruccion {
	private String id;
	
	public ILlamada(String id, List<Exp> args) {
		super();
		
		this.id = id;
		
		for (Exp exp : args)
			this.childs.add(exp);
	}

	@Override
	public String toString() {
		String args = "";
		
		for (int i = 1; i < childs.size(); ++i)
			args += childs.get(i).toString() + ", ";
		
		args = args.subSequence(0, args.length()-2).toString();
		
		return id + "(" + args + ")" + ";";
	}

	public String getId() {
		return id;
	}
}