package pvm.compiler;

import java.util.HashMap;

import pvm.compiler.abstractsyntax.Node;
import pvm.compiler.abstractsyntax.Programa;
import pvm.compiler.abstractsyntax.designador.DesignaArray;
import pvm.compiler.abstractsyntax.designador.DesignaCampo;
import pvm.compiler.abstractsyntax.designador.DesignaId;
import pvm.compiler.abstractsyntax.designador.DesignaPointer;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.ExpDesignador;
import pvm.compiler.abstractsyntax.exp.ExpNull;
import pvm.compiler.abstractsyntax.exp.bin.ExpBin;
import pvm.compiler.abstractsyntax.exp.bool.ExpFalse;
import pvm.compiler.abstractsyntax.exp.bool.ExpTrue;
import pvm.compiler.abstractsyntax.exp.num.ExpNumNat;
import pvm.compiler.abstractsyntax.exp.num.ExpNumReal;
import pvm.compiler.abstractsyntax.exp.unar.ExpUnaria;
import pvm.compiler.abstractsyntax.instr.IAsig;
import pvm.compiler.abstractsyntax.instr.IBloque;
import pvm.compiler.abstractsyntax.instr.ILlamada;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.instr.cond.Caso;
import pvm.compiler.abstractsyntax.instr.cond.IBucle;
import pvm.compiler.abstractsyntax.instr.cond.ICond;
import pvm.compiler.abstractsyntax.instr.dynmem.IDelete;
import pvm.compiler.abstractsyntax.instr.dynmem.INew;
import pvm.compiler.abstractsyntax.instr.io.IRead;
import pvm.compiler.abstractsyntax.instr.io.IWrite;
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
import pvm.compiler.exceptions.UndeclaredIdException;

public class Vinculator {
	private SymbolsTable sym_t;
	
	public Vinculator() {
		this.sym_t = null;
	}
	
	private void vincula(Node node) throws NodeTypeErrorException {
		try {
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
			else if (node instanceof IAsig)
				vinculaIAsig((IAsig) node);
			else if (node instanceof IWrite)
				vincula(((IWrite) node).getExp());
			else if (node instanceof IRead)
				vincula(((IRead) node).getDesig());
			else if (node instanceof INew)
				vincula(((INew) node).getDesig());
			else if (node instanceof IDelete)
				vincula(((IDelete) node).getDesig());
			else if (node instanceof ICond)
				vinculaICond((ICond) node);
			else if (node instanceof IBucle)
				vinculaIBucle((IBucle) node);
			else if (node instanceof IBloque)
				vinculaIBloque((IBloque) node);
			else if (node instanceof ILlamada)
				vinculaILlamada((ILlamada) node);
			else if (node instanceof DesignaId)
				vinculaDesignaId((DesignaId) node);
			else if (node instanceof DesignaCampo)
				vincula(((DesignaCampo) node).getDesig());
			else if (node instanceof DesignaArray)
				vinculaDesignaArray((DesignaArray) node);
			else if (node instanceof DesignaPointer)
				vincula(((DesignaPointer) node).getDesig());
			else if (node instanceof ExpTrue)
				return;
			else if (node instanceof ExpFalse)
				return;
			else if (node instanceof ExpNull)
				return;
			else if (node instanceof ExpNumNat)
				return;
			else if (node instanceof ExpNumReal)
				return;
			else if (node instanceof ExpDesignador)
				vincula(((ExpDesignador) node).getDesig());
			else if (node instanceof ExpBin)
				vinculaExpBin((ExpBin) node);
			else if (node instanceof ExpUnaria)
				vinculaExpUnaria((ExpUnaria) node);
			else
				throw new NodeTypeErrorException(node.getClass().getSimpleName());
		} catch (UndeclaredIdException e) {
			ErrorsHandler.vinculaUndeclaredId(e.getId(), e.getRow());
		} catch (DuplicatedFieldException e) {
			ErrorsHandler.vinculaUndeclaredId(e.getField(), e.getRow());
		} catch (DuplicatedIdException e) {
			ErrorsHandler.vinculaUndeclaredId(e.getId(), e.getRow());
		}
	}
	
	public void vincula(Programa programa) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
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

	private void vinculaDecSubprograma(DecSubprograma node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
		if (!sym_t.insertaId(node.getId(), node))
			throw new DuplicatedIdException(node.getId(), node.getRow());
		
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

	private void vinculaDecTipo(DecTipo node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
		vincula(node.getTipo());
		
		if (!sym_t.insertaId(node.getId(), node.getTipo()))
			throw new DuplicatedIdException(node.getId(), node.getRow());
	}

	private void vinculaDefPunteros(Node node) throws NodeTypeErrorException {
		try {
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
				throw new NodeTypeErrorException(node.getClass().getSimpleName());
		} catch (UndeclaredIdException e) {
			ErrorsHandler.vinculaUndeclaredId(e.getId(), e.getRow());
		} catch (DuplicatedFieldException e) {
			ErrorsHandler.vinculaUndeclaredId(e.getField(), e.getRow());
		} catch (DuplicatedIdException e) {
			ErrorsHandler.vinculaUndeclaredId(e.getId(), e.getRow());
		}
	}

	private void vinculaDefPunterosDecSubprograma(DecSubprograma node) throws NodeTypeErrorException, DuplicatedIdException, DuplicatedFieldException, UndeclaredIdException {
		for (Parametro param : node.getParams())
			vinculaDefPunteros(param.getTipo());
	}

	private void vinculaDefPunterosTipoPointer(TipoPointer node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
		if (node.getTipo() instanceof TipoId)
			vincula(node.getTipo());
		else
			vinculaDefPunteros(node.getTipo());
	}

	private void vinculaDefPunterosTipoStruct(TipoStruct node) throws NodeTypeErrorException, DuplicatedIdException, DuplicatedFieldException, UndeclaredIdException {
		for (DecTipo dectipo : node.getDectipos())
			vinculaDefPunteros(dectipo.getTipo());
	}

	private void vinculaDesignaArray(DesignaArray node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
		vincula(node.getDesig());
		vincula(node.getExp());
	}

	private void vinculaDesignaId(DesignaId node) throws UndeclaredIdException {
		node.setVinculo(sym_t.declaracion(node.getId()));
		
		if (node.getVinculo() == null)
			throw new UndeclaredIdException(node.getId(), node.getRow());
	}

	private void vinculaExpBin(ExpBin node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
		vincula(node.getExp0());
		vincula(node.getExp1());
	}
	
	private void vinculaExpUnaria(ExpUnaria node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
		vincula(node.getExp());
	}

	private void vinculaIAsig(IAsig node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
		vincula(node.getDesig());
		vincula(node.getExp());
	}

	private void vinculaIBloque(IBloque node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
		for (Instruccion instr : node.getInstrs())
			vincula(instr);
	}

	private void vinculaIBucle(IBucle node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
		for (Caso caso : node.getCasos()) {
			vincula(caso.getExp());
			
			for (Instruccion instr : caso.getInstrs())
				vincula(instr);
		}
	}

	private void vinculaICond(ICond node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
		for (Caso caso : node.getCasos()) {
			vincula(caso.getExp());
			
			for (Instruccion instr : caso.getInstrs())
				vincula(instr);
		}
	}

	private void vinculaILlamada(ILlamada node) throws UndeclaredIdException, DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException {
		node.setVinculo(sym_t.declaracion(node.getId()));
		
		if (node.getVinculo() == null)
			throw new UndeclaredIdException(node.getId(), node.getRow());
		
		for (Exp exp : node.getArgs())
			vincula(exp);
	}

	private void vinculaTipoArray(TipoArray node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
		vincula(node.getTipo());
	}

	private void vinculaTipoId(TipoId node) throws DuplicatedIdException, UndeclaredIdException {
		node.setVinculo(sym_t.declaracion(node.getId()));
		
		if (node.getVinculo() == null)
			throw new UndeclaredIdException(node.getId(), node.getRow());
	}

	private void vinculaTipoPointer(TipoPointer node) throws DuplicatedIdException, NodeTypeErrorException, DuplicatedFieldException, UndeclaredIdException {
		if (!(node.getTipo() instanceof TipoId))
			vincula(node.getTipo());
	}

	private void vinculaTipoStruct(TipoStruct node) throws DuplicatedFieldException, DuplicatedIdException, NodeTypeErrorException, UndeclaredIdException {
		node.setCampos(new HashMap<String, Node>());
		
		for (DecTipo campo : node.getDectipos()) {
			if (node.getCampos().containsKey(campo.getId()))
				throw new DuplicatedFieldException(campo.getId(), campo.getRow());
			else
				node.getCampos().put(campo.getId(), campo);
			
			vincula(campo.getTipo());
		}
	}
}