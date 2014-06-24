package pvm.compiler;

import java.util.HashMap;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.Programa;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.subprog.DecSubprograma;
import pvm.compiler.abstractsyntax.subprog.param.Parametro;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.abstractsyntax.tipo.comp.TipoArray;
import pvm.compiler.abstractsyntax.tipo.comp.TipoStruct;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;
import pvm.compiler.abstractsyntax.tipo.simp.TipoId;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;
import pvm.compiler.abstractsyntax.tipo.simp.TipoPointer;
import pvm.compiler.exceptions.DuplicatedFieldException;
import pvm.compiler.exceptions.DuplicatedIdException;
import pvm.compiler.exceptions.NodeTypeErrorException;

public class Vinculator {
	private SymbolsTable sym_t = null;
	
	private void vincula(Node node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException {
		// TODO pág 5 procesamiento de las instrucciones
		
		if (node instanceof DecTipo)
			vinculaDecTipo((DecTipo) node);
		else if (node instanceof DecSubprograma)
			vinculaDecSubprograma((DecSubprograma) node);
		else if (node instanceof TipoBoolean)
			return;
		else if (node instanceof TipoInt)
			return;
		else if (node instanceof TipoId)
			vinculaTipoId((TipoId) node);
		else if (node instanceof TipoArray)
			vinculaTipoArray((TipoArray) node);
		else if (node instanceof TipoStruct)
			vinculaTipoStruct((TipoStruct) node);
		else if (node instanceof TipoPointer)
			vinculaTipoPointer((TipoPointer) node);
		else
			throw new NodeTypeErrorException();
	}
	
	public void vincula(Programa programa) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException {
		sym_t = new SymbolsTable();
		sym_t.abreBloque();
		
		for (DecTipo dectipo : programa.getSectipos().getDectipos())
			vincula(dectipo);
		
		for (DecTipo decvar : programa.getSecvars().getDectipos())
			vincula(decvar);
		
		for (DecSubprograma decsubprog : programa.getSecsubprogs().getDecsubprogramas())
			vincula(decsubprog);
		
		
		for (DecTipo dectipo : programa.getSectipos().getDectipos())
			vinculaDefPunteros(dectipo);
		
		for (DecTipo decvar : programa.getSecvars().getDectipos())
			vinculaDefPunteros(decvar);
		
		for (DecSubprograma decsubprog : programa.getSecsubprogs().getDecsubprogramas())
			vinculaDefPunteros(decsubprog);
		
		
		for (Instruccion instr : programa.getInstrs())
			vincula(instr);
	}
	
	private void vinculaDecSubprograma(DecSubprograma node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException {
		if (!sym_t.insertaId(node.getId(), node))
			throw new DuplicatedIdException();
		
		sym_t.abreBloque();
		sym_t.insertaId(node.getId(), node);
		
		for (Parametro param : node.getParams())
			sym_t.insertaId(param.getId(), param);
		
		
		for (DecTipo dectipo : node.getSectipos().getDectipos())
			vincula(dectipo);
		
		for (DecTipo decvar : node.getSecvars().getDectipos())
			vincula(decvar);
		
		for (DecSubprograma decsubprog : node.getSecsubprogs().getDecsubprogramas())
			vincula(decsubprog);
		
		
		for (DecTipo dectipo : node.getSectipos().getDectipos())
			vinculaDefPunteros(dectipo);
		
		for (DecTipo decvar : node.getSecvars().getDectipos())
			vinculaDefPunteros(decvar);
		
		for (DecSubprograma decsubprog : node.getSecsubprogs().getDecsubprogramas())
			vinculaDefPunteros(decsubprog);
		
		
		for (Instruccion instr : node.getInstrs())
			vincula(instr);
		
		sym_t.cierraBloque();
	}

	private void vinculaDecTipo(DecTipo node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException {
		vincula(node.getTipo());
		
		if (!sym_t.insertaId(node.getId(), node))
			throw new DuplicatedIdException();
	}

	private void vinculaDefPunteros(Node node) throws NodeTypeErrorException, DuplicatedIdException, DuplicatedFieldException {
		// TODO pág 5 procesamiento de las instrucciones
		
		if (node instanceof DecTipo)
			vinculaDefPunteros(((DecTipo) node).getTipo());
		else if (node instanceof DecSubprograma)
			vinculaDefPunterosDecSubprograma((DecSubprograma) node);
		else if (node instanceof TipoBoolean)
			return;
		else if (node instanceof TipoInt)
			return;
		else if (node instanceof TipoId)
			return;
		else if (node instanceof TipoArray)
			vinculaDefPunteros(((TipoArray) node).getTipo());
		else if (node instanceof TipoStruct)
			vinculaDefPunterosTipoStruct((TipoStruct) node);
		else if (node instanceof TipoPointer)
			vinculaDefPunterosTipoPointer((TipoPointer) node);
		else
			throw new NodeTypeErrorException();
	}

	private void vinculaDefPunterosDecSubprograma(DecSubprograma node) throws NodeTypeErrorException, DuplicatedIdException, DuplicatedFieldException {
		for (Parametro param : node.getParams())
			vinculaDefPunteros(param.getTipo());
	}

	private void vinculaDefPunterosTipoPointer(TipoPointer node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException {
		if (node.getTipo() instanceof TipoPointer)
			vincula(node.getTipo());
		else
			vinculaDefPunteros(node.getTipo());
	}

	private void vinculaDefPunterosTipoStruct(TipoStruct node) throws NodeTypeErrorException, DuplicatedIdException, DuplicatedFieldException {
		for (DecTipo dectipo : node.getDectipos())
			vinculaDefPunteros(dectipo.getTipo());
	}

	private void vinculaTipoArray(TipoArray node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException {
		vincula(node.getTipo());
	}

	private void vinculaTipoId(TipoId node) throws DuplicatedIdException {
		node.setVinculo(sym_t.declaracion(node.getId()));
		
		if (node.getVinculo() == null)
			throw new DuplicatedIdException();
	}

	private void vinculaTipoPointer(TipoPointer node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException {
		if (!((node.getTipo() instanceof TipoPointer)))
			vincula(node.getTipo());
	}

	private void vinculaTipoStruct(TipoStruct node) throws DuplicatedFieldException, DuplicatedIdException, NodeTypeErrorException {
		node.setCampos(new HashMap<String, Node>());
		
		for (DecTipo campo : node.getDectipos()) {
			if (node.getCampos().containsKey(campo.getId()))
				throw new DuplicatedFieldException();
			else
				node.getCampos().put(campo.getId(), campo);
			
			vincula(campo.getTipo());
		}
	}
}