package pvm.compiler.abstractsyntax;

import pvm.compiler.SymbolsTable;
import pvm.compiler.exceptions.CheckFailException;

public interface Node {
	public static final SymbolsTable sym_t  = new SymbolsTable();;
	@Override
	public abstract String toString();
	public abstract void vincula();
	public abstract void vinculaDefPunteros();
	
	public abstract void chequea() throws CheckFailException;
}