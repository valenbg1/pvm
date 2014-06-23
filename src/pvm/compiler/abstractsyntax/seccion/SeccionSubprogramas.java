package pvm.compiler.abstractsyntax.seccion;

import java.util.List;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.subprog.DecSubprograma;

public class SeccionSubprogramas extends Node {
	public SeccionSubprogramas(List<DecSubprograma> decsubprogramas) {
		super();
		
		for (DecSubprograma decsubprograma : decsubprogramas)
			this.childs.add(decsubprograma);
	}

	@Override
	public String toString() {
		if (!childs.isEmpty()) {
			String ret = "subprogram\n";
			
			for (int i = 0; i < childs.size(); ++i)
				ret += "\t" + childs.get(i).toString() + ";\n";
			
			return ret;
		} else
			return "";
	}
}
