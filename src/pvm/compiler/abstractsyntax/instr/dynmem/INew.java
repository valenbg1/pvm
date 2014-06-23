package pvm.compiler.abstractsyntax.instr.dynmem;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;

public class INew extends Instruccion {
	private Designador desig;
	
	public INew(Designador desig) {
		super();
		
		this.desig = desig;
		
		this.childs.add(desig);
	}

	@Override
	public String toString() {
		return "new " + desig + ";";
	}
	
	public Designador getDesig() {
		return desig;
	}
}