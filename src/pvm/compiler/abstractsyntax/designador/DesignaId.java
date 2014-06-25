package pvm.compiler.abstractsyntax.designador;

import pvm.compiler.ErrorsHandler;

public class DesignaId extends Designador {
	private String id;
	
	public DesignaId(String id, int row) {
		this.row = row;
		
		this.id = id;
	}

	@Override
	public void chequea() {
		if (!vinculo.esVariable() || !vinculo.esParametro())
			ErrorsHandler.chequeaIdentificadorNoDeEsTipo("param o var", id, row);
		
		tipo_infer = vinculo.getTipo_infer();
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}

	@Override
	public void vincula() {
		vinculo = sym_t.declaracion(id);
		
		if (vinculo == null)
			ErrorsHandler.vinculaUndeclaredId(id, row);
	}
}