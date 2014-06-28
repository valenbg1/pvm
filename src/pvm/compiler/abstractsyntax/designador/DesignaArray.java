package pvm.compiler.abstractsyntax.designador;

import java.util.ArrayList;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.VoidArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;
import pvm.vm.instructions.VoidArgInstruction.VoidInstruction_t;

public class DesignaArray extends Designador {
	private Designador desig;
	private Exp exp;
	
	public DesignaArray(Designador desig, Exp exp, int vinculo_row) {
		this.desig = desig;
		this.exp = exp;
	}

	@Override
	public void chequea() {
		desig.chequea();
		exp.chequea();
		
		if ((desig.getTipo_infer() != null) && (exp.getTipo_infer() != null)) {
			if (!desig.getTipo_infer().esArray())
				ErrorsHandler.chequeaDesignadorNoEsDeTipo("ARRAY", desig, row);
			else if (!exp.getTipo_infer().esInt())
				ErrorsHandler.chequeaExpresionNoEsDeTipo("int", exp, row);
			else
				tipo_infer = desig.getTipo_infer().getTipo_infer();
		}
	}

	public Designador getDesig() {
		return desig;
	}

	public Exp getExp() {
		return exp;
	}

	@Override
	public String toString() {
		return desig + "[" + exp + "]";
	}

	@Override
	public void vincula() {
		desig.vincula();
		exp.vincula();
	}
	
	@Override
	public void codigo() {
		desig.codigo();
		exp.codigo();
		
		cod = new ArrayList<Instruction>();
		
		cod.addAll(desig.getCod());
		cod.addAll(exp.getCod());
		cod.addAll(codigoIndexacion());
		cinst += numeroInstruccionesIndexacion();
	}

	private int numeroInstruccionesIndexacion() {
		return 3;
	}

	private ArrayList<Instruction> codigoIndexacion() {
		ArrayList<Instruction> ret = new ArrayList<>();
		ret.add(new IntArgInstruction(IntInstruction_t.APILA, this.tipo_infer.getTam()));
		ret.add(new VoidArgInstruction(VoidInstruction_t.MUL));
		ret.add(new VoidArgInstruction(VoidInstruction_t.SUMA));
		return ret;
	}
}