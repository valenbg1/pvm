package pvm.compiler.abstractsyntax.subprog;

import java.util.List;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.seccion.SeccionSubprogramas;
import pvm.compiler.abstractsyntax.seccion.SeccionTipos;
import pvm.compiler.abstractsyntax.seccion.SeccionVariables;
import pvm.compiler.abstractsyntax.subprog.param.Parametro;

public class DecSubprograma extends Node {
	private String id;
	
	public DecSubprograma(List<Parametro> params, String id,
			SeccionTipos sectipos, SeccionVariables secvars,
			SeccionSubprogramas secsubprogs, List<Instruccion> instrs) {
		super();
		
		this.id = id;
		
		for (Parametro param : params)
			this.childs.add(param);
		
		this.childs.add(sectipos);
		this.childs.add(secvars);
		this.childs.add(secsubprogs);
		
		for (Instruccion instr : instrs)
			this.childs.add(instr);
	}

	@Override
	public String toString() {
		int i = 0;
		String ret = "subprogram " + id + "(";
		
		for (; (i < childs.size()) && (childs.get(i) instanceof Parametro); ++i)
			ret += childs.get(i).toString() + ", ";
		
		ret = ret.subSequence(0, ret.length()-2).toString();
		ret += ")\n" + childs.get(i++) + "\n" + childs.get(i++) + "\n" + childs.get(i++) + "\n{\n";
		
		for (; (i < childs.size()) && (childs.get(i) instanceof Instruccion); ++i)
			ret += "\t" + childs.get(i).toString() + "\n";
		
		return ret += "}";
	}

	public String getId() {
		return id;
	}
}