package pvm.compiler.abstractsyntax;

import java.util.List;

import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.seccion.SeccionSubprogramas;
import pvm.compiler.abstractsyntax.seccion.SeccionTipos;
import pvm.compiler.abstractsyntax.seccion.SeccionVariables;

public class Programa extends Node {
	public Programa(SeccionTipos sectipos, SeccionVariables secvars,
			SeccionSubprogramas secsubprogs, List<Instruccion> instrs) {
		super();
		
		this.childs.add(sectipos);
		this.childs.add(secvars);
		this.childs.add(secsubprogs);
		
		for (Instruccion instr : instrs)
			this.childs.add(instr);
	}

	@Override
	public String toString() {
		String ret = "program " + "\n";
		
		ret += childs.get(0) + "\n" + childs.get(1) + "\n" + childs.get(2) + "\n{\n";
		
		for (int i = 3; i < childs.size(); ++i)
			ret += "\t" + childs.get(i).toString() + "\n";
		
		return ret += "}";
	}
}