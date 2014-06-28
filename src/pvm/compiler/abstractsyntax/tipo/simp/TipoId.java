package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoId extends Tipo {
	private String id;
	
	public TipoId(String id, int row) {
		this.row = row;
		
		this.id = id;
	}

	@Override
	public void chequea() {
		if(!(vinculo instanceof DecTipo))
			ErrorsHandler.chequeaIdentificadorNoEsTipo(id, row);
	}

	@Override
	public boolean equals(Tipo other) {
		return tipo_infer.equals(other.getTipo_infer());
	}

	@Override
	public boolean esId() {
		return true;
	}

	public String getId() {
		return id;
	}

	@Override
	public Tipo tipoSimplificado() {
		while (vinculo.getTipo_infer().esId())
			vinculo = vinculo.getTipo_infer();
		
		return vinculo.getTipo_infer();
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

	@Override
	public void vinculaDefPunteros() {}

}