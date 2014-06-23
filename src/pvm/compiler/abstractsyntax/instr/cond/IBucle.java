package pvm.compiler.abstractsyntax.instr.cond;

import java.util.List;

import pvm.compiler.abstractsyntax.ListNode;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class IBucle extends Instruccion {
	private List<Caso> casos;
	
	public IBucle(List<Caso> casos) {
		super();
		
		this.casos = casos;
		
		this.childs.add(new ListNode<Caso>(casos));
	}

	@Override
	public String toString() {
		String ret = "do\n";
		
		for (Caso caso : casos)
			ret += "\t" + caso + "\n";
		
		ret += "enddo;";
		
		return ret;
	}

	public List<Caso> getCasos() {
		return casos;
	}
}