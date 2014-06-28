package pvm.compiler.abstractsyntax.exp.unar.arithm;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.unar.ExpUnaria;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.VoidArgInstruction;
import pvm.vm.instructions.VoidArgInstruction.VoidInstruction_t;

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
	
	@Override
	protected Instruction codigoDeOperacion() {
		
		return new VoidArgInstruction(VoidInstruction_t.NEG);
	}
}