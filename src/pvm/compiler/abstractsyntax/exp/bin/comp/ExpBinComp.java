package pvm.compiler.abstractsyntax.exp.bin.comp;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.bin.ExpBin;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;

public abstract class ExpBinComp extends ExpBin {
	protected ExpBinComp(Exp exp0, Exp exp1, String op) {
		super(exp0, exp1, op);
	}
	
	@Override
	protected void errorTiposNoValidos() {
		ErrorsHandler.chequeaTiposNoComparables(this, row);
	}
	
	@Override
	protected Tipo operacionValida() {
		if (exp0.getTipo_infer().esBooleano() && exp1.getTipo_infer().esBooleano())
			return new TipoBoolean();
		if (exp0.getTipo_infer().esNumero() && exp1.getTipo_infer().esNumero())
			return new TipoBoolean();
		if (exp0.getTipo_infer().esPointer() && exp1.getTipo_infer().esPointer())
			return new TipoBoolean();
		
		return null;
	}
}