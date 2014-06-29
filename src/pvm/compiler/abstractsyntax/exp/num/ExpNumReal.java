package pvm.compiler.abstractsyntax.exp.num;

import java.util.ArrayList;

import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;
import pvm.vm.instructions.DoubleArgInstruction;
import pvm.vm.instructions.DoubleArgInstruction.DoubleInstruction_t;
import pvm.vm.instructions.Instruction;

public class ExpNumReal extends Exp {
	private double numreal;
	
	public ExpNumReal(double numreal) {
		this.numreal = numreal;
	}

	@Override
	public void chequea() {
		tipo_infer = new TipoDouble();
	}

	public double getNumReal() {
		return numreal;
	}

	@Override
	public String toString() {
		return Double.toString(numreal);
	}

	@Override
	public void vincula() {}
	
	@Override
	public void codigo() {
		inicio = cinst;
		cod = codigoDouble();
		cinst += cod.size();
		fin = cinst;
	}

	private ArrayList<Instruction> codigoDouble() {
		ArrayList<Instruction> ret = new ArrayList<Instruction>();
		ret.add(new DoubleArgInstruction(DoubleInstruction_t.APILA, numreal));
		return ret;
	}
}