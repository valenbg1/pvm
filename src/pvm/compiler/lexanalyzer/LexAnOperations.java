package pvm.compiler.lexanalyzer;

import pvm.compiler.synanalyzer.LexicalClass;

public class LexAnOperations {
  private LexicalAnalyzer alex;
  public LexAnOperations(LexicalAnalyzer alex) {
   this.alex = alex;   
  }
  
  public LexicalUnit unidadNat() {
     return new LexicalUnit(alex.row(),LexicalClass.NUMERO_NATURAL,alex.lex()); 
  } 
  public LexicalUnit unidadReal() {
     return new LexicalUnit(alex.row(),LexicalClass.NUMERO_REAL,alex.lex()); 
  }
  public LexicalUnit unidadProgram() {
     return new LexicalUnit(alex.row(),LexicalClass.PROGRAM,alex.lex());     
  }  
  public LexicalUnit unidadTypes() {
     return new LexicalUnit(alex.row(),LexicalClass.TYPES,alex.lex());     
  }  
  public LexicalUnit unidadStruct() {
     return new LexicalUnit(alex.row(),LexicalClass.STRUCT,alex.lex());     
  }  
  public LexicalUnit unidadPointer() {
     return new LexicalUnit(alex.row(),LexicalClass.POINTER,alex.lex());     
  }  
  public LexicalUnit unidadArray() {
     return new LexicalUnit(alex.row(),LexicalClass.ARRAY,alex.lex());     
  }  
  public LexicalUnit unidadVariables() {
     return new LexicalUnit(alex.row(),LexicalClass.VARIABLES,alex.lex());     
  }  
  public LexicalUnit unidadSubprograms() {
     return new LexicalUnit(alex.row(),LexicalClass.SUBPROGRAMS,alex.lex());     
  }  
  public LexicalUnit unidadSubprogram() {
     return new LexicalUnit(alex.row(),LexicalClass.SUBPROGRAM,alex.lex());     
  }  
  public LexicalUnit unidadAnd() {
     return new LexicalUnit(alex.row(),LexicalClass.AND,alex.lex());     
  }  
  public LexicalUnit unidadOr() {
     return new LexicalUnit(alex.row(),LexicalClass.OR,alex.lex());     
  }  
  public LexicalUnit unidadNot() {
     return new LexicalUnit(alex.row(),LexicalClass.NOT,alex.lex());     
  }  
  public LexicalUnit unidadIf() {
     return new LexicalUnit(alex.row(),LexicalClass.IF,alex.lex());     
  }  
  public LexicalUnit unidadEndIf() {
     return new LexicalUnit(alex.row(),LexicalClass.ENDIF,alex.lex());     
  }  
  public LexicalUnit unidadDo() {
     return new LexicalUnit(alex.row(),LexicalClass.DO,alex.lex());     
  }  
  public LexicalUnit unidadEndDo() {
     return new LexicalUnit(alex.row(),LexicalClass.ENDDO,alex.lex());     
  }  
  public LexicalUnit unidadRead() {
     return new LexicalUnit(alex.row(),LexicalClass.READ,alex.lex());     
  }  
  public LexicalUnit unidadWrite() {
     return new LexicalUnit(alex.row(),LexicalClass.WRITE,alex.lex());     
  }  
  public LexicalUnit unidadNew() {
     return new LexicalUnit(alex.row(),LexicalClass.NEW,alex.lex());     
  }  
  public LexicalUnit unidadDelete() {
     return new LexicalUnit(alex.row(),LexicalClass.DELETE,alex.lex());     
  }  
  public LexicalUnit unidadToInt() {
     return new LexicalUnit(alex.row(),LexicalClass.TOINT,alex.lex());     
  }  
  public LexicalUnit unidadToDouble() {
     return new LexicalUnit(alex.row(),LexicalClass.TODOUBLE,alex.lex());     
  }  
  public LexicalUnit unidadId() {
     return new LexicalUnit(alex.row(),LexicalClass.ID,alex.lex());     
  }  
  public LexicalUnit unidadMas() {
     return new LexicalUnit(alex.row(),LexicalClass.MAS,alex.lex());     
  }  
  public LexicalUnit unidadMenos() {
     return new LexicalUnit(alex.row(),LexicalClass.MENOS,alex.lex());     
  }  
  public LexicalUnit unidadPor() {
     return new LexicalUnit(alex.row(),LexicalClass.POR,alex.lex());     
  }  
  public LexicalUnit unidadDiv() {
     return new LexicalUnit(alex.row(),LexicalClass.DIV,alex.lex());     
  }  
  public LexicalUnit unidadMod() {
     return new LexicalUnit(alex.row(),LexicalClass.MOD,alex.lex());     
  }  
  public LexicalUnit unidadAsig() {
     return new LexicalUnit(alex.row(),LexicalClass.ASIG,alex.lex());     
  }  
  public LexicalUnit unidadIgual() {
     return new LexicalUnit(alex.row(),LexicalClass.IGUAL,alex.lex());     
  }  
  public LexicalUnit unidadDistinto() {
     return new LexicalUnit(alex.row(),LexicalClass.DISTINTO,alex.lex());     
  }  
  public LexicalUnit unidadMenor() {
     return new LexicalUnit(alex.row(),LexicalClass.MENOR,alex.lex());     
  }  
  public LexicalUnit unidadMayor() {
     return new LexicalUnit(alex.row(),LexicalClass.MAYOR,alex.lex());     
  }  
  public LexicalUnit unidadMenorOIgual() {
     return new LexicalUnit(alex.row(),LexicalClass.MENOROIGUAL,alex.lex());     
  }  
  public LexicalUnit unidadMayorOIgual() {
     return new LexicalUnit(alex.row(),LexicalClass.MAYOROIGUAL,alex.lex());     
  }  
  public LexicalUnit unidadPAp() {
     return new LexicalUnit(alex.row(),LexicalClass.PAP,alex.lex());     
  }  
  public LexicalUnit unidadPCierre() {
     return new LexicalUnit(alex.row(),LexicalClass.PCIERRE,alex.lex());     
  }  
  public LexicalUnit unidadComa() {
     return new LexicalUnit(alex.row(),LexicalClass.COMA,alex.lex());     
  }  
  public LexicalUnit unidadPYComa() {
     return new LexicalUnit(alex.row(),LexicalClass.PYCOMA,alex.lex());     
  }  
  public LexicalUnit unidadDosPuntos() {
     return new LexicalUnit(alex.row(),LexicalClass.DOSPUNTOS,alex.lex());     
  }
  public LexicalUnit unidadLlaveAp() {
     return new LexicalUnit(alex.row(),LexicalClass.LLAVEAP,alex.lex());     
  }  
  public LexicalUnit unidadLlaveCierre() {
     return new LexicalUnit(alex.row(),LexicalClass.LLAVECIERRE,alex.lex());     
  }  
  public LexicalUnit unidadCAp() {
     return new LexicalUnit(alex.row(),LexicalClass.CAP,alex.lex());     
  }  
  public LexicalUnit unidadCCierre() {
     return new LexicalUnit(alex.row(),LexicalClass.CCIERRE,alex.lex());     
  }  
  public LexicalUnit unidadInt() {
     return new LexicalUnit(alex.row(),LexicalClass.INT,alex.lex());     
  }  
  public LexicalUnit unidadDouble() {
     return new LexicalUnit(alex.row(),LexicalClass.DOUBLE,alex.lex());     
  }  
  public LexicalUnit unidadBoolean() {
     return new LexicalUnit(alex.row(),LexicalClass.BOOLEAN,alex.lex());     
  }  
  public LexicalUnit unidadPunto() {
     return new LexicalUnit(alex.row(),LexicalClass.PUNTO,alex.lex());     
  }  
  public LexicalUnit unidadFlecha() {
     return new LexicalUnit(alex.row(),LexicalClass.FLECHA,alex.lex());     
  }  
  public LexicalUnit unidadAmp() {
     return new LexicalUnit(alex.row(),LexicalClass.AMP,alex.lex());     
  }
  public LexicalUnit unidadTrue() {
     return new LexicalUnit(alex.row(),LexicalClass.TRUE,alex.lex());     
  }
  public LexicalUnit unidadFalse() {
     return new LexicalUnit(alex.row(),LexicalClass.FALSE,alex.lex());     
  }
  public LexicalUnit unidadNull() {
     return new LexicalUnit(alex.row(),LexicalClass.NULL,alex.lex());     
  }
  public LexicalUnit unidadEof() {
     return new LexicalUnit(alex.row(),LexicalClass.EOF,"<EOF>"); 
  }
}
