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
		if((desig.getTipo_infer() != TipoBoolean.TIPO) &&
		   (desig.getTipo_infer() != TipoDouble.TIPO)  &&
		   (desig.getTipo_infer() != TipoInt.TIPO))
			throw new CheckFailException("El tipo "+desig.getTipo_infer()+" no se puede leer");
	}
}