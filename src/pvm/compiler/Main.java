package pvm.compiler;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import pvm.compiler.abstractsyntax.Programa;
import pvm.compiler.lexanalyzer.LexicalAnalyzer;
import pvm.compiler.synanalyzer.SyntacticAnalyzer;
import pvm.vm.PMachine;
import pvm.vm.instructions.Instruction;

public class Main {
	public static void main(String[] args) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream(
				"ejemplo-factorial.txt"));
		LexicalAnalyzer alex = new LexicalAnalyzer(input);
		SyntacticAnalyzer asint = new SyntacticAnalyzer(alex);
		Programa programa = (Programa) asint.parse().value;

		System.out.println(programa);
		
		programa.vincula();
		programa.chequea();
		programa.asignaEspacio();

		programa.codigo();
		ArrayList<Instruction> code = programa.getCod();
		System.out.println("\n\nCODE:\n--------------------------------\n\n");
		int i = 0;
		for(Instruction ist : code)
			System.out.println("["+(i++)+"]: "+ist);
		
		PMachine pvm = new PMachine(code);
		pvm.run();
	}
}
