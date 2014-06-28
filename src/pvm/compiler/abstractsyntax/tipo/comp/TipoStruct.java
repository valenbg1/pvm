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
	private Map<String, Integer> desp_campos;
	
	public TipoStruct(List<DecTipo> dectipos) {
		this.dectipos = dectipos;
	}

	@Override
	public void asignaEspacio() {
		if (tam == -1) {
			tam = 0;
			desp_campos = new HashMap<String, Integer>();
			
			for (DecTipo dectipo : dectipos) {
				desp_campos.put(dectipo.getId(), tam);
				dectipo.getTipo_infer().asignaEspacio();
				tam += dectipo.getTipo_infer().getTam();
			}
		}
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

	public Map<String, Integer> getDesp_campos() {
		return desp_campos;
	}

	public void setCampos(Map<String, DecTipo> campos) {
		this.campos = campos;
	}

	public void setDesp_campos(Map<String, Integer> desp_campos) {
		this.desp_campos = desp_campos;
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
		
		for (DecTipo dectipo : dectipos) {
			if (dectipo.getTipo_infer().esPointer()
					&& (dectipo.getTipo_infer().getTipo_infer() == this))
				ret += "\t\t" + dectipo.getId() + ": pointer this;" + "\n";
			else
				ret += "\t\t" + dectipo + "\n";
		}
		
		ret += "\t}";
		
		return ret;
	}

	@Override
	public void vincula() {
		campos = new HashMap<String, DecTipo>();
		
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