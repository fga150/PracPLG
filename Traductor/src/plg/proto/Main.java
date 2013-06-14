package plg.proto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import es.ucm.fdi.plg.evlib.TAtributos;
import java_cup.runtime.*;


public class Main {
  public static void main(String[] args) throws Exception {   
  //    Parser p = new Parser(new Scanner(new FileInputStream("C:/Users/Beatriz/Documents/Uni/CUARTO/IS/WorkspaceBueno/PlgTipos/src/plg/proto/input.txt")),new DefaultSymbolFactory());
	  parser p = new parser(new Scanner(new FileInputStream("src/plg/proto/input2.txt")),new DefaultSymbolFactory());
	     
	  Symbol s= p.parse();
     
	  String err = (String) ((TAtributos) s.value).a("err").valor();
	  String cod = (String) ((TAtributos) s.value).a("cod").valor();
	  
	  if (err.equals("")) System.out.println(cod);
	  else System.out.println(err);  
	  
	  FileWriter fstream = new FileWriter("../../Output.plg");
	  BufferedWriter out = new BufferedWriter(fstream);
	  
	  /*String[] lines = cod.split(System.getProperty("line.separator"));
	  for (int i=0;i<lines.length;i++) out.write(lines[i]);*/
	  out.write(cod);
	  out.close();
      	  
  }
}
