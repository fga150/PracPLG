package Modelo.plg.proto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import Controlador.Controlador;
import Modelo.es.ucm.fdi.plg.evlib.TAtributos;
import java_cup.runtime.*;


public class AnalizaSintactico {
  public  AnalizaSintactico(String input, String rutaSalida, Controlador c) throws Exception { 
	  
	  FileWriter fstream2 = new FileWriter("Auxiliar.plg");
	  BufferedWriter out2 = new BufferedWriter(fstream2);
	  out2.write(input);
	  out2.close();
  
 	  Parser p = new Parser(new Scanner(new FileInputStream("Auxiliar.plg")),new DefaultSymbolFactory(),c);
	     
	  Symbol s= null;
	  try {
		  s = p.parse();
		  String err = (String) ((TAtributos) s.value).a("err").valor();
		  String cod = (String) ((TAtributos) s.value).a("cod").valor();
		  if (!err.equals("")) c.imprimeError("Se han encontrado los siguientes errores de compilacion: \n\n" + err);  
		  else{
			FileWriter fstream = new FileWriter(rutaSalida);
		  	BufferedWriter out = new BufferedWriter(fstream);
		 
		  	out.write(cod);
		  	out.close();
		  	c.imprimeCodigoP();
		  }
	  } catch (Exception e){
		  return;
	  }
	  
	  
      	  
  }
}
