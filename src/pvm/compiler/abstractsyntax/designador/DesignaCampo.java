package pvm.compiler.abstractsyntax.designador;

public class DesignaCampo extends Designador {
	private String campo;
	
	public DesignaCampo(Designador desig, String campo) {
		super();
		
		this.childs.add(desig);
		this.campo = campo;
	}

	@Override
	public String toString() {
		return childs.get(0) + "." + campo;
	}

	public String getCampo() {
		return campo;
	}
}