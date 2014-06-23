package pvm.compiler.abstractsyntax.seccion;

import java.util.List;

import pvm.compiler.abstractsyntax.ListNode;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.subprog.DecSubprograma;

public class SeccionSubprogramas extends Node {
	private List<DecSubprograma> decsubprogramas;
	
	public SeccionSubprogramas(List<DecSubprograma> decsubprogramas) {
		super();
		
		this.decsubprogramas = decsubprogramas;
		
		this.childs.add(new ListNode<DecSubprograma>(decsubprogramas));
	}

	@Override
	public String toString() {
		if (!childs.isEmpty()) {
			String ret = "subprogram\n";
			
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
