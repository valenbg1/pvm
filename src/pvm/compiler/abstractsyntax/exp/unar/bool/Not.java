package pvm.compiler.abstractsyntax.exp.unar.bool;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.unar.ExpUnaria;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;

public class Not extends ExpUnaria {
	public Not(Exp exp) {
		super(exp, "NOT");
	}

	@Override
	protected void errorTiposNoValidos() {
		ErrorsHandler.chequeaTiposNoBooleanos(this, row);
	}
	
	@Override
	protected Tipo operacionValida() {
		if (exp.getTipo_infer().esBooleano())
			return new TipoBoolean();
		
		return null;
	}
}