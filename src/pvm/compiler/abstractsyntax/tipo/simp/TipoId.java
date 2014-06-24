package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoId extends Tipo {
	private Node vinculo;
	private Tipo tipo;
	private int row;
	
	public TipoId(String id, int row) {
		this.row = row;
		
		this.id = id;
	}

	private String id;

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}

	public Node getVinculo() {
		return vinculo;
	}

	public void setVinculo(Node vinculo) {
		this.vinculo = vinculo;
	}

	public int getRow() {
		return row;
	}

	@Override
	public void vincula() {
		this.setVinculo(sym_t.declaracion(this.getId()));
		
		if (this.getVinculo() == null)
			ErrorsHandler.vinculaUndeclaredId(this.getId(), this.getRow());
		
	}

	@Override
	public void vinculaDefPunteros() {
	}

	@Override
	public void chequea() {
		if(!(this.vinculo instanceof DecTipo))
			ErrorsHandler.chequeaIdentificadorNoEsTipo(this.getId(), this.getRow());
		
		this.setTipo(((DecTipo)this.vinculo).getTipo()); 
	}

	@Override
	public void simplificaDefTipos() {
		this.tipo.simplificaDefTipos();
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public boolean esNumero() {
		return tipo.esNumero();
	}

	@Override
	public boolean esBooleano() {
		return tipo.esBooleano();
	}

	@Override
	public boolean esEntradaSalida() {
		return tipo.esEntradaSalida();
	}

}