package pvm.compiler.abstractsyntax.designador;

import java.util.ArrayList;
import java.util.EmptyStackException;

import pvm.compiler.ErrorsHandler;
import pvm.vm.PMachine;
import pvm.vm.exceptions.InvalidHeapStateException;
import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.exceptions.NoHeapSpaceException;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;
import pvm.vm.instructions.VoidArgInstruction.VoidInstruction_t;
import pvm.vm.instructions.VoidArgInstruction;

public class DesignaId extends Designador {
	private String id;
	
	public DesignaId(String id, int row) {
		this.row = row;
		
		this.id = id;
	}

	@Override
	public void chequea() {
		if (!vinculo.esVariable() && !vinculo.esParametro())
			ErrorsHandler.chequeaIdentificadorNoDeEsTipo("param o var", id, row);
		
		tipo_infer = vinculo.getTipo_infer();
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}

	@Override
	public void vincula() {
		vinculo = sym_t.declaracion(id);
		
		if (vinculo == null)
			ErrorsHandler.vinculaUndeclaredId(id, row);
	}

	@Override
	public void codigo() {
		cod = codigoAccesoId();
		cinst += cod.size();
	}

	private ArrayList<Instruction> codigoAccesoId() {
		ArrayList<Instruction> ret = new ArrayList<>();
		if(vinculo.getN_nivel() == 0){
			ret.add(new IntArgInstruction(IntInstruction_t.APILA, vinculo.getN_dir()));
		}else{
			ret.add(new IntArgInstruction(IntInstruction_t.APILA_DIR, vinculo.getN_nivel()));
			ret.add(new IntArgInstruction(IntInstruction_t.APILA, vinculo.getN_dir()));
			ret.add(new VoidArgInstruction(VoidInstruction_t.SUMA));
		}
		return ret;
	}
}