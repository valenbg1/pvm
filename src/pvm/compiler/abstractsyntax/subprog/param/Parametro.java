package pvm.compiler.abstractsyntax.subprog.param;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public abstract class Parametro extends Node {
	protected String id;
	
	protected Parametro(String id, Tipo tipo) {
		this.id = id;
		
		this.tipo_infer = tipo;
	}
	
	@Override
	public int anidamientoDe() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void asignaEspacio() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void chequea() {
		tipo_infer.chequea();
	}
	
	@Override
	public boolean esParametro() {
		return true;
	}

	public boolean esRefer() {
		return false;
	}

	public boolean esValor() {
		return false;
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
		return id + ": " + tipo_infer;
	}
	
	@Override
	public void vincula() {
		tipo_infer.vincula();
	}
	
	@Override
	public void vinculaDefPunteros() {
		tipo_infer.vinculaDefPunteros();
	}
}