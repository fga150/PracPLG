package Controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import Modelo.plg.proto.AnalizaSintactico;
import Vista.Ventana;

public class Controlador{
	
	private Ventana ventana;
	private String rutaSalida;
	private String rutaEntrada;
	private String name;
	AnalizaSintactico analizador;
	
	public Controlador(){
		this.ventana = new Ventana(this);
	}

	public String getRutaCodigoFuente() {
		return rutaSalida;
	}

	public void setRutaCodigoFuente(String rutaCodigoFuente) {
		this.rutaSalida = rutaCodigoFuente;
	}

	public void enviaRuta(File file) {
	
		String aux = file.getName();
		name = aux.substring(0, aux.indexOf("."));
		
		rutaEntrada = file.getParent();
		rutaSalida = rutaEntrada +"\\"+name+".plg";
		ventana.imprimeFichero(file);
		
		
	}

	public void compila(String text) {
		if(rutaSalida!=null){
			try {
				analizador = new AnalizaSintactico(text,rutaSalida,this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			analizador = null;
		}
		
	}

	public void imprimeCodigoP() {
		File file = new File(rutaSalida);
		ventana.imprimeCodigoP(file);
		
	}

	public void imprimeConsola(String string) {
		ventana.imprimeConsola(string);
		
	}

	public void imprimeError(String imprimeErrores) {
		ventana.imprimeError(imprimeErrores);
		
	}
	
	public void guardaFuente(String text){
		try {
			PrintWriter file = new PrintWriter(new FileWriter(rutaEntrada+"\\"+name+".txt"));
			file.println(text);
			file.flush();
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
