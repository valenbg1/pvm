package pvm.compiler.abstractsyntax.instr;

import java.util.Iterator;
import java.util.List;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.ExpDesignador;
import pvm.compiler.abstractsyntax.subprog.DecSubprograma;
import pvm.compiler.abstractsyntax.subprog.param.Parametro;

public class ILlamada extends Instruccion {
	private String id;
	
	private List<Exp> args;
	
	public ILlamada(String id, List<Exp> args, int row) {
		this.id = id;
		
		this.args = args;
		
		this.row = row;
	}

	@Override
	public void chequea() {
		if(!(vinculo instanceof DecSubprograma))
			ErrorsHandler.chequeaIdentificadorNoEsSubprograma(id, row);
		
		for(Exp e : args)
			e.chequea();
		
		DecSubprograma vinc = (DecSubprograma) this.vinculo;
		
		if (this.args.size() != vinc.getParams().size())
			ErrorsHandler.error("Número de parámetros distintos al llamar a "+ id +" "+ row);
		
		int i = 1;
		Iterator<Exp> iter = args.iterator();
		
		for (Parametro param : vinc.getParams()) {
			Exp exp = iter.next();
			
			if (param.esRefer() && !(exp instanceof ExpDesignador))
				ErrorsHandler.error("El parámetro " + i + " en '" + this
						+ "' no es un designador " + getRow());
			else if (!param.getTipo_infer().equals(exp.getTipo_infer()))
				ErrorsHandler.error("El parámetro " + i + " en '" + this
						+ "' no tiene tipo compatible con "
						+ param.getTipo_infer() + " en la linea " + getRow());

			++i;
		}
	}

	public List<Exp> getArgs() {
		return args;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		String args_s = "";
		
		for (Exp arg : args)
			args_s += arg + ", ";
		
		return id + "(" + args_s + ")" + ";";
	}

	@Override
	public void vincula() {
		vinculo = sym_t.declaracion(id);
		
		if (vinculo == null)
			ErrorsHandler.vinculaUndeclaredId(id, row);
		
		for (Exp exp : args)
			exp.vincula();
	}
}