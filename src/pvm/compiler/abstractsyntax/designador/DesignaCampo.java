package pvm.compiler.abstractsyntax.designador;

public class DesignaCampo extends Designador {
	private Designador desig;
	private String campo;
	
	public DesignaCampo(Designador desig, String campo) {
		super();
		
		this.desig = desig;
		this.campo = campo;
		
		this.childs.add(desig);
	}

	@Override
	public String toString() {
		return desig + "." + campo;
	}

	public String getCampo() {
		return campo;
	}

	public Designador getDesig() {
		return desig;
	}
}