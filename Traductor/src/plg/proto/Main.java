package plg.proto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import es.ucm.fdi.plg.evlib.TAtributos;
import java_cup.runtime.*;


public class Main {
  public static void main(String[] args) throws Exception {   
 	  Parser p = new Parser(new Scanner(new FileInputStream("src/plg/proto/input2.txt")),new DefaultSymbolFactory());
	     
	  Symbol s= null;
	  try {
		  s = p.parse();
		  String err = (String) ((TAtributos) s.value).a("err").valor();
		  String cod = (String) ((TAtributos) s.value).a("cod").valor();
		  if (err.equals("")) System.out.println("El codigo resultante es: \n\n" + cod);
		  else System.out.println("Se han encontrado los siguientes errores de compilacion: \n\n" + err);  
		  
		  FileWriter fstream = new FileWriter("../../Output.plg");
		  BufferedWriter out = new BufferedWriter(fstream);
		  
		  /*String[] lines = cod.split(System.getProperty("line.separator"));
		  for (int i=0;i<lines.length;i++) out.write(lines[i]);*/
		  out.write(cod);
		  out.close();
	  } catch (Exception e){
		  return;
	  }
	  
	  
      	  
  }
}
