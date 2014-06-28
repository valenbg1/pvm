package pvm.compiler.abstractsyntax.exp.bool;

import java.util.ArrayList;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;
import pvm.vm.instructions.BoolArgInstruction;
import pvm.vm.instructions.BoolArgInstruction.BoolInstruction_t;
import pvm.vm.instructions.Instruction;

public class ExpFalse extends Exp {
	@Override
	public void chequea() {
		tipo_infer = new TipoBoolean();
	}

	@Override
	public String toString() {
		return "FALSE";
	}

	@Override
	public void vincula() {}
	
	@Override
	public void codigo() {
		cod = codigoFalse();
		cinst += cod.size();
	}

	private ArrayList<Instruction> codigoFalse() {
		ArrayList<Instruction> ret = new ArrayList<Instruction>();
		ret.add(new BoolArgInstruction(BoolInstruction_t.APILA, false));
		return ret;
	}
}