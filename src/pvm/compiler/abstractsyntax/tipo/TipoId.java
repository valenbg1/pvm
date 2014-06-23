package pvm.compiler.abstractsyntax.tipo;

public class TipoId extends Tipo {
	private String id;

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "tipo " + id;
	}
}