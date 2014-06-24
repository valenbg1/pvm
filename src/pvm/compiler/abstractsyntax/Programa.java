package pvm.compiler.abstractsyntax;

import java.util.List;

import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.seccion.SeccionSubprogramas;
import pvm.compiler.abstractsyntax.seccion.SeccionTipos;
import pvm.compiler.abstractsyntax.seccion.SeccionVariables;
import pvm.compiler.abstractsyntax.subprog.DecSubprograma;
import pvm.compiler.abstractsyntax.subprog.param.Parametro;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.exceptions.CheckFailException;

public class Programa implements Node {
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
		

		for (DecTipo dectipo : this.getSectipos().getDectipos())
			dectipo.vincula();
		
		for (DecTipo decvar : this.getSecvars().getDectipos())
			decvar.vincula();
		
		for (DecSubprograma decsubprog : this.getSecsubprogs().getDecsubprogramas())
			decsubprog.vincula();
		
		
		for (DecTipo dectipo : this.getSectipos().getDectipos())
			dectipo.vinculaDefPunteros();
		
		for (DecTipo decvar : this.getSecvars().getDectipos())
			decvar.vinculaDefPunteros();
		
		for (DecSubprograma decsubprog : this.getSecsubprogs().getDecsubprogramas())
			decsubprog.vinculaDefPunteros();
		
		
		for (Instruccion instr : this.getInstrs())
			instr.vincula();
		
	}

	@Override
	public void vinculaDefPunteros(){		
	}

	@Override
	public void chequea() throws CheckFailException {
		this.getSectipos().chequea();
		this.getSecvars().chequea();
		this.getSecsubprogs().chequea();
		
		for(Instruccion inst : this.getInstrs()){
			inst.chequea();
		}
	}
}