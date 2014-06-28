package pvm.compiler.abstractsyntax.tipo.comp;

import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoArray extends Tipo {
	private int num;
	
	public TipoArray(Tipo tipo, int num) {
		this.num = num;
		
		this.tipo_infer = tipo;
	}

	@Override
	public void asignaEspacio() {
		if (tam == -1) {
			tipo_infer.asignaEspacio();
			tam = tipo_infer.getTam()*num;
		}
	}

	@Override
	public void chequea() {
		tipo_infer.chequea();
	}

	@Override
	public boolean equals(Tipo other) {
		return (other instanceof TipoArray)
				&& (other.getTipo_infer().equals(tipo_infer))
				&& (((TipoArray) other).getNum() == num);
	}

	@Override
	public boolean esArray() {
		return true;
	}

	public int getNum() {
		return num;
	}
	
	@Override
	public Tipo tipoSimplificado() {
		tipo_infer = tipo_infer.tipoSimplificado();
		
		return this;
	}

	@Override
	public String toString() {
		return "ARRAY " + tipo_infer + "[" + num + "]";
	}

	@Override
	public void vincula() {
		tipo_infer.vincula();
	}

	@Override
	public void vinculaDefPunteros() {
		tipo_infer.vinculaDefPunteros();
	}
}