package pvm.compiler.abstractsyntax;

import java.util.List;

import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.seccion.SeccionSubprogramas;
import pvm.compiler.abstractsyntax.seccion.SeccionTipos;
import pvm.compiler.abstractsyntax.seccion.SeccionVariables;

public class Programa extends Node {
	private SeccionTipos sectipos;
	private SeccionVariables secvars;
	private SeccionSubprogramas secsubprogs;
	private List<Instruccion> instrs;

	public Programa(SeccionTipos sectipos, SeccionVariables secvars,
			SeccionSubprogramas secsubprogs, List<Instruccion> instrs) {
		super();

		this.sectipos = sectipos;
		this.secvars = secvars;
		this.secsubprogs = secsubprogs;
		this.instrs = instrs;

		this.childs.add(sectipos);
		this.childs.add(secvars);
		this.childs.add(secsubprogs);
		this.childs.add(new ListNode<Instruccion>(instrs));
	}

	public List<Instruccion> getInstrs() {
		return instrs;
	}

	public SeccionSubprogramas getSecsubprogs() {
		return secsubprogs;
	}

	public SeccionTipos getSectipos() {
		return sectipos;
	}

	public SeccionVariables getSecvars() {
		return secvars;
	}

	@Override
	public String toString() {
		String ret = "program ";

		ret += "\n" + sectipos + "\n" + secvars + "\n" + secsubprogs + "\n{\n";

		for (Instruccion instr : instrs)
			ret += "\t" + instr + "\n";

		return ret += "}";
	}
}