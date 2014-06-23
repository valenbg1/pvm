package pvm.compiler.abstractsyntax.designador;

public class DesignaPointer extends Designador {
	private Designador desig;
	
	public DesignaPointer(Designador desig) {
		super();
		
		this.desig = desig;
		
		this.childs.add(desig);
	}

	@Override
	public String toString() {
		return desig + "->";
	}

	public Designador getDesig() {
		return desig;
	}
}