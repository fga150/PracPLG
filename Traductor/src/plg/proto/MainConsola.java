package plg.proto;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java_cup.runtime.DefaultSymbolFactory;
import java_cup.runtime.Symbol;
import es.ucm.fdi.plg.evlib.TAtributos;

public class MainConsola {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Tienes que meter el fichero del programa fuente y el fichero donde se generara el codigo destino.");
			return;
		}
		
		String fuente = args[0];
		String destino = args[1];
		
		parser p;
		try {
			p = new parser(new Scanner(new FileInputStream(fuente)),new DefaultSymbolFactory());
		} catch (FileNotFoundException e) {
			System.out.println("Se ha metido incorrectamente la direccion del fichero del programa fuente.");
			return;
		}
	     
		Symbol s = null;
		try {
			s = p.parse();
			String err = (String) ((TAtributos) s.value).a("err").valor();
			String cod = (String) ((TAtributos) s.value).a("cod").valor();
			  
			if (!err.equals("")) System.out.println("Se han encontrado los siguientes errores de compilacion: \n\n" + err);
			else {
				FileWriter fstream;
				try {
					fstream = new FileWriter(destino);
					BufferedWriter out = new BufferedWriter(fstream);
					  
					out.write(cod);
					out.close();
				} catch (IOException e) {
					System.out.println("Ha habido un error al escribir el programa destino en fichero.");
					return;
				}
			}
		} catch (Exception e) {
			return;
		}
	     
		
	}

}
