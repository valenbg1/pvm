package pvm.compiler.abstractsyntax.exp.num;

import java.util.ArrayList;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;
import pvm.vm.instructions.BoolArgInstruction;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.BoolArgInstruction.BoolInstruction_t;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;

public class ExpNumNat extends Exp {
	private int numnat;
	
	public ExpNumNat(int numnat) {
		this.numnat = numnat;
	}

	@Override
	public void chequea() {
		tipo_infer = new TipoInt();
	}

	public int getNumNat() {
		return numnat;
	}

	@Override
	public String toString() {
		return Integer.toString(numnat);
	}

	@Override
	public void vincula() {}

	@Override
	public void codigo() {
		cod = codigoInt();
		cinst += cod.size();
	}

	private ArrayList<Instruction> codigoInt() {
		ArrayList<Instruction> ret = new ArrayList<Instruction>();
		ret.add(new IntArgInstruction(IntInstruction_t.APILA, numnat));
		return ret;
	}
}