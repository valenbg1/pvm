package pvm.compiler.abstractsyntax.instr.io;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;
import pvm.compiler.exceptions.CheckFailException;

public class IRead extends Instruccion {
	private Designador desig;
	
	public IRead(Designador desig) {
		this.desig = desig;
	}

	@Override
	public String toString() {
		return "READ " + desig + ";";
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
		if((desig.getTipo() != TipoBoolean.TIPO) &&
		   (desig.getTipo() != TipoDouble.TIPO)  &&
		   (desig.getTipo() != TipoInt.TIPO))
			throw new CheckFailException("El tipo "+desig.getTipo()+" no se puede leer");
	}
}