package pvm.compiler;

import pvm.compiler.abstractsyntax.designador.Designador;
import pvm.compiler.abstractsyntax.exp.Exp;
import pvm.compiler.abstractsyntax.instr.IAsig;
import pvm.compiler.abstractsyntax.tipo.Tipo;
import pvm.compiler.lexanalyzer.LexicalUnit;

public class ErrorsHandler {
	public static void chequeaCampoNoExiste(String campo, Designador desig,
			int row) {
		System.err.println("ERROR campo '" + campo + "' no existe en " + desig
				+ " en la fila " + row);
		System.exit(1);
	}

	public static void chequeaDesignadorNoEsDeTipo(String tipo,
			Designador desig, int row) {
		System.err.println("ERROR designador '" + desig + "' no es de tipo "
				+ tipo + " en la fila " + row);
		System.exit(1);
	}

	public static void chequeaExpresionNoEsDeTipo(String tipo, Exp exp, int row) {
		System.err.println("ERROR expresion '" + exp + "' no es de tipo "
				+ tipo + " en la fila " + row);
		System.exit(1);
	}

	public static void chequeaIdentificadorNoDeEsTipo(String tipo, String id,
			int row) {
		System.err.println("ERROR identificador '" + id + "' no es de tipo "
				+ tipo + " en la fila " + row);
		System.exit(1);
	}

	public static void chequeaIdentificadorNoEsSubprograma(String id, int row) {
		System.err.println("ERROR identificador '" + id
				+ "' no es un subprograma definido" + " en la fila " + row);
		System.exit(1);
	}

	public static void chequeaIdentificadorNoEsTipo(String id, int row) {
		System.err.println("ERROR identificador '" + id
				+ "' no es un tipo definido en la fila " + row);
		System.exit(1);
	}

	public static void chequeaTiposNoAritmeticos(Exp exp, int row) {
		System.err.println("ERROR los tipos en '" + exp
				+ "' no son aritmeticos en la fila " + row);
		System.exit(1);
	}

	public static void chequeaTiposNoBooleanos(Exp exp, int row) {
		System.err.println("ERROR los tipos en '" + exp
				+ "' no son booleanos en la fila " + row);
		System.exit(1);
	}

	public static void chequeaTiposNoComparables(Exp exp, int row) {
		System.err.println("ERROR los tipos en '" + exp
				+ "' no son comparables en la fila " + row);
		System.exit(1);
	}

	public static void chequeaTiposNoCompatibles(IAsig iasig, Tipo tipo1,
			Tipo tipo2, int row) {
		System.err.println("ERROR tipos " + tipo1 + ", " + tipo2
				+ " no compatibles en '" + iasig + "' en la fila " + row);
		System.exit(1);
	}

	public static void error(String error) {
		System.err.println(error);
		System.exit(1);
	}

	public static void lexicalError(int row, String lex) {
		System.err.println("ERROR fila " + row + ": Caracter inexperado: "
				+ lex);
		System.exit(1);
	}

	public static void syntacticError(LexicalUnit lexicalUnit) {
		System.err.println("ERROR fila " + lexicalUnit.row()
				+ ": Elemento inexperado " + lexicalUnit.value + " ("
				+ lexicalUnit.sym + ")");
		System.exit(1);
	}

	public static void vinculaDuplicatedField(String field, int row) {
		System.err.println("ERROR campo duplicado '" + field + "' en la fila "
				+ row);
		System.exit(1);
	}

	public static void vinculaDuplicatedId(String id, int row) {
		System.err
				.println("ERROR id duplicado '" + id + "' en la fila: " + row);
		System.exit(1);
	}

	public static void vinculaUndeclaredId(String id, int row) {
		System.err.println("ERROR id sin declarar '" + id + "' en la fila "
				+ row);
		System.exit(1);
	}
}