package pvm.compiler.abstractsyntax.instr.cond;

import java.util.ArrayList;
import java.util.List;

import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;

public class ICond extends Instruccion {
	private List<Caso> casos;
	
	public ICond(List<Caso> casos) {
		this.casos = casos;
	}

	@Override
	public void chequea() {
		for (Caso caso : this.getCasos())
			caso.chequea();
	}

	public List<Caso> getCasos() {
		return casos;
	}

	@Override
	public String toString() {
		String ret = "IF\n";
		
		for (Caso caso : casos)
			ret += "\t\t" + caso + "\t[]\n";
		
		ret += "\tENDIF;";
		
		return ret;
	}

	@Override
	public void vincula() {
		for (Caso caso : casos)
			caso.vincula();
	}

	@Override
	public void codigo() {
		cod = new ArrayList<>();
		this.inicio = cinst;
		
		for (Caso caso : this.getCasos()){
			caso.codigo();
			cinst += numeroInstruccionesControlDeCaso();
			caso.setFin(cinst);
		}
		
		this.fin = cinst;
		
		for (Caso caso : this.getCasos()){
			cod.addAll(caso.getExp().getCod());
			cod.add(new IntArgInstruction(IntInstruction_t.IR_F, caso.getFin()));
			for(Instruccion inst : caso.getInstrs())
				cod.addAll(inst.getCod());
			cod.add(new IntArgInstruction(IntInstruction_t.IR_A, fin));
		}
	}

	private int numeroInstruccionesControlDeCaso() {
		return 2; // Ir_F despues de Expresión e Ir despues de cuerpo.
	}
}