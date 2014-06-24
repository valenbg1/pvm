package pvm.compiler.abstractsyntax.seccion;

import java.util.List;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.exceptions.CheckFailException;

public class SeccionTipos implements Node {
	private List<DecTipo> dectipos;
	
	public SeccionTipos(List<DecTipo> dectipos) {
		this.dectipos = dectipos;
	}

	@Override
	public String toString() {
		if (!dectipos.isEmpty()) {
			String ret = "TYPES\n";
			
			for (DecTipo dectipo : dectipos)
				ret += "\t" + dectipo + "\n";
			
			return ret;
		} else
			return "";
	}

	public List<DecTipo> getDectipos() {
		return dectipos;
	}

	@Override
	public void vincula() {	
	}

	@Override
	public void vinculaDefPunteros() {	
	}

	@Override
	public void chequea() throws CheckFailException {
		for(DecTipo dec : this.getDectipos()){
			dec.chequea();
			dec.getTipo().simplificaDefTipos();
		}
	}
}
