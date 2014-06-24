package pvm.compiler.abstractsyntax;

import java.util.List;

public class ListNode<E extends Node> extends Node {
	private List<E> list;

	public ListNode(List<E> list) {
		super();

		this.list = list;
		
		for (E elem : list)
			this.childs.add(elem);
	}

	public List<E> getList() {
		return list;
	}

	@Override
	public String toString() {
		return list.toString();
	}

}