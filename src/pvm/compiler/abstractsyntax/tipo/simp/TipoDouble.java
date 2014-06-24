package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoDouble extends Tipo {
	public static final TipoDouble TIPO = new TipoDouble(); 
	
	
	@Override
	public String toString() {
		return "double";
	}

	@Override
	public void chequea() {
	}

	@Override
	public void simplificaDefTipos() {
	}

}