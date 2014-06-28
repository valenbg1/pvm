package pvm.compiler.abstractsyntax.exp;

import java.util.ArrayList;

import pvm.compiler.abstractsyntax.Node;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.PointerInstruction;
import pvm.vm.instructions.PointerInstruction.PointerInstruction_t;

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
		if(this instanceof ExpDesignador)
			return 1;
		else
			return 0;
	}

	public ArrayList<Instruction> codigoAccesoAlValor() {
		ArrayList<Instruction> ret = new ArrayList<Instruction>();
		
		if(this instanceof ExpDesignador)
			ret.add(new PointerInstruction(PointerInstruction_t.APILA_IND));

		return ret;
	}
}