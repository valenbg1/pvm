package pvm.compiler.abstractsyntax.designador;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public abstract class Designador implements Node {
	public abstract Tipo getTipo();
}