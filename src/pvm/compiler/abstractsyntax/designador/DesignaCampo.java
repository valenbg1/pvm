package pvm.compiler.abstractsyntax.designador;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.abstractsyntax.tipo.comp.TipoStruct;



public class DesignaCampo extends Designador {
	private Designador desig;
	private String campo;
	
	public DesignaCampo(Designador desig, String campo, int vinculo_row) {
		this.desig = desig;
		this.campo = campo;
	}

	@Override
	public void chequea() {
		desig.chequea();
		
		if (desig.getTipo_infer() != null) {
			if (desig.getTipo_infer().esStruct()) {
				DecTipo c = ((TipoStruct) desig.getTipo_infer()).getCampos().get(campo);
				
				if (c == null)
					ErrorsHandler.chequeaCampoNoExiste(campo, desig, row);
				else
					tipo_infer = c.getTipo_infer();
			} else
				ErrorsHandler.chequeaDesignadorNoEsDeTipo("STRUCT", desig, desig.getRow());
		}
	}

	public String getCampo() {
		return campo;
	}

	public Designador getDesig() {
		return desig;
	}

	@Override
	public String toString() {
		return desig + "." + campo;
	}

	@Override
	public void vincula() {
		desig.vincula();
	}
}