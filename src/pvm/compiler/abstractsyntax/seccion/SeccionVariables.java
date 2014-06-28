package pvm.compiler.abstractsyntax.seccion;

import java.util.List;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.DecTipo;

public class SeccionVariables extends Node {
	private List<DecTipo> dectipos;
	
	public SeccionVariables(List<DecTipo> dectipos) {
		this.dectipos = dectipos;
	}

	@Override
	public int anidamientoDe() {
		int anid = 0;
		
		for (DecTipo dectipo : dectipos)
			anid = Math.max(anid, dectipo.anidamientoDe());
		
		return anid;
	}
	
	@Override
	public void asignaEspacio() {
		for (DecTipo dectipo : dectipos)
			dectipo.asignaEspacio();
	}

	@Override
	public void chequea() {
		for(DecTipo dectipo: dectipos)
			dectipo.chequea();
	}

	public List<DecTipo> getDectipos() {
		return dectipos;
	}

	@Override
	public void simplificaDefTipos() {
		for(DecTipo dectipo: dectipos)
			dectipo.simplificaDefTipos();
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

	@Override
	public void vincula() {
		for (DecTipo dectipo : dectipos)
			dectipo.vincula();
	}

	@Override
	public void vinculaDefPunteros() {
		for (DecTipo dectipo : dectipos)
			dectipo.vinculaDefPunteros();
	}
}
