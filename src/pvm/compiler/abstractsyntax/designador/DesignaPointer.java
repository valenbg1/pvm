package pvm.compiler.abstractsyntax.designador;

public class DesignaPointer extends Designador {
	public DesignaPointer(Designador desig) {
		super();
		
		this.childs.add(desig);
	}

	@Override
	public String toString() {
		return childs.get(0) + "->";
	}
}