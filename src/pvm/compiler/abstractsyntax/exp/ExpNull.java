package pvm.compiler.abstractsyntax.exp;

import java.util.ArrayList;

import pvm.compiler.abstractsyntax.tipo.simp.TipoPointer;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;


public class ExpNull extends Exp {
	@Override
	public void chequea() {
		tipo_infer = TipoPointer.TipoPointerNull();
	}

	@Override
	public String toString() {
		return "NULL";
	}

	@Override
	public void vincula() {}

	@Override
	public void codigo() {
		cod = new ArrayList<Instruction>();
		cod.add(new IntArgInstruction(IntInstruction_t.APILA, 0));
		cinst++;
	}
}