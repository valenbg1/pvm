package pvm.compiler.abstractsyntax.tipo;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.Node;

public class DecTipo extends Node {
	public static DecTipo DecTipoVar(String id, Tipo tipo, int row) {
		return new DecTipo(id, tipo, row, true);
	}
	
	private String id;
	
	private boolean esVariable;
	
	public DecTipo(String id, Tipo tipo, int row) {
		this(id, tipo, row, false);
	}
	
	private DecTipo(String id, Tipo tipo, int row, boolean esVariable) {
		this.id = id;
		
		this.row = row;
		
		this.tipo_infer = tipo;
		
		this.esVariable = esVariable;
	}
	
	@Override
	public void chequea() {
		tipo_infer.chequea();
	}

	@Override
	public boolean esVariable() {
		return esVariable;
	}

	public String getId() {
		return id;
	}

	@Override
	public void simplificaDefTipos() {
		tipo_infer = tipo_infer.tipoSimplificado();
	}

	@Override
	public String toString() {
		return id + ": " + tipo_infer + ";";
	}

	@Override
	public void vincula()  {
		tipo_infer.vincula();
		
		if (!sym_t.insertaId(this.getId(), tipo_infer))
			ErrorsHandler.vinculaDuplicatedId(id, row);
	}

	@Override
	public void vinculaDefPunteros() {
		tipo_infer.vinculaDefPunteros();		
	}
}