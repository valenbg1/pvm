package pvm.compiler.abstractsyntax.seccion;

import java.util.List;

import pvm.compiler.abstractsyntax.ListNode;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.DecTipo;

public class SeccionVariables extends Node {
	private List<DecTipo> dectipos;
	
	public SeccionVariables(List<DecTipo> dectipos) {
		super();
		
		this.dectipos = dectipos;
		
		this.childs.add(new ListNode<DecTipo>(dectipos));
	}

	@Override
	public String toString() {
		if (!childs.isEmpty()) {
			String ret = "variables\n";
			
			for (DecTipo dectipo : dectipos)
				ret += "\t" + dectipo + ";\n";
			
			return ret;
		} else
			return "";
	}
	
	public List<DecTipo> getDectipos() {
		return dectipos;
	}
}