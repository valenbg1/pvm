package pvm.compiler.abstractsyntax.seccion;

import java.util.List;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.subprog.DecSubprograma;

public class SeccionSubprogramas implements Node {
	private List<DecSubprograma> decsubprogramas;
	
	public SeccionSubprogramas(List<DecSubprograma> decsubprogramas) {
		this.decsubprogramas = decsubprogramas;
	}

	@Override
	public String toString() {
		if (!decsubprogramas.isEmpty()) {
			String ret = "SUBPROGRAMS\n";
			
			for (DecSubprograma decsp : decsubprogramas)
				ret += "\t" + decsp + ";\n";
			
			return ret;
		} else
			return "";
	}

	public List<DecSubprograma> getDecsubprogramas() {
		return decsubprogramas;
	}
}
