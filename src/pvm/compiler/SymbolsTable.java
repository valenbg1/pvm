package pvm.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pvm.compiler.abstractsyntax.Node;

public class SymbolsTable {
	private List<Map<String, Node>> sym_t;
	private int size;

	public SymbolsTable() {
		this.sym_t = new ArrayList<Map<String, Node>>();
		this.size = 0;
	}

	public void abreBloque() {
		sym_t.add(new HashMap<String, Node>());
		++size;
	}

	public void cierraBloque() {
		sym_t.remove(size - 1);
		--size;
	}

	public Node declaracion(String id) {
		Node ret = null;

		for (int i = size - 1; i >= 0; --i) {
			if ((ret = sym_t.get(i).get(id)) != null)
				break;
		}

		return ret;
	}

	public boolean insertaId(String id, Node dec) {
		return !sym_t.get(size - 1).containsKey(id)
				&& (sym_t.get(size - 1).put(id, dec) == null);
	}
	
	@Override
	public String toString() {
		String ret = "";
		
		for (int i = 0; i < size; ++i)
			ret += sym_t.get(i) + "\n";
		
		return ret;
	}
}