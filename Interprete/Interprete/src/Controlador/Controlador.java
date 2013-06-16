package Controlador;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import Modelo.Motor;
import Vista.Ventana;

public class Controlador implements Observer{
	
	private Motor motor;
	private Ventana ventana;
	private boolean lecturaOn;

	public Controlador(){
		this.motor = new Motor();
		motor.addObserver(this);
		this.ventana = new Ventana(this);
		this.lecturaOn = false;
	}

	@Override
	public void update(Observable o, Object arg) {
			if (arg.equals(UpdateInfo.Inicio)){
				ventana.setContadorPrograma(motor.getContadorPrograma());
				ventana.setContadorPila(motor.getContadorPila());
				ventana.setRegistroSwap1(motor.getRegistroSwap1());
				ventana.setRegistroSwap2(motor.getRegistroSwap2());
				ventana.setEstado("EN ESPERA");
			}
			else if (arg.equals(UpdateInfo.VolcarEstado)){
				ventana.setMemoria(motor.getMemoria());
				String s = motor.getContadorPila();
				int count = Integer.parseInt(s);
				ventana.setPila(motor.getPila(),count);
				ventana.setContadorPrograma(motor.getContadorPrograma());
				ventana.setContadorPila(motor.getContadorPila());
				ventana.setRegistroSwap1(motor.getRegistroSwap1());
				ventana.setRegistroSwap2(motor.getRegistroSwap2());
				ventana.setEstado(motor.getRegisroParada());
			}
			else if(arg.equals(UpdateInfo.Out)){
				ventana.imprimeOut(motor.getPila()[Integer.parseInt(motor.getContadorPila())].toString());
			}
			else if(arg.equals(UpdateInfo.In)){
				lecturaOn = true;
				ventana.setEstado("EN ESPERA DE DATOS");
				ventana.imprimeIntro();
			}
	}

	public void enviarFichero(File file) {
		motor.iniciarMotor(file);
		ventana.imprimeFichero(file);
	}
	
	public void enviaLectura(String contenido) {
		try {
			contenido = contenido.substring(0, contenido.length()-1);
			motor.continuaIn(contenido);
		} catch (Exception e) {
			ventana.imprimeOut(e.getMessage());
			ventana.setEstado("PARADO");
		
		}
	}

	public void siguiente() {
		this.motor.setModoEjecutar(false);
		try {
			motor.ejecutar();
		} catch (Exception e) {
			ventana.imprimeOut(e.getMessage());
			ventana.setEstado("PARADO");
		}		
	}
	
	public void ejecutar(){
		this.motor.setModoEjecutar(true);
		try {
			motor.ejecutar();
		} catch (Exception e) {
			ventana.imprimeOut(e.getMessage());
			ventana.setEstado("PARADO");
		}		
	}
	
	public void reinciar() {
		motor.reiniciarMotor();
		ventana.setMemoria(motor.getMemoria());
		String s = motor.getContadorPila();
		int count = Integer.parseInt(s);
		ventana.setPila(motor.getPila(),count);
		ventana.reinciar();
	}

	public boolean isLecturaOn() {
		return lecturaOn;
	}

	public void setLecturaOn(boolean lecturaOn) {
		this.lecturaOn = lecturaOn;
	}

}
