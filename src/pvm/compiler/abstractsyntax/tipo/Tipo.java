package pvm.compiler.abstractsyntax.tipo;

import pvm.compiler.abstractsyntax.Node;

public abstract class Tipo extends Node {
	protected int tam = -1;
	
	@Override
	public int anidamientoDe() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void codigo() {
		throw new UnsupportedOperationException();
	}
	
	public abstract boolean equals(Tipo other);
	
	public boolean esArray() {
		return false;
	}
	
	public boolean esBooleano() {
		return false;
	}
	
	public boolean esDouble() {
		return false;
	}
	
	public boolean esId() {
		return false;
	}
	
	public boolean esInt() {
		return false;
	}
	
	public boolean esNumero() {
		return esInt() || esDouble();
	}
	
	public boolean esPointer() {
		return false;
	}
	
	public boolean esStruct() {
		return false;
	}
	
	public int getTam() {
		return tam;
	}
	
	public boolean ioValid() {
		if (esBooleano())
			return true;
		
		if (esDouble())
			return true;
		
		if (esInt())
			return true;

		return false;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	@Override
	public void simplificaDefTipos() {}
	
	public abstract Tipo tipoSimplificado();
}