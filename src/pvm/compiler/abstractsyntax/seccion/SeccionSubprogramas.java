package pvm.compiler.abstractsyntax.seccion;

import java.util.ArrayList;
import java.util.List;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.subprog.DecSubprograma;
import pvm.vm.instructions.Instruction;

public class SeccionSubprogramas extends Node {
	private List<DecSubprograma> decsubprogramas;
	
	public SeccionSubprogramas(List<DecSubprograma> decsubprogramas) {
		this.decsubprogramas = decsubprogramas;
	}

	@Override
	public int anidamientoDe() {
		int anid = 0;
		
		for (DecSubprograma decsubprogram : decsubprogramas)
			anid = Math.max(anid, decsubprogram.anidamientoDe());
		
		return anid;
	}

	@Override
	public void asignaEspacio() {
		for (DecSubprograma decsubprogram : decsubprogramas)
			decsubprogram.asignaEspacio();
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

	@Override
	public void codigo() {
		cod = new ArrayList<Instruction>();
		inicio = cinst;
		for (DecSubprograma decsubprogram : decsubprogramas){
			decsubprogram.codigo();
			cod.addAll(decsubprogram.getCod());
		}
		fin = cinst;
	}
}
