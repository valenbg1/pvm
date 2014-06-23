package pvm.compiler.abstractsyntax;

import java.util.List;

public class ListNode<E> extends Node {
	private List<E> list;

	public ListNode(List<E> list) {
		super();

		this.list = list;
	}

	public List<E> getList() {
		return list;
	}

	@Override
	public String toString() {
		return list.toString();
	}

}