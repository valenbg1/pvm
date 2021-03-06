package pvm.compiler.abstractsyntax.tipo.simp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoPointer extends Tipo {
	public static TipoPointer TipoPointerNull() {
		return new TipoPointer(null, -1, true);
	}
	
	private boolean isNull;
	
	public TipoPointer(Tipo tipo, int row) {
		this(tipo, row, false);
	}
	
	private TipoPointer(Tipo tipo, int row, boolean isNull) {
		this.row = row;
		
		this.tipo_infer = tipo;
		
		this.isNull = isNull;
	}
	
	@Override
	public void asignaEspacio() {
		tipo_infer.asignaEspacio();
		
		tam = 1;
	}

	@Override
	public void chequea() {
		tipo_infer.chequea();
	}

	@Override
	public boolean equals(Tipo other) {
		if (other instanceof TipoPointer) {
			if (((TipoPointer) other).isNull())
				return true;

			return other.getTipo_infer().equals(tipo_infer);	
		}
		
		return false;
	}

	@Override
	public boolean esPointer() {
		return true;
	}

	public boolean isNull() {
		return isNull;
	}

	@Override
	public Tipo tipoSimplificado() {
		tipo_infer = tipo_infer.tipoSimplificado();

		return this;
	}

	@Override
	public String toString() {
		return "pointer " + tipo_infer;
	}

	@Override
	public void vincula() {
		if (!(tipo_infer.esId()))
			tipo_infer.vincula();
		
	}

	@Override
	public void vinculaDefPunteros() {
		if (tipo_infer.esId())
			tipo_infer.vincula();
		else
			tipo_infer.vinculaDefPunteros();
		
	}
}