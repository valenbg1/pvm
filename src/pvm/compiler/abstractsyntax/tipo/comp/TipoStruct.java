package pvm.compiler.abstractsyntax.tipo.comp;

import java.util.List;
import java.util.Map;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoStruct extends Tipo {
	private List<DecTipo> dectipos;
	
	private Map<String, Node> campos;
	
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

	public Map<String, Node> getCampos() {
		return campos;
	}

	public void setCampos(Map<String, Node> campos) {
		this.campos = campos;
	}
}