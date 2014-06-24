package pvm.compiler;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import pvm.compiler.abstractsyntax.Programa;
import pvm.compiler.lexanalyzer.LexicalAnalyzer;
import pvm.compiler.synanalyzer.SyntacticAnalyzer;

public class Main {
	public static void main(String[] args) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream(
				"EjemploPractica4.txt"));
		LexicalAnalyzer alex = new LexicalAnalyzer(input);
		SyntacticAnalyzer asint = new SyntacticAnalyzer(alex);
		Programa programa = (Programa) asint.parse().value;

		System.out.println(programa);
		
		Vinculator vinculator = new Vinculator();
		vinculator.vincula(programa);
	}
}
