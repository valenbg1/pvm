package pvm.compiler.abstractsyntax.tipo.comp;

import java.util.List;

import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public class TipoStruct extends Tipo {
	public TipoStruct(List<DecTipo> dectipos) {
		super();
		
		for (DecTipo dectipo : dectipos)
			this.childs.add(dectipo);
	}

	@Override
	public String toString() {
		String ret = "struct {\n";
		
		for (int i = 0; i < childs.size(); ++i)
			ret += "\t" + childs.get(i).toString() + ";\n";
		
		ret += "};";
		
		return ret;
	}
}