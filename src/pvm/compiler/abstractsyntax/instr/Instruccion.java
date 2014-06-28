package pvm.compiler.abstractsyntax.instr;

import java.util.ArrayList;

import pvm.compiler.abstractsyntax.Node;
import pvm.vm.instructions.Instruction;

public abstract class Instruccion extends Node {
	@Override
	public int anidamientoDe() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void asignaEspacio() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void simplificaDefTipos() {}
	
	@Override
	public void vinculaDefPunteros() {}
	
}