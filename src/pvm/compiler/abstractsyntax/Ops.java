package pvm.compiler.abstractsyntax;

import java.util.ArrayList;
import java.util.List;

import pvm.compiler.abstractsyntax.designador.DesignaArray;
import pvm.compiler.abstractsyntax.designador.DesignaCampo;
import pvm.compiler.abstractsyntax.designador.DesignaId;
import pvm.compiler.abstractsyntax.designador.DesignaPointer;
import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.exp.ExpDesignador;
import pvm.compiler.abstractsyntax.exp.ExpNull;
import pvm.compiler.abstractsyntax.exp.bin.arithm.Division;
import pvm.compiler.abstractsyntax.exp.bin.arithm.Modulo;
import pvm.compiler.abstractsyntax.exp.bin.arithm.Multiplicacion;
import pvm.compiler.abstractsyntax.exp.bin.arithm.Resta;
import pvm.compiler.abstractsyntax.exp.bin.arithm.Suma;
import pvm.compiler.abstractsyntax.exp.bin.bool.And;
import pvm.compiler.abstractsyntax.exp.bin.bool.Or;
import pvm.compiler.abstractsyntax.exp.bin.comp.Desigualdad;
import pvm.compiler.abstractsyntax.exp.bin.comp.Igualdad;
import pvm.compiler.abstractsyntax.exp.bin.comp.Mayor;
import pvm.compiler.abstractsyntax.exp.bin.comp.MayorOigual;
import pvm.compiler.abstractsyntax.exp.bin.comp.Menor;
import pvm.compiler.abstractsyntax.exp.bin.comp.MenorOigual;
import pvm.compiler.abstractsyntax.exp.bool.ExpFalse;
import pvm.compiler.abstractsyntax.exp.bool.ExpTrue;
import pvm.compiler.abstractsyntax.exp.num.ExpNumNat;
import pvm.compiler.abstractsyntax.exp.num.ExpNumReal;
import pvm.compiler.abstractsyntax.exp.unar.arithm.Menos;
import pvm.compiler.abstractsyntax.exp.unar.bool.Not;
import pvm.compiler.abstractsyntax.exp.unar.cast.ToDouble;
import pvm.compiler.abstractsyntax.exp.unar.cast.ToInt;
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
import pvm.compiler.abstractsyntax.seccion.SeccionSubprogramas;
import pvm.compiler.abstractsyntax.seccion.SeccionTipos;
import pvm.compiler.abstractsyntax.seccion.SeccionVariables;
import pvm.compiler.abstractsyntax.subprog.DecSubprograma;
import pvm.compiler.abstractsyntax.subprog.param.ParamRefer;
import pvm.compiler.abstractsyntax.subprog.param.ParamValor;
import pvm.compiler.abstractsyntax.subprog.param.Parametro;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.abstractsyntax.tipo.comp.TipoArray;
import pvm.compiler.abstractsyntax.tipo.comp.TipoStruct;
import pvm.compiler.abstractsyntax.tipo.simp.TipoBoolean;
import pvm.compiler.abstractsyntax.tipo.simp.TipoDouble;
import pvm.compiler.abstractsyntax.tipo.simp.TipoId;
import pvm.compiler.abstractsyntax.tipo.simp.TipoInt;
import pvm.compiler.abstractsyntax.tipo.simp.TipoPointer;

public class Ops {
	public static List<Exp> argumentosvacia() {
		return listavacia();
	}

	public static Caso deccaso(Exp aDeExp0, List<Instruccion> aDeIB) {
		return new Caso(aDeExp0, aDeIB);
	}

	public static List<Caso> deccasoscomp(List<Caso> aDeCasos1, Caso aDeCaso) {
		return listacomp(aDeCasos1, aDeCaso);
	}

	public static List<Caso> deccasossimmp(Caso aDeCaso) {
		return listasimp(aDeCaso);
	}

	public static List<Instruccion> decinstcomp(List<Instruccion> aDeIS,
			Instruccion aDeI) {
		return listacomp(aDeIS, aDeI);
	}

	public static List<Instruccion> decinstsimp(Instruccion aDeI) {
		return listasimp(aDeI);
	}

	public static List<Instruccion> decinstvacia() {
		return listavacia();
	}

	public static Programa decprograma(SeccionTipos aDeST,
			SeccionVariables aDeSV, SeccionSubprogramas aDeSS,
			List<Instruccion> aDeIB) {
		return new Programa(aDeST, aDeSV, aDeSS, aDeIB);
	}

	public static SeccionSubprogramas decsecsubprogramas(
			List<DecSubprograma> aDeDSP) {
		return new SeccionSubprogramas(aDeDSP);
	}

	public static SeccionSubprogramas decsecsubprogramasvacia() {
		return new SeccionSubprogramas(new ArrayList<DecSubprograma>());
	}

	public static SeccionTipos decsectipos(List<DecTipo> aDeDT) {
		return new SeccionTipos(aDeDT);
	}

	public static SeccionTipos decsectiposvacia() {
		return new SeccionTipos(new ArrayList<DecTipo>());
	}

	public static SeccionVariables decsecvar(List<DecTipo> aDeDV) {
		return new SeccionVariables(aDeDV);
	}

	public static SeccionVariables decsecvarvacia() {
		return new SeccionVariables(new ArrayList<DecTipo>());
	}

	public static DecSubprograma decsubprogram(String lexDeID,
			List<Parametro> aDeP, SeccionTipos aDeSTS, SeccionVariables aDeSVS,
			SeccionSubprogramas aDeSPS, List<Instruccion> aDeIB, int row) {
		return new DecSubprograma(aDeP, lexDeID, aDeSTS, aDeSVS, aDeSPS, aDeIB, row);
	}

	public static List<DecSubprograma> decsubprogramacomp(
			List<DecSubprograma> aDeDSPS1, DecSubprograma aDeDSP) {
		return listacomp(aDeDSPS1, aDeDSP);
	}

	public static List<DecSubprograma> decsubprogramasimp(DecSubprograma aDeDSP) {
		return listasimp(aDeDSP);
	}

	public static List<DecTipo> dectiposcomp(List<DecTipo> aDeDTS1,
			DecTipo aDeDT) {
		return listacomp(aDeDTS1, aDeDT);
	}

	public static List<DecTipo> dectipossimp(DecTipo aDeDT) {
		return listasimp(aDeDT);
	}

	public static DecTipo dectipostring(String lexDeID, Tipo aDeTipo, int row) {
		return new DecTipo(lexDeID, aDeTipo, row);
	}
	
	public static DecTipo dectipostringvar(String lexDeID, Tipo aDeTipo, int row) {
		return DecTipo.DecTipoVar(lexDeID, aDeTipo, row);
	}

	public static Designador designaarray(Designador aDeDesig1, Exp aDeExp0, int row) {
		return new DesignaArray(aDeDesig1, aDeExp0, row);
	}

	public static Designador designacampo(Designador aDeDesig1, String lexDeID, int row) {
		return new DesignaCampo(aDeDesig1, lexDeID, row);
	}

	public static Designador designaid(String lexDeID, int row) {
		return new DesignaId(lexDeID, row);
	}

	public static Designador designapointer(Designador aDeDesig1, int row) {
		return new DesignaPointer(aDeDesig1, row);
	}

	public static Exp expdesignador(Designador aDeDesig) {
		return new ExpDesignador(aDeDesig);
	}

	public static Exp expfalse() {
		return new ExpFalse();
	}

	public static Exp expnull() {
		return new ExpNull();
	}
	
	public static Exp exptrue() {
		return new ExpTrue();
	}

	public static Instruccion instasignacion(Designador aDeD, Exp aDeExp0) {
		return new IAsig(aDeD, aDeExp0);
	}

	public static Instruccion instbloque(List<Instruccion> aDeIInstr) {
		return new IBloque(aDeIInstr);
	}

	public static Instruccion instdelete(Designador aDeDesig) {
		return new IDelete(aDeDesig);
	}

	public static Instruccion instdo(List<Caso> aDeCasos) {
		return new IBucle(aDeCasos);
	}

	public static Instruccion instif(List<Caso> aDeCasos) {
		return new ICond(aDeCasos);
	}

	public static Instruccion instllamada(String lexDeID, List<Exp> aDeArgs, int row) {
		return new ILlamada(lexDeID, aDeArgs, row);
	}

	public static Instruccion instnew(Designador aDeDesig) {
		return new INew(aDeDesig);
	}

	public static Instruccion instread(Designador aDeDesig) {
		return new IRead(aDeDesig);
	}

	public static Instruccion instwrite(Exp aDeExp0) {
		return new IWrite(aDeExp0);
	}

	public static List<Exp> listaargumentoscomp(List<Exp> aDeListaArgs1,
			Exp aDeExp0) {
		return listacomp(aDeListaArgs1, aDeExp0);
	}

	public static List<Exp> listaargumentossimp(Exp aDeExp0) {
		return listasimp(aDeExp0);
	}

	private static <E> List<E> listacomp(List<E> list, E elem) {
		list.add(elem);

		return list;
	}

	private static <E> List<E> listasimp(E elem) {
		List<E> ret = new ArrayList<E>();
		ret.add(elem);

		return ret;
	}

	private static <E> List<E> listavacia() {
		return new ArrayList<E>();
	}

	public static Exp mkexp(String opun, Exp aDeExp) {
		switch (opun) {
			case "-":
				return new Menos(aDeExp);
	
			case "not":
				return new Not(aDeExp);
	
			case "todouble":
				return new ToDouble(aDeExp);
	
			case "toint":
				return new ToInt(aDeExp);
	
			default:
				return null;
		}
	}

	public static Exp mkexp(String opbin, Exp aDeExp10, Exp aDeExp11) {
		switch (opbin) {
			case "/":
				return new Division(aDeExp10, aDeExp11);
	
			case "%":
				return new Modulo(aDeExp10, aDeExp11);
	
			case "*":
				return new Multiplicacion(aDeExp10, aDeExp11);
	
			case "-":
				return new Resta(aDeExp10, aDeExp11);
	
			case "+":
				return new Suma(aDeExp10, aDeExp11);
	
			case "and":
				return new And(aDeExp10, aDeExp11);
	
			case "or":
				return new Or(aDeExp10, aDeExp11);
	
			case "!=":
				return new Desigualdad(aDeExp10, aDeExp11);
	
			case "==":
				return new Igualdad(aDeExp10, aDeExp11);
	
			case ">":
				return new Mayor(aDeExp10, aDeExp11);
	
			case ">=":
				return new MayorOigual(aDeExp10, aDeExp11);
	
			case "<":
				return new Menor(aDeExp10, aDeExp11);
	
			case "<=":
				return new MenorOigual(aDeExp10, aDeExp11);
	
			default:
				return null;
		}
	}

	public static Exp numnatural(int naturalnum) {
		return new ExpNumNat(naturalnum);
	}

	public static Exp numreal(double realnum) {
		return new ExpNumReal(realnum);
	}

	public static List<Parametro> parametroscomp(List<Parametro> aDeLPS,
			Parametro aDeP) {
		return listacomp(aDeLPS, aDeP);
	}

	public static List<Parametro> parametrossimp(Parametro aDeP) {
		return listasimp(aDeP);
	}

	public static List<Parametro> parametrosvacia() {
		return listavacia();
	}

	public static Parametro paramrefer(String lexDeID, Tipo aDeTipo) {
		return new ParamRefer(lexDeID, aDeTipo);
	}

	public static Parametro paramvalor(String lexDeID, Tipo aDeTipo) {
		return new ParamValor(lexDeID, aDeTipo);
	}

	public static Tipo tipoarray(Tipo aDeTipo, String lexDeNN) {
		return new TipoArray(aDeTipo, Integer.valueOf(lexDeNN));
	}

	public static Tipo tipoboolean() {
		return new TipoBoolean();
	}

	public static Tipo tipodouble() {
		return new TipoDouble();
	}

	public static Tipo tipoid(String lexDeID, int row) {
		return new TipoId(lexDeID, row);
	}

	public static Tipo tipoint() {
		return new TipoInt();
	}

	public static Tipo tipopointer(Tipo aDeTipo, int row) {
		return new TipoPointer(aDeTipo, row);
	}

	public static Tipo tipostruct(List<DecTipo> aDeCampos) {
		return new TipoStruct(aDeCampos);
	}

	public static int tonaturalnum(String lexDeNN) {
		return Integer.valueOf(lexDeNN);
	}

	public static double torealnum(String lexDeNR) {
		return Double.valueOf(lexDeNR);
	}
}