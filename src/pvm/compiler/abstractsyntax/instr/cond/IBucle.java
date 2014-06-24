package pvm.compiler.abstractsyntax.instr.cond;

import java.util.List;

import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.exceptions.CheckFailException;

public class IBucle extends Instruccion {
	private List<Caso> casos;
	
	public IBucle(List<Caso> casos) {
		this.casos = casos;
	}

	@Override
	public String toString() {
		String ret = "DO\n";
		
		for (Caso caso : casos)
			ret += "\t\t" + caso + "\t[]\n";
		
		ret += "\tENDDO;";
		
		return ret;
	}

	public List<Caso> getCasos() {
		return casos;
	}

	@Override
	public void vincula() {
		for (Caso caso : this.getCasos()) {
			caso.getExp().vincula();
			
			for (Instruccion instr : caso.getInstrs())
				instr.vincula();
		}
	}

	@Override
	public void vinculaDefPunteros() {
	}

	@Override
	public void chequea() throws CheckFailException {
		for (Caso caso : this.getCasos()) {
			caso.chequea();
		}
	}
}