package pvm.compiler.abstractsyntax.subprog;

import java.util.List;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.seccion.SeccionSubprogramas;
import pvm.compiler.abstractsyntax.seccion.SeccionTipos;
import pvm.compiler.abstractsyntax.seccion.SeccionVariables;
import pvm.compiler.abstractsyntax.subprog.param.Parametro;

public class DecSubprograma extends Node {
	private String id;
	
	private List<Parametro> params;
	private SeccionTipos sectipos;
	private SeccionVariables secvars;
	private SeccionSubprogramas secsubprogs;
	private List<Instruccion> instrs;
	
	public DecSubprograma(List<Parametro> params, String id,
			SeccionTipos sectipos, SeccionVariables secvars,
			SeccionSubprogramas secsubprogs, List<Instruccion> instrs, int row) {
		this.id = id;
		this.params = params;
		this.sectipos = sectipos;
		this.secvars = secvars;
		this.secsubprogs = secsubprogs;
		this.instrs = instrs;
		
		this.row = row;
	}

	@Override
	public void chequea() {
		for (Parametro param : params)
			param.chequea();
		
		sectipos.chequea();
		sectipos.simplificaDefTipos();
		
		secvars.chequea();
		secvars.simplificaDefTipos();
		
		for (Parametro param : params)
			param.simplificaDefTipos();
		
		secsubprogs.chequea();
		secsubprogs.simplificaDefTipos();		
		
		for(Instruccion inst : this.instrs)
			inst.chequea();
	}

	public String getId() {
		return id;
	}

	public List<Instruccion> getInstrs() {
		return instrs;
	}

	public List<Parametro> getParams() {
		return params;
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
		String ret = "SUBPROGRAM " + id + "(";
		
		for (Parametro param : params)
			ret += param + ", ";
		
		ret += ")\n\t" + sectipos + "\n\t" + secvars + "\n\t" + secsubprogs + "{\n";
		
		for (Instruccion instr : instrs)
			ret += "\t" + instr + "\n";
		
		return ret += "}";
	}

	@Override
	public void vincula() {
		if (!sym_t.insertaId(id, this))
			ErrorsHandler.vinculaDuplicatedId(id, row);
		
		sym_t.abreBloque();
		sym_t.insertaId(id, this);
		
		for (Parametro param : params){
			sym_t.insertaId(param.getId(), param);
			param.vincula();
		}
		
		sectipos.vincula();
		secvars.vincula();
		secsubprogs.vincula();
		
		sectipos.vinculaDefPunteros();
		secvars.vinculaDefPunteros();
		secsubprogs.vinculaDefPunteros();
		
		for (Instruccion instr : this.instrs)
			instr.vincula();
		
		sym_t.cierraBloque();
	}

	@Override
	public void vinculaDefPunteros() {
		for (Parametro param : params)
			param.getTipo_infer().vinculaDefPunteros();
	}
}
