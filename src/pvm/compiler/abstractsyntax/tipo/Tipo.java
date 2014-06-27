package pvm.compiler.abstractsyntax.tipo;

import pvm.compiler.abstractsyntax.Node;

public abstract class Tipo extends Node {
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
	
	@Override
	public void simplificaDefTipos() {}
	
	public abstract Tipo tipoSimplificado();
}