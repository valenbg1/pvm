package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoInt extends Tipo {
	public static final TipoInt TIPO = new TipoInt(); 
	
	@Override
	public String toString() {
		return "int";
	}

	@Override
	public void chequea() {
	}

	@Override
	public void simplificaDefTipos() {
	}

}