package pvm.compiler.abstractsyntax.instr.cond;

import java.util.List;

import pvm.compiler.abstractsyntax.ListNode;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class ICond extends Instruccion {
	private List<Caso> casos;
	
	public ICond(List<Caso> casos) {
		super();
		
		this.casos = casos;
		
		this.childs.add(new ListNode<Caso>(casos));
	}

	@Override
	public String toString() {
		String ret = "if\n";
		
		for (Caso caso : casos)
			ret += "\t" + caso + "\n";
		
		ret += "endif;";
		
		return ret;
	}

	public List<Caso> getCasos() {
		return casos;
	}
}