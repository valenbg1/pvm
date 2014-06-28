package pvm.compiler.abstractsyntax.exp.bool;

import java.util.ArrayList;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;
import pvm.vm.instructions.BoolArgInstruction;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.BoolArgInstruction.BoolInstruction_t;

public class ExpTrue extends Exp {
	@Override
	public void chequea() {
		tipo_infer = new TipoBoolean();
	}

	@Override
	public String toString() {
		return "TRUE";
	}

	@Override
	public void vincula() {}

	@Override
	public void codigo() {
		cod = codigoTrue();
		cinst += cod.size();
	}

	private ArrayList<Instruction> codigoTrue() {
		ArrayList<Instruction> ret = new ArrayList<Instruction>();
		ret.add(new BoolArgInstruction(BoolInstruction_t.APILA, true));
		return ret;
	}
}