package pvm.compiler.abstractsyntax.exp.bin.arithm;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.bin.ExpBin;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;

public abstract class ExpBinArithm extends ExpBin {
	protected ExpBinArithm(Exp exp0, Exp exp1, String op) {
		super(exp0, exp1, op);
	}
	
	@Override
	protected void errorTiposNoValidos() {
		ErrorsHandler.chequeaTiposNoAritmeticos(this, row);
	}
	
	@Override
	protected Tipo operacionValida() {
		if (exp0.getTipo_infer().esInt() && exp1.getTipo_infer().esInt())
			return new TipoInt();
		else if (exp0.getTipo_infer().esDouble() && exp1.getTipo_infer().esInt())
			return new TipoDouble();
		else if (exp0.getTipo_infer().esInt() && exp1.getTipo_infer().esDouble())
			return new TipoDouble();
		else if (exp0.getTipo_infer().esDouble() && exp1.getTipo_infer().esDouble())
			return new TipoDouble();
		
		return null;
	}
}