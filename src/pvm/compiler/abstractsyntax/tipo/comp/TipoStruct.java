package pvm.compiler.abstractsyntax.tipo.comp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pvm.compiler.ErrorsHandler;
import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoStruct extends Tipo {
	private List<DecTipo> dectipos;
	
	private Map<String, DecTipo> campos;
	
	public TipoStruct(List<DecTipo> dectipos) {
		this.dectipos = dectipos;
	}

	@Override
	public String toString() {
		String ret = "struct {\n";
		
		for (DecTipo dectipo : dectipos)
			ret += "\t\t" + dectipo + "\n";
		
		ret += "\t}";
		
		return ret;
	}

	public List<DecTipo> getDectipos() {
		return dectipos;
	}

	public Map<String, DecTipo> getCampos() {
		return campos;
	}

	public void setCampos(Map<String, DecTipo> campos) {
		this.campos = campos;
	}

	@Override
	public void vincula() {
		this.setCampos(new HashMap<String, DecTipo>());
		
		for (DecTipo campo : this.getDectipos()) {
			if (this.getCampos().containsKey(campo.getId())){
				ErrorsHandler.vinculaDuplicatedField(campo.getId(), campo.getRow());
				return;
			}else
				this.getCampos().put(campo.getId(), campo);
			
			campo.getTipo().vincula();
		}
	}

	@Override
	public void vinculaDefPunteros() {
		for (DecTipo dectipo : this.getDectipos())
			dectipo.getTipo().vinculaDefPunteros();
	}

	@Override
	public void chequea() {
		for(Node campo : this.getCampos().values()){
			campo.chequea();
		}
	}

	@Override
	public void simplificaDefTipos() {
		for(DecTipo campo : this.getCampos().values()){
			campo.getTipo().simplificaDefTipos();
		}
	}
}