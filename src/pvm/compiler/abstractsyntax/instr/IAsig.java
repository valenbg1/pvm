package pvm.compiler.abstractsyntax.instr;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.exp.Exp;

public class IAsig extends Instruccion {
	public IAsig(Designador desig, Exp exp) {
		super();
		
		this.childs.add(desig);
		this.childs.add(exp);
	}

	@Override
	public String toString() {
		return childs.get(0).toString() + " = " + childs.get(1).toString() + ";";
	}
}