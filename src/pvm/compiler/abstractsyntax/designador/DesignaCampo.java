package pvm.compiler.abstractsyntax.designador;


public class DesignaCampo extends Designador {
	private Designador desig;
	private String campo;
	
	public DesignaCampo(Designador desig, String campo, int vinculo_row) {
		this.desig = desig;
		this.campo = campo;
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

	@Override
	public void vincula() {
		this.getDesig().vincula();
	}

	@Override
	public void vinculaDefPunteros() {
	}
}