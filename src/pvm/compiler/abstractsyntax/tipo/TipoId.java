package pvm.compiler.abstractsyntax.tipo;

public class TipoId extends Tipo {
	public TipoId(String id) {
		super();
		
		this.id = id;
	}

	private String id;

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}
}