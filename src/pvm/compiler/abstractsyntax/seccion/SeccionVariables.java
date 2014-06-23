package pvm.compiler.abstractsyntax.seccion;

import java.util.List;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.DecTipo;

public class SeccionVariables extends Node {
	public SeccionVariables(List<DecTipo> dectipos) {
		super();
		
		for (DecTipo dectipo : dectipos)
			this.childs.add(dectipo);
	}

	@Override
	public String toString() {
		if (!childs.isEmpty()) {
			String ret = "variables\n";
			
			for (int i = 0; i < childs.size(); ++i)
				ret += "\t" + childs.get(i).toString() + ";\n";
			
			return ret;
		} else
			return "";
	}
}
