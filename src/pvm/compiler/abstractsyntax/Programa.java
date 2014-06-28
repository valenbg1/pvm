package pvm.compiler.abstractsyntax;

import java.util.ArrayList;
import java.util.List;

import pvm.compiler.SymbolsTable;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.seccion.SeccionSubprogramas;
import pvm.compiler.abstractsyntax.seccion.SeccionTipos;
import pvm.compiler.abstractsyntax.seccion.SeccionVariables;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;

public class Programa extends Node {
	private SeccionTipos sectipos;
	private SeccionVariables secvars;
	private SeccionSubprogramas secsubprogs;
	private List<Instruccion> instrs;
	
	private int finDatos;

	public Programa(SeccionTipos sectipos, SeccionVariables secvars,
			SeccionSubprogramas secsubprogs, List<Instruccion> instrs) {
		this.sectipos = sectipos;
		this.secvars = secvars;
		this.secsubprogs = secsubprogs;
		this.instrs = instrs;
	}

	@Override
	public int anidamientoDe() {
		return 0;
	}

	@Override
	public void asignaEspacio() {
		finDatos = max_anidamiento();
		dir = finDatos;
		nivel = 0;
		
		sectipos.asignaEspacio();
		secvars.asignaEspacio();
		secsubprogs.asignaEspacio();
	}

	@Override
	public void chequea() {
		sectipos.chequea();
		sectipos.simplificaDefTipos();
		
		secvars.chequea();
		secvars.simplificaDefTipos();
		
		secsubprogs.chequea();
		secsubprogs.simplificaDefTipos();
		
		for(Instruccion inst : this.instrs)
			inst.chequea();
	}

	public int getFinDatos() {
		return finDatos;
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

	private int max_anidamiento() {
		int anid = 0;
		
		anid = Math.max(anid, sectipos.anidamientoDe());
		anid = Math.max(anid, secvars.anidamientoDe());
		anid = Math.max(anid, secsubprogs.anidamientoDe());
		
		return anid;
	}

	public void setFinDatos(int finDatos) {
		this.finDatos = finDatos;
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
		sym_t = new SymbolsTable();
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

	@Override
	public void codigo() {
		cinst = numeroInstruccionesActivacionPrograma();

		sectipos.codigo();
		secvars.codigo();
		secsubprogs.codigo();
		
		inicio = cinst;
		for (Instruccion instr : this.instrs)
			instr.codigo();
		
		cod = codigoActivacionPrograma();
		cod.addAll(sectipos.getCod());
		cod.addAll(secvars.getCod());
		cod.addAll(secsubprogs.getCod());
		
		for (Instruccion instr : this.instrs)
			cod.addAll(instr.getCod());
		
	}
	
	private int numeroInstruccionesActivacionPrograma(){
		return 3;
	}
	
	private ArrayList<Instruction> codigoActivacionPrograma(){
		int secDatos = 0;
		int numDispays = anidamientoDe();
		for(DecTipo d : secvars.getDectipos())
			secDatos += d.getTipo_infer().getTam();
		
		ArrayList<Instruction> ret = new ArrayList<>();
		ret.add(new IntArgInstruction(IntInstruction_t.APILA, numDispays + secDatos));
		ret.add(new IntArgInstruction(IntInstruction_t.DESAPILA_DIR, 0));
		ret.add(new IntArgInstruction(IntInstruction_t.IR_A, inicio));
		
		return ret;
	}

}