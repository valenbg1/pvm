package pvm.compiler.abstractsyntax.designador;

import java.util.ArrayList;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.abstractsyntax.tipo.comp.TipoStruct;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.VoidArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;
import pvm.vm.instructions.VoidArgInstruction.VoidInstruction_t;



public class DesignaCampo extends Designador {
	private Designador desig;
	private String campo;
	
	public DesignaCampo(Designador desig, String campo, int vinculo_row) {
		this.desig = desig;
		this.campo = campo;
	}

	@Override
	public void chequea() {
		desig.chequea();
		
		if (desig.getTipo_infer() != null) {
			if (desig.getTipo_infer().esStruct()) {
				DecTipo c = ((TipoStruct) desig.getTipo_infer()).getCampos().get(campo);
				
				if (c == null)
					ErrorsHandler.chequeaCampoNoExiste(campo, desig, row);
				else
					tipo_infer = c.getTipo_infer();
			} else
				ErrorsHandler.chequeaDesignadorNoEsDeTipo("STRUCT", desig, desig.getRow());
		}
	}

	public String getCampo() {
		return campo;
	}

	public Designador getDesig() {
		return desig;
	}

	@Override
	public String toString() {
		return desig + "." + campo;
	}

	@Override
	public void vincula() {
		desig.vincula();
	}

	@Override
	public void codigo() {
		inicio = cinst;
		desig.codigo();
		
		cod = new ArrayList<Instruction>();
		
		cod.addAll(desig.getCod());
		cod.addAll(codigoAccesoCampo());
		cinst += numeroInstruccionesAccesoACampo();
		
		fin = cinst;
	}

	private int numeroInstruccionesAccesoACampo() {
		return 2;
	}

	private ArrayList<Instruction> codigoAccesoCampo() {
		int desp = ((TipoStruct) desig.getTipo_infer()).getDesp_campos().get(campo);
		ArrayList<Instruction> ret = new ArrayList<>();
		
		ret.add(new IntArgInstruction(IntInstruction_t.APILA, desp));
		ret.add(new VoidArgInstruction(VoidInstruction_t.SUMA));
	
		return ret;
	}
}