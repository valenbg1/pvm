package pvm.compiler.lexanalyzer;

import java_cup.runtime.Symbol;

public class LexicalUnit extends Symbol {
   private int row;
   public LexicalUnit(int row, int lclass, String lex) {
     super(lclass,lex);
	 this.row = row;
   }
   public int lclass() {return sym;}
   public String lex() {return (String)value;}
   public int row() {return row;}
}
