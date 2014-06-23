package pvm.compiler.abstractsyntax.instr.dynmem;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class IDelete extends Instruccion {
	private Designador desig;
	
	public IDelete(Designador desig) {
		super();
		
		this.desig = desig;
		
		this.childs.add(desig);
	}

	@Override
	public String toString() {
		return "delete " + desig + ";";
	}

	public Designador getDesig() {
		return desig;
	}
}