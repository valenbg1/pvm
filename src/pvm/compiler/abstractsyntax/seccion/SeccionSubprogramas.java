package pvm.compiler.abstractsyntax.seccion;

import java.util.List;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.subprog.DecSubprograma;

public class SeccionSubprogramas extends Node {
	private List<DecSubprograma> decsubprogramas;
	
	public SeccionSubprogramas(List<DecSubprograma> decsubprogramas) {
		this.decsubprogramas = decsubprogramas;
	}

	@Override
	public void chequea() {
		for(DecSubprograma decsubprogram: decsubprogramas)
			decsubprogram.chequea();
	}

	public List<DecSubprograma> getDecsubprogramas() {
		return decsubprogramas;
	}

	@Override
	public void simplificaDefTipos() {
		for(DecSubprograma decsubprogram: decsubprogramas)
			decsubprogram.simplificaDefTipos();
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

	@Override
	public void vincula() {
		for (DecSubprograma decsubprogram : decsubprogramas)
			decsubprogram.vincula();
	}

	@Override
	public void vinculaDefPunteros() {
		for (DecSubprograma decsubprogram : decsubprogramas)
			decsubprogram.vinculaDefPunteros();
	}
}
