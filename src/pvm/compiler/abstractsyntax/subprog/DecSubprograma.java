package pvm.compiler.abstractsyntax.subprog;

import java.util.ArrayList;
import java.util.List;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.seccion.SeccionSubprogramas;
import pvm.compiler.abstractsyntax.seccion.SeccionTipos;
import pvm.compiler.abstractsyntax.seccion.SeccionVariables;
import pvm.compiler.abstractsyntax.subprog.param.Parametro;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.PointerInstruction;
import pvm.vm.instructions.PointerInstruction.PointerInstruction_t;
import pvm.vm.instructions.VoidArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;
import pvm.vm.instructions.VoidArgInstruction.VoidInstruction_t;

public class DecSubprograma extends Node {
	private String id;
	
	private List<Parametro> params;
	private SeccionTipos sectipos;
	private SeccionVariables secvars;
	private SeccionSubprogramas secsubprogs;
	private List<Instruccion> instrs;
	private int dirComienzo;
	private int secDataSize;
	
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
	public int anidamientoDe() {
		return 1 + max_anidamiento();
	}

	@Override
	public void asignaEspacio() {
		int copiaDir = dir;
		int copiaNivel = nivel;
		
		++nivel;
		n_nivel = nivel;
		dir = 0;
		
		for (Parametro param : params) {
			param.setN_dir(dir);
			param.setN_nivel(nivel);
			param.getTipo_infer().asignaEspacio();
			
			if (param.esRefer())
				++dir;
			else
				dir += param.getTipo_infer().getTam();
		}
		
		sectipos.asignaEspacio();
		secvars.asignaEspacio();
		secsubprogs.asignaEspacio();
		
		nivel = copiaNivel;
		dir = copiaDir;
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

	private int max_anidamiento() {
		int anid = 0;
		
		anid = Math.max(anid, sectipos.anidamientoDe());
		anid = Math.max(anid, secvars.anidamientoDe());
		anid = Math.max(anid, secsubprogs.anidamientoDe());
		
		return anid;
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


	@Override
	public void codigo() {
		cod = new ArrayList<Instruction>();
		inicio = cinst;
		
		sectipos.codigo();
		secvars.codigo();
		secsubprogs.codigo();

		cod.addAll(sectipos.getCod());
		cod.addAll(secvars.getCod());
		cod.addAll(secsubprogs.getCod());

		dirComienzo = cinst;
		
		cinst += numInstruccionesPrologo();
		cod.addAll(codigoPrologo());
		
		for (Instruccion instr : this.instrs){
			instr.codigo();
			cod.addAll(instr.getCod());
		}
		
		cinst += numInstruccionesEpilogo();
		cod.addAll(codigoEpilogo());
		
		fin = cinst;
		
	}

	private ArrayList<Instruction> codigoEpilogo() {
		ArrayList<Instruction> ret = new ArrayList<Instruction>();
		
		// Restaura cima Reg Act
		ret.add(new IntArgInstruction(IntInstruction_t.APILA_DIR, 0));
		ret.add(new IntArgInstruction(IntInstruction_t.APILA, secDataSize+2));
		ret.add(new VoidArgInstruction(VoidInstruction_t.RESTA));
		ret.add(new IntArgInstruction(IntInstruction_t.DESAPILA_DIR, 0));
		
		// Restaura display
		ret.add(new IntArgInstruction(IntInstruction_t.APILA_DIR, 0));
		ret.add(new IntArgInstruction(IntInstruction_t.APILA, 2));
		ret.add(new VoidArgInstruction(VoidInstruction_t.SUMA));
		ret.add(new PointerInstruction(PointerInstruction_t.APILA_IND));
		ret.add(new IntArgInstruction(IntInstruction_t.DESAPILA_DIR, getN_nivel()));

		// Retorna
		ret.add(new IntArgInstruction(IntInstruction_t.APILA_DIR, 0));
		ret.add(new IntArgInstruction(IntInstruction_t.APILA, 1));
		ret.add(new VoidArgInstruction(VoidInstruction_t.SUMA));
		ret.add(new PointerInstruction(PointerInstruction_t.APILA_IND));
		ret.add(new PointerInstruction(PointerInstruction_t.IR_IND));
		
		return ret;
	}

	private int numInstruccionesEpilogo() {
		return 14;
	}

	private ArrayList<Instruction> codigoPrologo() {
		ArrayList<Instruction> ret = new ArrayList<Instruction>();
		secDataSize = 0;
		for(Parametro p : params){
			if(p.esValor())
				secDataSize += p.getTipo_infer().getTam();
			else
				secDataSize ++;
		}for(DecTipo d : secvars.getDectipos())
			secDataSize += d.getTipo_infer().getTam();
		
		ret.add(new VoidArgInstruction(VoidInstruction_t.DUP));
		ret.add(new IntArgInstruction(IntInstruction_t.APILA, 1));
		ret.add(new VoidArgInstruction(VoidInstruction_t.RESTA));
		ret.add(new IntArgInstruction(IntInstruction_t.APILA_DIR, getN_nivel()));
		ret.add(new PointerInstruction(PointerInstruction_t.DESAPILA_IND));
		ret.add(new IntArgInstruction(IntInstruction_t.DESAPILA_DIR, getN_nivel()));
		
		// Actualiza cima de registros de activación.
		ret.add(new IntArgInstruction(IntInstruction_t.APILA_DIR, getN_nivel()));
		ret.add(new IntArgInstruction(IntInstruction_t.APILA, secDataSize-1));
		ret.add(new VoidArgInstruction(VoidInstruction_t.SUMA));
		ret.add(new IntArgInstruction(IntInstruction_t.DESAPILA_DIR, 0));
		
		return ret;
	}

	private int numInstruccionesPrologo() {
		return 10;
	}

	public int getDirComienzo() {
		return dirComienzo;
	}

	public void setDirComienzo(int dirComienzo) {
		this.dirComienzo = dirComienzo;
	}
}
