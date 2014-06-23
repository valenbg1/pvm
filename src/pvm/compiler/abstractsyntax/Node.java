package pvm.compiler.abstractsyntax;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {
	protected List<Node> childs;

	protected Node() {
		this.childs = new ArrayList<Node>();
	}

	public List<Node> getChilds() {
		return childs;
	}

	@Override
	public abstract String toString();
}