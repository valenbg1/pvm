package pvm.compiler.abstractsyntax.instr.cond;

import java.util.List;

import pvm.compiler.abstractsyntax.instr.Instruccion;

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
}