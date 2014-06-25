package pvm.compiler.abstractsyntax.exp.unar.cast;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.unar.ExpUnaria;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;

public class ToDouble extends ExpUnaria {
	public ToDouble(Exp exp) {
		super(exp, "TODOUBLE");
	}

	@Override
	protected void errorTiposNoValidos() {
		ErrorsHandler.chequeaTiposNoAritmeticos(this, row);
	}
	
	@Override
	protected Tipo operacionValida() {
		if (exp.getTipo_infer().esInt() || exp.getTipo_infer().esDouble())
			return new TipoDouble();
		
		return null;
	}
}