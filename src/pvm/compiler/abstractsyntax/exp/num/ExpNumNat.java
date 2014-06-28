package pvm.compiler.abstractsyntax.exp.num;

import java.util.ArrayList;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;
import pvm.vm.instructions.Instruction;

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
		// TODO Auto-generated method stub
		return null;
	}
}