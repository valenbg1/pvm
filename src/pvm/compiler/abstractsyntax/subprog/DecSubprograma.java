package pvm.compiler.abstractsyntax.subprog;

import java.util.List;

import pvm.compiler.abstractsyntax.ListNode;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.seccion.SeccionSubprogramas;
import pvm.compiler.abstractsyntax.seccion.SeccionTipos;
import pvm.compiler.abstractsyntax.seccion.SeccionVariables;
import pvm.compiler.abstractsyntax.subprog.param.Parametro;

public class DecSubprograma extends Node {
	private String id;
	
	private List<Parametro> params;
	private SeccionTipos sectipos;
	private SeccionVariables secvars;
	private SeccionSubprogramas secsubprogs;
	private List<Instruccion> instrs;
	
	public DecSubprograma(List<Parametro> params, String id,
			SeccionTipos sectipos, SeccionVariables secvars,
			SeccionSubprogramas secsubprogs, List<Instruccion> instrs) {
		super();
		
		this.id = id;
		this.params = params;
		this.sectipos = sectipos;
		this.secvars = secvars;
		this.secsubprogs = secsubprogs;
		this.instrs = instrs;
		
		this.childs.add(new ListNode<Parametro>(params));
		this.childs.add(sectipos);
		this.childs.add(secvars);
		this.childs.add(secsubprogs);
		this.childs.add(new ListNode<Instruccion>(instrs));
	}

	@Override
	public String toString() {
		String ret = "SUBPROGRAM " + id + "(";
		
		for (Parametro param : params)
			ret += param + ", ";
		
		ret += ")\n\t" + sectipos + "\n\t" + secvars + "\n\t" + secsubprogs + "{\n";
		
		for (Instruccion instr : instrs)
			ret += "\t" + instr + "\n";
		
		return ret += "}";
	}

	public String getId() {
		return id;
	}

	public List<Parametro> getParams() {
		return params;
	}

	public SeccionTipos getSectipos() {
		return sectipos;
	}

	public SeccionVariables getSecvars() {
		return secvars;
	}

	public SeccionSubprogramas getSecsubprogs() {
		return secsubprogs;
	}

	public List<Instruccion> getInstrs() {
		return instrs;
	}
}