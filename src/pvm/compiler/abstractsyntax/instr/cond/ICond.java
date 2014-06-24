package pvm.compiler.abstractsyntax.instr.cond;

import java.util.List;

import pvm.compiler.abstractsyntax.instr.Instruccion;

public class ICond extends Instruccion {
	private List<Caso> casos;
	
	public ICond(List<Caso> casos) {
		this.casos = casos;
	}

	@Override
	public String toString() {
		String ret = "IF\n";
		
		for (Caso caso : casos)
			ret += "\t\t" + caso + "\t[]\n";
		
		ret += "\tENDIF;";
		
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
}