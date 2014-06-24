package pvm.compiler.abstractsyntax;

import pvm.compiler.SymbolsTable;

public interface Node {
	public static final SymbolsTable sym_t  = new SymbolsTable();;
	@Override
	public abstract String toString();
	public abstract void vincula();
	public abstract void vinculaDefPunteros();
}