package pvm.compiler.abstractsyntax.seccion;

import java.util.List;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.DecTipo;

public class SeccionVariables implements Node {
	private List<DecTipo> dectipos;
	
	public SeccionVariables(List<DecTipo> dectipos) {
		this.dectipos = dectipos;
	}

	@Override
	public String toString() {
		if (!dectipos.isEmpty()) {
			String ret = "VARIABLES\n";
			
			for (DecTipo dectipo : dectipos)
				ret += "\t" + dectipo + "\n";
			
			return ret;
		} else
			return "";
	}
	
	public List<DecTipo> getDectipos() {
		return dectipos;
	}
}
