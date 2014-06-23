package pvm.compiler.abstractsyntax.designador;

public class DesignaId extends Designador {
	private String id;
	
	public DesignaId(String id) {
		super();
		
		this.id = id;
	}

	@Override
	public String toString() {
		return id;
	}

	public String getId() {
		return id;
	}
}