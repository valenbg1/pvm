package pvm.compiler;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
   public static void main(String[] args) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream("input.txt"));
	 LexicalAnalyzer alex = new LexicalAnalyzer(input);
	 SyntacticAnalyzer asint = new SyntacticAnalyzer(alex);
	 asint.parse();
 }
}   
   
