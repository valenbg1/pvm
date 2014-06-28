package pvm.compiler.abstractsyntax.exp;

import java.util.ArrayList;

import pvm.compiler.abstractsyntax.Node;
import pvm.vm.instructions.Instruction;

public abstract class Exp extends Node {
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

	public int numInstruccionesAccesoValor() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Instruction> codigoAccesoAlValor() {
		// TODO Auto-generated method stub
		return null;
	}
}