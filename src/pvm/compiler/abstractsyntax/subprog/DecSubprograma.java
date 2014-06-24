package pvm.compiler.abstractsyntax.subprog;

import java.util.List;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.seccion.SeccionSubprogramas;
import pvm.compiler.abstractsyntax.seccion.SeccionTipos;
import pvm.compiler.abstractsyntax.seccion.SeccionVariables;
import pvm.compiler.abstractsyntax.subprog.param.Parametro;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.exceptions.CheckFailException;

public class DecSubprograma implements Node {
	private String id;
	
	private int row;
	
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
	public String toString() {
		String ret = "SUBPROGRAM " + id + "(";
		
		for (Parametro param : params)
			ret += param + ", ";
		
		ret += ")\n\t" + sectipos + "\n\t" + secvars + "\n\t" + secsubprogs + "{\n";
		
		for (Instruccion instr : instrs)
			ret += "\t" + instr + "\n";
		
		return ret += "}";
	}

	public String getId() {
		return id;
	}

	public List<Parametro> getParams() {
		return params;
	}

	public SeccionTipos getSectipos() {
		return sectipos;
	}

	public SeccionVariables getSecvars() {
		return secvars;
	}

	public SeccionSubprogramas getSecsubprogs() {
		return secsubprogs;
	}

	public List<Instruccion> getInstrs() {
		return instrs;
	}

	public int getRow() {
		return row;
	}

	@Override
	public void vincula() {
		if (!sym_t.insertaId(this.getId(), this))
			ErrorsHandler.vinculaDuplicatedId(this.getId(), this.getRow());
		
		sym_t.abreBloque();
		sym_t.insertaId(this.getId(), this);
		
		for (Parametro param : this.getParams()){
			sym_t.insertaId(param.getId(), param);
			param.vincula();
		}
		
		
		for (DecTipo dectipo : this.getSectipos().getDectipos())
			dectipo.vincula();
		
		for (DecTipo decvar : this.getSecvars().getDectipos())
			decvar.vincula();
		
		for (DecSubprograma decsubprog : this.getSecsubprogs().getDecsubprogramas())
			decsubprog.vincula();
		
		for (Parametro param : this.getParams()){
			param.vinculaDefPunteros();
		}
		
		for (DecTipo dectipo : this.getSectipos().getDectipos())
			dectipo.vinculaDefPunteros();
		
		for (DecTipo decvar : this.getSecvars().getDectipos())
			decvar.vinculaDefPunteros();
		
		for (DecSubprograma decsubprog : this.getSecsubprogs().getDecsubprogramas())
			decsubprog.vinculaDefPunteros();
		
		
		for (Instruccion instr : this.getInstrs())
			instr.vincula();
		
		sym_t.cierraBloque();
	}

	@Override
	public void vinculaDefPunteros() {
		for (Parametro param : this.getParams())
			param.getTipo().vinculaDefPunteros();
	}

	@Override
	public void chequea() throws CheckFailException {
		for(Parametro param : this.getParams()){
			param.chequea();
			param.getTipo().simplificaDefTipos();
		}
		
		for(DecTipo dec : this.getSectipos().getDectipos()){
			dec.chequea();
			dec.getTipo().simplificaDefTipos();
		}
		
		for(DecTipo dec : this.getSecvars().getDectipos()){
			dec.chequea();
			dec.getTipo().simplificaDefTipos();
		}
		
		for(Instruccion inst : this.getInstrs()){
			inst.chequea();
		}
	}
}
