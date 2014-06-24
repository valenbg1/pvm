package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoBoolean extends Tipo {
	public static final TipoBoolean TIPO = new TipoBoolean(); 
	
	@Override
	public String toString() {
		return "boolean";
	}

	@Override
	public void chequea() {
	}

	@Override
	public void simplificaDefTipos() {	
	}
	
}