package pvm.compiler.abstractsyntax.tipo.comp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoStruct extends Tipo {
	private List<DecTipo> dectipos;
	
	private Map<String, DecTipo> campos;
	
	public TipoStruct(List<DecTipo> dectipos) {
		this.dectipos = dectipos;
	}

	@Override
	public void chequea() {
		for (DecTipo dectipo : dectipos)
			dectipo.getTipo_infer().chequea();
	}

	@Override
	public boolean equals(Tipo other) {
		if (other instanceof TipoStruct) {
			for (DecTipo dectipo : campos.values()) {
				if (!((TipoStruct) other).getCampos().containsValue(dectipo))
					return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean esStruct() {
		return true;
	}

	public Map<String, DecTipo> getCampos() {
		return campos;
	}

	public List<DecTipo> getDectipos() {
		return dectipos;
	}

	public void setCampos(Map<String, DecTipo> campos) {
		this.campos = campos;
	}

	@Override
	public Tipo tipoSimplificado() {
		for (DecTipo dectipo : dectipos)
			dectipo.setTipo_infer(dectipo.getTipo_infer().tipoSimplificado());
		
		return this;
	}

	@Override
	public String toString() {
		String ret = "struct {\n";
		
		for (DecTipo dectipo : dectipos)
			ret += "\t\t" + dectipo + "\n";
		
		ret += "\t}";
		
		return ret;
	}

	@Override
	public void vincula() {
		this.setCampos(new HashMap<String, DecTipo>());
		
		for (DecTipo campo : dectipos) {
			if (campos.containsKey(campo.getId()))
				ErrorsHandler.vinculaDuplicatedField(campo.getId(), campo.getRow());
			else
				campos.put(campo.getId(), campo);
			
			campo.getTipo_infer().vincula();
		}
	}

	@Override
	public void vinculaDefPunteros() {
		for (DecTipo dectipo : dectipos)
			dectipo.getTipo_infer().vinculaDefPunteros();
	}
}