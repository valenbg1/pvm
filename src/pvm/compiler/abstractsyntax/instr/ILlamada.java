package pvm.compiler.abstractsyntax.instr;

import java.util.List;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.ExpDesignador;
import pvm.compiler.abstractsyntax.subprog.DecSubprograma;
import pvm.compiler.abstractsyntax.subprog.param.ParamRefer;
import pvm.compiler.abstractsyntax.subprog.param.ParamValor;
import pvm.compiler.abstractsyntax.subprog.param.Parametro;
import pvm.compiler.exceptions.CheckFailException;

public class ILlamada extends Instruccion {
	private String id;
	
	private List<Exp> args;
	
	private Node vinculo;
	private int row;
	
	public ILlamada(String id, List<Exp> args, int row) {
		this.id = id;
		
		this.args = args;
		
		this.row = row;
	}

	@Override
	public String toString() {
		String args_s = "";
		
		for (Exp arg : args)
			args_s += arg + ", ";
		
		return id + "(" + args_s + ")" + ";";
	}

	public String getId() {
		return id;
	}

	public List<Exp> getArgs() {
		return args;
	}

	public int getRow() {
		return row;
	}

	public Node getVinculo() {
		return vinculo;
	}

	public void setVinculo(Node vinculo) {
		this.vinculo = vinculo;
	}

	@Override
	public void vincula() {
		this.setVinculo(sym_t.declaracion(this.getId()));
		
		if (this.getVinculo() == null){
			ErrorsHandler.vinculaUndeclaredId(this.getId(), this.getRow());
			return;
		}
		
		for (Exp exp : this.getArgs())
			exp.vincula();
	}

	@Override
	public void vinculaDefPunteros() {
	}

	@Override
	public void chequea() {
		if(!(this.vinculo instanceof DecSubprograma)){
			ErrorsHandler.chequeaIdentificadorNoEsTipo(getId(), getRow());
		}else{
		
			for(Exp e : this.getArgs()){
				try {
					e.chequea();
				} catch (CheckFailException e1) {
					e1.printStackTrace();
				}
			}
			
			DecSubprograma vinculo = (DecSubprograma) this.vinculo;
			
			if(this.args.size() != vinculo.getParams().size())
				ErrorsHandler.error("Número de parámetros distintos al llamar a "+getId()+" "+getRow());
			
			for(int i = 0; i < this.args.size(); i++){
				Parametro p = vinculo.getParams().get(i);
				Exp arg = this.args.get(i);
				
				if((p instanceof ParamRefer) && !(arg instanceof ExpDesignador))
					ErrorsHandler.error("El parámetro "+(i+1)+" de "+getId()+" no es un designador "+getRow());
				
				
				if(p.getTipo() != arg.getTipo())
					ErrorsHandler.error("El parámetro "+(i+1)+" de "+getId()
							+" no tiene tipo compatible con "+p.getTipo()+" "+getRow());
			}
		}
	}
}