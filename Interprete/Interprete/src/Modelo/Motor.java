package Modelo;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import Controlador.UpdateInfo;

public class Motor extends Observable {

	private Observer controlador;
	private Arquitectura arquitectura;
	private File archivo;
	private boolean modoEjecutar;
	private boolean flagLectura;
	private String valorLectura;
	
	
	public Motor(){
		this.arquitectura = new Arquitectura(this);
	}
	
	public void ejecutar() throws Exception{			
		do{
			if (!flagLectura && (arquitectura.getRegistroParada()!=1)){
				arquitectura.siguiente();
				if (!flagLectura) notifyObservers(UpdateInfo.VolcarEstado);
			}
		}
		while ((!flagLectura) && (arquitectura.getRegistroParada()!=1) && (modoEjecutar));
	}
	
	public void iniciarMotor(File archivo){
		this.arquitectura.cargarMemoriaInstrucciones(archivo);
		this.arquitectura.iniciar();
		this.notifyObservers(UpdateInfo.Inicio);
	}
	
	public void reiniciarMotor(){
		this.arquitectura.iniciar();
		this.flagLectura = false;
		this.notifyObservers(UpdateInfo.Inicio);
	}

	public void addObserver(Observer o){
		this.controlador = o;
	}
	
	public void	notifyObservers(Object arg){
		controlador.update(this, arg);
	}

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	public String getContadorPrograma() {
		return Integer.toString(arquitectura.getContadorPrograma());
	}
	
	public String getContadorPila() {
		return Integer.toString(arquitectura.getContadorPila());
	}
	
	public String getRegisroParada() {
		if (arquitectura.getRegistroParada() == 0) return "EJECUTANDO";
		else return "PARADO";
	}
	
	public String getRegistroSwap1() {
		return Integer.toString(arquitectura.getRegistroSwap1());
	}
	
	public String getRegistroSwap2() {
		return Integer.toString(arquitectura.getRegistroSwap2());
	}

	public  Object[] getMemoria() {
		return arquitectura.getMemoriaDatos();
	}

	public  Object[] getPila() {
		return arquitectura.getPila();
	}
	
	public void lee() {
		notifyObservers(UpdateInfo.In);		
	}

	public void imprime() {
		notifyObservers(UpdateInfo.Out);		
	}

	public void continuaIn(String valor) throws Exception {
		flagLectura = false;
		arquitectura.in(valor);
		this.ejecutar();
	}

	public String getValorLectura() {
		return valorLectura;
	}

	public void setValorLectura(String valorLectura) {
		this.valorLectura = valorLectura;
	}

	public boolean isFlagLectura() {
		return flagLectura;
	}

	public void setFlagLectura(boolean flagLectura) {
		this.flagLectura = flagLectura;
	}

	public boolean isModoEjecutar() {
		return modoEjecutar;
	}

	public void setModoEjecutar(boolean modoEjecutar) {
		this.modoEjecutar = modoEjecutar;
	}
}
