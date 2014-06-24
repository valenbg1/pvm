package pvm.compiler;

import pvm.compiler.lexanalyzer.LexicalUnit;

public class ErrorsHandler {
   public static void lexicalError(int row, String lex) {
     System.err.println("ERROR fila "+row+": Caracter inexperado: "+lex); 
     System.exit(1);
   }  
   public static void syntacticError(LexicalUnit lexicalUnit) {
     System.err.println("ERROR fila "+lexicalUnit.row()+": Elemento inexperado "+lexicalUnit.value+" ("+lexicalUnit.sym+")");
     System.exit(1);
   }
   
   public static void vinculaUndeclaredId(String id, int row) {
     System.err.println("ERROR id sin declarar " + id + " en fila: " + row);
     System.exit(1);
   }
   
   public static void vinculaDuplicatedId(String id, int row) {
     System.err.println("ERROR id duplicado " + id + " en fila: " + row);
     System.exit(1);
   }
   
   public static void vinculaDuplicatedField(String field, int row) {
     System.err.println("ERROR campo duplicado " + field + " en fila: " + row);
     System.exit(1);
   }
}
