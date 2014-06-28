package pvm.compiler.abstractsyntax.exp.bool;

import java.util.ArrayList;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;
import pvm.vm.instructions.Instruction;

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
		// TODO Auto-generated method stub
		return null;
	}
}