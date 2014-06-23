package pvm.compiler.abstractsyntax;

import java.util.List;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.instr.Instruccion;
import pvm.compiler.abstractsyntax.instr.cond.Caso;
import pvm.compiler.abstractsyntax.seccion.SeccionSubprogramas;
import pvm.compiler.abstractsyntax.seccion.SeccionTipos;
import pvm.compiler.abstractsyntax.seccion.SeccionVariables;
import pvm.compiler.abstractsyntax.subprog.DecSubprograma;
import pvm.compiler.abstractsyntax.subprog.param.Parametro;
import pvm.compiler.abstractsyntax.tipo.DecTipo;
import pvm.compiler.abstractsyntax.tipo.Tipo;

public class Ops {
	public static List<Exp> argumentosvacia() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Caso deccaso(Exp aDeExp0, List<Instruccion> aDeIB) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Caso> deccasoscomp(List<Caso> aDeCasos1, Caso aDeCaso) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Caso> deccasossimmp(Caso aDeCaso) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Instruccion> decinstcomp(List<Instruccion> aDeIS,
			Instruccion aDeI) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Instruccion> decinstsimp(Instruccion aDeI) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Instruccion> decinstvacia() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Programa decprograma(SeccionTipos aDeST,
			SeccionVariables aDeSV, SeccionSubprogramas aDeSS,
			List<Instruccion> aDeIB) {
		// TODO Auto-generated method stub
		return null;
	}

	public static SeccionSubprogramas decsecsubprogramas(
			List<DecSubprograma> aDeDSP) {
		// TODO Auto-generated method stub
		return null;
	}

	public static SeccionSubprogramas decsecsubprogramasvacia() {
		// TODO Auto-generated method stub
		return null;
	}

	public static SeccionTipos decsectipos(List<DecTipo> aDeDT) {
		// TODO Auto-generated method stub
		return null;
	}

	public static SeccionTipos decsectiposvacia() {
		// TODO Auto-generated method stub
		return null;
	}

	public static SeccionVariables decsecvar(List<DecTipo> aDeDV) {
		// TODO Auto-generated method stub
		return null;
	}

	public static SeccionVariables decsecvarvacia() {
		// TODO Auto-generated method stub
		return null;
	}

	public static DecSubprograma decsubprogram(String lexDeID,
			List<Parametro> aDeP, SeccionTipos aDeSTS, SeccionVariables aDeSVS,
			SeccionSubprogramas aDeSPS, List<Instruccion> aDeIB) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<DecSubprograma> decsubprogramacomp(
			List<DecSubprograma> aDeDSPS1, DecSubprograma aDeDSP) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<DecSubprograma> decsubprogramasimp(DecSubprograma aDeDSP) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<DecTipo> dectiposcomp(List<DecTipo> aDeDTS1,
			DecTipo aDeDT) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<DecTipo> dectipossimp(DecTipo aDeDT) {
		// TODO Auto-generated method stub
		return null;
	}

	public static DecTipo dectiposstring(String lexDeID, Tipo aDeTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static DecTipo dectipostring(String lexDeID, Tipo aDeTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Designador designaarray(Designador aDeDesig1, Exp aDeExp0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Designador designacampo(Designador aDeDesig1, String lexDeID) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Designador designaid(String lexDeID) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Designador designapointer(Designador aDeDesig1) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Exp expdesignador(Designador aDeDesig) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Exp expfalse() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Exp exptrue() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Instruccion instasignacion(Designador aDeD, Exp aDeExp0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Instruccion instbloque(List<Instruccion> aDeIInstr) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Instruccion instdelete(Designador aDeDesig) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Instruccion instdo(List<Caso> aDeCasos) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Instruccion instif(List<Caso> aDeCasos) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Instruccion instllamada(String lexDeID, List<Exp> aDeArgs) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Instruccion instnew(Designador aDeDesig) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Instruccion instread(Designador aDeDesig) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Instruccion instwrite(Exp aDeExp0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Exp> listaargumentoscomp(List<Exp> aDeListaArgs1,
			Exp aDeExp0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Exp> listaargumentossimp(Exp aDeExp0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Exp mkexp(String opun, Exp aDeExp) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Exp mkexp(String opbin, Exp aDeExp10, Exp aDeExp11) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Exp numnatural(int tonaturalnum) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Exp numreal(double torealnum) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Parametro> parametroscomp(List<Parametro> aDeLPS,
			Parametro aDeP) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Parametro> parametrossimp(Parametro aDeP) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Parametro> parametrosvacia() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Parametro paramrefer(String lexDeID, Tipo aDeTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Parametro paramvalor(String lexDeID, Tipo aDeTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Tipo tipoarray(Tipo aDeTipo, String lexDeNN) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Tipo tipoboolean() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Tipo tipodouble() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Tipo tipoid(String lexDeID) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Tipo tipoint() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Tipo tipopointer(Tipo aDeTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Tipo tipostruct(List<DecTipo> aDeCampos) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int tonaturalnum(String lexDeNN) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static double torealnum(String lexDeNR) {
		// TODO Auto-generated method stub
		return 0;
	}
}