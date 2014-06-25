package pvm.compiler.abstractsyntax.exp.unar.arithm;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.unar.ExpUnaria;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;

public class Menos extends ExpUnaria {
	public Menos(Exp exp) {
		super(exp, "-");
	}

	@Override
	protected void errorTiposNoValidos() {
		ErrorsHandler.chequeaTiposNoAritmeticos(this, row);
	}
	
	@Override
	protected Tipo operacionValida() {
		if (exp.getTipo_infer().esInt())
			return new TipoInt();
		else if (exp.getTipo_infer().esDouble())
			return new TipoDouble();
		
		return null;
	}
}