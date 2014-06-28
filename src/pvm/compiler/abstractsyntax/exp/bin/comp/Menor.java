package pvm.compiler.abstractsyntax.exp.bin.comp;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.VoidArgInstruction;
import pvm.vm.instructions.VoidArgInstruction.VoidInstruction_t;

public class Menor extends ExpBinComp {
	public Menor(Exp exp0, Exp exp1) {
		super(exp0, exp1, "<");
	}
	
	@Override
	protected Instruction codigoDeOperacion() {
		
		return new VoidArgInstruction(VoidInstruction_t.MENOR);
	}
}