package pvm.compiler.abstractsyntax;

import java.util.List;

import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.seccion.SeccionSubprogramas;
import pvm.compiler.abstractsyntax.seccion.SeccionTipos;
import pvm.compiler.abstractsyntax.seccion.SeccionVariables;

public class Programa extends Node {
	private SeccionTipos sectipos;
	private SeccionVariables secvars;
	private SeccionSubprogramas secsubprogs;
	private List<Instruccion> instrs;

	public Programa(SeccionTipos sectipos, SeccionVariables secvars,
			SeccionSubprogramas secsubprogs, List<Instruccion> instrs) {
		this.sectipos = sectipos;
		this.secvars = secvars;
		this.secsubprogs = secsubprogs;
		this.instrs = instrs;
	}

	@Override
	public void chequea() {
		sectipos.chequea();
		secvars.chequea();
		secsubprogs.chequea();
		
		sectipos.simplificaDefTipos();
		secvars.simplificaDefTipos();
		secsubprogs.simplificaDefTipos();
		
		for(Instruccion inst : this.instrs)
			inst.chequea();
	}

	public List<Instruccion> getInstrs() {
		return instrs;
	}

	public SeccionSubprogramas getSecsubprogs() {
		return secsubprogs;
	}

	public SeccionTipos getSectipos() {
		return sectipos;
	}

	public SeccionVariables getSecvars() {
		return secvars;
	}

	@Override
	public void simplificaDefTipos() {}

	@Override
	public String toString() {
		String ret = "PROGRAM\n";

		ret += sectipos + "\n" + secvars + "\n" + secsubprogs + "\n{\n";

		for (Instruccion instr : instrs)
			ret += "\t" + instr + "\n";

		return ret += "}";
	}

	@Override
	public void vincula(){
		sym_t.abreBloque();
		

		sectipos.vincula();
		secvars.vincula();
		secsubprogs.vincula();
		
		sectipos.vinculaDefPunteros();
		secvars.vinculaDefPunteros();
		secsubprogs.vinculaDefPunteros();
		
		
		for (Instruccion instr : this.instrs)
			instr.vincula();
		
	}

	@Override
	public void vinculaDefPunteros() {}
}