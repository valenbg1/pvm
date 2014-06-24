package pvm.compiler.abstractsyntax.designador;

public class DesignaPointer extends Designador {
	private Designador desig;
	
	public DesignaPointer(Designador desig, int vinculo_row) {
		this.desig = desig;
	}

	@Override
	public String toString() {
		return desig + "->";
	}

	public Designador getDesig() {
		return desig;
	}
}