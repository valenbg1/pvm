package pvm.compiler;

import pvm.compiler.lexanalyzer.LexicalUnit;

public class ErrorsHandler {
   public void lexicalError(int row, String lex) {
     System.out.println("ERROR fila "+row+": Caracter inexperado: "+lex); 
     System.exit(1);
   }  
   public void syntacticError(LexicalUnit lexicalUnit) {
     System.out.println("ERROR fila "+lexicalUnit.row()+": Elemento inexperado "+lexicalUnit.value+" ("+lexicalUnit.sym+")");
     System.exit(1);
   }
}
