package pvm.compiler.abstractsyntax.instr.cond;

import java.util.List;

import pvm.compiler.abstractsyntax.instr.Instruccion;

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
}