package pvm.compiler.abstractsyntax.instr.cond;

import java.util.ArrayList;
import java.util.List;

import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;

public class IBucle extends Instruccion {
	private List<Caso> casos;
	
	public IBucle(List<Caso> casos) {
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
		String ret = "DO\n";
		
		for (Caso caso : casos)
			ret += "\t\t" + caso + "\t[]\n";
		
		ret += "\tENDDO;";
		
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
		}
		
		this.fin = cinst;
		
		for (Caso caso : this.getCasos()){
			cod.addAll(caso.getCod());
			// En caso.codigo() contamos con una instrucción de más que se pone aqui.
			cod.add(new IntArgInstruction(IntInstruction_t.IR_A, inicio));
		}
	}

}