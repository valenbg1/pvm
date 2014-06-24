package pvm.compiler.abstractsyntax.instr;

import java.util.List;

public class IBloque extends Instruccion {
	private List<Instruccion> instrs;

	public IBloque(List<Instruccion> instrs) {
		this.instrs = instrs;
	}

	public List<Instruccion> getInstrs() {
		return instrs;
	}

	@Override
	public String toString() {
		String ret = "\n{\n";

		for (Instruccion instr : instrs)
			ret += "\t" + instr + "\n";

		return ret += "}";
	}

	@Override
	public void vincula() {
		for (Instruccion instr : this.getInstrs())
			instr.vincula();
	}

	@Override
	public void vinculaDefPunteros() {
	}
}