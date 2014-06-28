package pvm.compiler.abstractsyntax.exp.bin.arithm;

import java.util.ArrayList;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.VoidArgInstruction;
import pvm.vm.instructions.VoidArgInstruction.VoidInstruction_t;

public class Suma extends ExpBinArithm {
	public Suma(Exp exp0, Exp exp1) {
		super(exp0, exp1, "+");
	}

	@Override
	protected Instruction codigoDeOperacion() {
		
		return new VoidArgInstruction(VoidInstruction_t.SUMA);
	}
}