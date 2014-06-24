package pvm.compiler.abstractsyntax.instr.dynmem;

import pvm.compiler.abstractsyntax.designador.DesignaId;
import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.exceptions.CheckFailException;

public class INew extends Instruccion {
	private Designador desig;
	
	public INew(Designador desig) {
		this.desig = desig;
	}

	@Override
	public String toString() {
		return "NEW " + desig + ";";
	}
	
	public Designador getDesig() {
		return desig;
	}

	@Override
	public void vincula() {
		this.getDesig().vincula();
	}

	@Override
	public void vinculaDefPunteros() {
	}

	@Override
	public void chequea() throws CheckFailException {
		if(!(desig instanceof DesignaId))
			throw new CheckFailException("Intentas hacer new de "+desig+ " que no es un identificador.");
	}
}