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
	public int anidamientoDe() {
		return 0;
	}

	@Override
	public void asignaEspacio() {
		if (esVariable) {
			n_nivel = nivel;
			n_dir = dir;
			tipo_infer.asignaEspacio();
			dir = dir+tipo_infer.getTam();
		}
	}

	@Override
	public void chequea() {
		tipo_infer.chequea();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DecTipo))
			return false;
		if (tipo_infer != ((DecTipo) obj).getTipo_infer())
			return false;
		return true;
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
		
		if (!sym_t.insertaId(id, this))
			ErrorsHandler.vinculaDuplicatedId(id, row);
	}

	@Override
	public void vinculaDefPunteros() {
		tipo_infer.vinculaDefPunteros();		
	}

	@Override
	public void codigo() {
	}
}