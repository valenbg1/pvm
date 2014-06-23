package pvm.compiler.abstractsyntax.instr;

import java.util.List;

public class IBucle extends Instruccion {
	public IBucle(List<Caso> casos) {
		super();
		
		for (Caso caso : casos)
			this.childs.add(caso);
	}

	@Override
	public String toString() {
		String ret = "do\n";
		
		for (int i = 0; i < childs.size(); ++i)
			ret += "\t" + childs.get(i).toString() + "\n";
		
		ret += "enddo;";
		
		return ret;
	}
}