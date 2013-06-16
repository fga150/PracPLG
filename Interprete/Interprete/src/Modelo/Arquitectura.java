package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Arquitectura{

	private final int tamMemoriaDatos = 1000;
	private final int tamPila = 100;
	
	private Motor motor;
	private int[] registroSwap;
	private int contadorPila;
	private int contadorPrograma;
	private int registroParada;
	private ArrayList<String> memoriaInstrucciones;
	private Object memoriaDatos[];
	private Object pila[];
	
	public Arquitectura(Motor motor){
		this.motor = motor;
		this.setMemoriaInstrucciones(new ArrayList<String>());
		this.memoriaDatos = new Object[tamMemoriaDatos];
		this.pila = new Object[tamPila];
		this.registroSwap = new int[3];
		this.iniciar();
	}
	
	public void siguiente() throws Exception{
		String linea = "";
		if (contadorPrograma<memoriaInstrucciones.size()) linea = memoriaInstrucciones.get(contadorPrograma);
		else linea = "stop";
		int returnValor = linea.indexOf('(');
		String instruccion = "";
		if (returnValor != -1) instruccion = linea.substring(0,returnValor);
		else instruccion = linea;
		Object d = null;
		int direccion = 0;
		switch (instruccion){
			case "apila" : d = getDato(returnValor,linea); apila(d); break;
			case "apila_dir": direccion = getDireccion(returnValor,linea); apila_dir(direccion); break;
			case "desapila_dir": direccion = getDireccion(returnValor,linea); desapila_dir(direccion); break;
			case "in": motor.setFlagLectura(true); motor.lee(); break;
			case "out": out(); break;
			case "swap1": swap1(); break;
			case "swap2": swap2(); break;
			case "suma": suma(); break;
			case "suma_swap": suma_swap(); break;
			case "resta": resta(); break;		
			case "resta_swap": resta_swap(); break;	
			case "multiplica": multiplica(); break;
			case "multiplica_swap": multiplica_swap(); break;
			case "divide": divide(); break;
			case "divide_swap": divide_swap(); break;
			case "modulo": modulo(); break;
			case "desplazamiento_Izq":	desplazamiento_izq(); break;		
			case "desplazamiento_Der":	desplazamiento_der(); break;		
			case "not": not(); break;
			case "and": and(); break;
			case "or": or(); break;
			case "mayorIgual": mayorIgual(); break;
			case "menorIgual": menorIgual(); break;
			case "igual": igual(); break;
			case "menor": menor(); break;
			case "mayor": mayor(); break;	
			case "distinto": distinto(); break;			
			case "cambioSigno": cambioSigno(); break;
			case "cast_float": castFloat(); break;
			case "cast_int": castInt(); break;
			case "cast_char": castChar(); break;
			case "cast_nat": castNat(); break;
			case "mueve" : int tam= getTam(returnValor,linea); mueve(tam); break;
			case "apila_ind" : apila_ind(); break;
			case "desapila_ind" : desapila_ind(); break;
			case "desapila" : desapila(); break;
			case "ir_f" : direccion = getDireccion(returnValor,linea);ir_f(direccion); break;
			case "ir_v" : direccion = getDireccion(returnValor,linea);ir_v(direccion); break;
			case "ir_a" : direccion = getDireccion(returnValor,linea);ir_a(direccion); break;
			case "ir_ind" : ir_ind(); break;
			case "copia" : copia(); break;
			case "stop": stop(); break;
			default : stop(); throw new Exception("Instruccion no válida. Line: "+contadorPrograma);
			}
	}
	
	
	

	

	/*private String getTipo(String linea) {
		int parent = linea.indexOf('(');
		int coma = linea.indexOf(',');
		String argumento = linea.substring(parent+1,coma);
		return argumento;
	}*/

	/*private int getDireccion2(String linea) {
		int parent = linea.indexOf(')');
		int coma = linea.indexOf(',');
		String argumento = linea.substring(coma+1,parent);
		int direccion =  Integer.parseInt(argumento);
		return direccion;
	}*/

	private int getDireccion(int returnValor, String linea) {
		int returnCierre = linea.indexOf(')');
		String argumento = linea.substring(returnValor+1,returnCierre);
		int direccion = Integer.parseInt(argumento);
		return direccion;
	}

	private Object getDato(int returnValor, String linea) {
		int returnCierre = linea.indexOf(')');
		String argumento = linea.substring(returnValor+1,returnCierre); 
		String tipo= clasificaDato(argumento);
		Object d = null;
		if (tipo.equals("Float")){
			 d= Float.parseFloat(argumento);
		}else if (tipo.equals("Bool")){
			d= Boolean.parseBoolean(argumento);
		}else if(tipo.equals("Character")){
			d= argumento.charAt(1);
		}
		return d;	
	}
	
	private int getTam(int returnValor,String linea) {
		int returnCierre = linea.indexOf(')');
		String argumento = linea.substring(returnValor+1,returnCierre); 
		return Integer.parseInt(argumento);	
	}

	private String clasificaDato(String argumento) {
		try{
			Float.parseFloat(argumento);
			return "Float";
		}catch (Exception e){
			try{
				if (argumento.length()==3) return "Character";
				Boolean.parseBoolean(argumento);
				return "Bool";
			}catch(Exception e1){
				return "";
			}
			
		}
	}

	public void cargarMemoriaInstrucciones(File fich){
		try {
			memoriaInstrucciones.clear();
			FileReader fr = new FileReader(fich);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line!=null){
				memoriaInstrucciones.add(line);
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void iniciar(){
		this.memoriaDatos = new Object[tamMemoriaDatos];
		this.pila = new Object[tamPila];
		this.registroSwap[1]=0;
		this.registroSwap[2]=0;
		this.contadorPila = -1;
		this.setContadorPrograma(0);
		this.setRegistroParada(0);
	}
	
	public void stop(){
		this.setRegistroParada(1);
	}
	private void mueve(int tam) throws Exception {
		if(contadorPila>=0){
			float dirOrigen = (float)pila[contadorPila];
			int origen= (int)dirOrigen;
			contadorPila--;
			float dirDestino = (float)pila[contadorPila];
			int destino = (int)dirDestino;
			contadorPila--;
			for(int i=0;i<tam;i++){
				memoriaDatos[destino]=memoriaDatos[origen];
				origen++;
				destino++;
			}
			contadorPrograma++;
		}
		else {
			stop();
			throw new Exception("Stack Overflow! Line: "+contadorPrograma);
		}
		
	}
	public void apila(Object dato) throws Exception{
		if (contadorPila+1 < tamPila){
				contadorPila++;
				pila[contadorPila] = dato;
				contadorPrograma++;
		}
		else {
			stop();
			throw new Exception("Stack Overflow! Line: "+contadorPrograma);
		}
	}

	private void apila_ind() throws Exception {
		if (contadorPila+1 < tamPila){
			float dir = (float)pila[contadorPila];
			pila[contadorPila]= memoriaDatos[(int)dir];
			contadorPrograma++;
		}
		else {
			stop();
			throw new Exception("Stack Overflow! Line: "+contadorPrograma);
		}
		
	}
	public void apila_dir(int direccion) throws Exception{

		if ((direccion>=0) || (contadorPila+1 < tamPila)){
			contadorPila++;
			pila[contadorPila] = memoriaDatos[direccion];
			contadorPrograma++;
		}
		else {
			stop();
			throw new Exception("Stack Overflow! Line: "+contadorPrograma);
		}
	}
	
	public void desapila_dir(int direccion) throws Exception{
		if ((contadorPila>=0) && (direccion>=0)){
			 memoriaDatos[direccion] = pila[contadorPila];
			contadorPila--;
			contadorPrograma++;
		}
		else{
				stop();
				throw new Exception("GestionError al desapilar: Pila vacía. Line: "+contadorPrograma);
			}
	}
	
	
	private void desapila_ind() throws Exception {
		if (contadorPila >=0){
			float dir = (float)pila[contadorPila-1];
			memoriaDatos[(int)dir] = pila[contadorPila];
			contadorPila-=2;
			contadorPrograma++;
		}
		else {
			stop();
			throw new Exception("Stack Overflow! Line: "+contadorPrograma);
		}
		
		
	}
	
	private void desapila() throws Exception {
		if(contadorPila >=0){
			contadorPila--;
		}else {
			stop();
			throw new Exception("Stack Overflow! Line: "+contadorPrograma);
		}
		contadorPrograma++;
	}

	
	public void in(String dato) throws Exception{
		if (contadorPila+1 < tamPila){
			contadorPila++;
			String tipo= clasificaDato(dato);
			if(tipo.equals("Float")) pila[contadorPila] = Float.parseFloat(dato);
			else if(tipo.equals("Boolean")) pila[contadorPila] = Boolean.parseBoolean(dato);
			else if(tipo.equals("Character")) pila[contadorPila] = dato.charAt(1);
			contadorPrograma++;
		}
		else {
			stop();
			throw new Exception("Stack Overflow! Line: "+contadorPrograma);
		}
	}
	
	public void out() throws Exception{
		if (contadorPila>=0){
			motor.imprime();
			contadorPila--;
			contadorPrograma++;
		}
		else{ 
			stop();
			throw new Exception("GestionError al imprimir por pantalla: Pila vacía. Line: "+contadorPrograma);
		}
	}
	
	public void swap1(){
		if (registroSwap[1]==0) registroSwap[1] = 1;
		else registroSwap[1]=0;
		contadorPrograma++;
		
	}
	
	public void swap2(){
		if (registroSwap[2]==0) registroSwap[2] = 1;
		else registroSwap[2]=0;
		contadorPrograma++;
	}
	public void suma() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];			
			Object dato2 = pila[contadorPila];
			 
			pila[contadorPila-1] = (float)dato1 +(float)dato2;
			contadorPila--;
			contadorPrograma++;
		}
		else{ 
			stop();
			throw new Exception("GestionError al sumar: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	public void suma_swap() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];			
			Object dato2 = pila[contadorPila];
			float temp = 0;
			if (registroSwap[1]==0) temp= (float)dato1 +(float)dato2 ;
			else temp= (float)dato1 -(float)dato2;
			pila[contadorPila-1] = temp;
			contadorPila--;
			contadorPrograma++;
		}
		else{ 
			stop();
			throw new Exception("GestionError al sumar: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	public void resta() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];			
			Object dato2 = pila[contadorPila];
			 
			pila[contadorPila-1] = (float)dato1 -(float)dato2;
			contadorPila--;
			contadorPrograma++;
		}
		else{ 
			stop();
			throw new Exception("GestionError al restar: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	public void resta_swap() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];
			Object dato2 = pila[contadorPila];
			float temp = 0;
			if (registroSwap[1]==0) temp= (float)dato1 -(float)dato2;
			else temp= (float)dato1 +(float)dato2 ;
			pila[contadorPila-1] = temp;
			contadorPila--;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al restar: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	public void multiplica() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];			
			Object dato2 = pila[contadorPila];
			 
			pila[contadorPila-1] = (float)dato1 *(float)dato2;
			contadorPila--;
			contadorPrograma++;
		}
		else{ 
			stop();
			throw new Exception("GestionError al sumar: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	public void multiplica_swap() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];
			Object dato2 = pila[contadorPila];
				float temp = 0;
				if ((registroSwap[2]==1) && ((float)dato2==0)){
					setRegistroParada(1);
					throw new Exception("GestionError de Division por 0 en la línea "+contadorPrograma);
				}
				else{
					if (registroSwap[2]==0) temp= (float)dato1 *(float)dato2;
					else temp= (float)dato1 /(float)dato2;
					pila[contadorPila-1] = temp;
					contadorPila--;
					contadorPrograma++;
				}
			}	
		else{
			stop();
			throw new Exception("GestionError al multiplicar: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	public void divide() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];			
			Object dato2 = pila[contadorPila];
			if ((float)dato2==0){
				setRegistroParada(1);
				throw new Exception("GestionError de Division por 0 en la línea "+contadorPrograma);
			}
			pila[contadorPila-1] = (float)dato1 /(float)dato2;
			contadorPila--;
			contadorPrograma++;
		}
		else{ 
			stop();
			throw new Exception("GestionError al dividir: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	public void divide_swap() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];
			Object dato2 = pila[contadorPila];
				float temp = 0;
				if ((registroSwap[2]==0) && ((float)dato2==0)){
					setRegistroParada(1);
					throw new Exception("GestionError de Division por 0 en la línea "+contadorPrograma);
				}
				else{
					if (registroSwap[2]==0) temp= (float)dato1 /(float)dato2;
					else temp= (float)dato1 *(float)dato2;
					pila[contadorPila-1] = temp;
					contadorPila--;
					contadorPrograma++;
				}
			}	
		else{
			stop();
			throw new Exception("GestionError al dividir: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
		
	
	
	public void modulo() throws Exception{
		if (contadorPila>=1){
			float dato1 = (float) pila[contadorPila-1];
			float dato2 = (float) pila[contadorPila];
			int temp = (int) dato1 % (int) dato2 ;
			pila[contadorPila-1] = temp;
			contadorPila--;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el modulo: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void desplazamiento_izq() throws Exception{
		if (contadorPila>=1){
			float dato1 = (float) pila[contadorPila-1];
			float dato2 = (float) pila[contadorPila];
			float temp = (int)dato1 << (int)dato2;
			pila[contadorPila-1] = temp;
			contadorPila--;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el desplazamiento: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void desplazamiento_der() throws Exception{
		if (contadorPila>=1){
			float dato1 = (float) pila[contadorPila-1];
			float dato2 = (float) pila[contadorPila];
			float temp = (int)dato1 >> (int)dato2;
			pila[contadorPila-1] = temp;
			contadorPila--;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el desplazamiento: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void not() throws Exception{
		if (contadorPila>=0){
			Object dato = pila[contadorPila];
			boolean bool = (boolean)dato;
			bool = !bool;
			pila[contadorPila] = bool;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar la negacion: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void and() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];
			Object dato2 = pila[contadorPila];
			boolean bool = (boolean)dato1 && (boolean)dato2;
			pila[contadorPila-1] = bool;
			contadorPila--;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el and: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void or() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];
			Object dato2 = pila[contadorPila];
			boolean bool = (boolean)dato1 || (boolean)dato2;
			pila[contadorPila-1] = bool;
			contadorPila--;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el or: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void mayorIgual() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];
			Object dato2 = pila[contadorPila];
			boolean bool = false;
			if ((dato1.getClass().toString().equals("class java.lang.Float"))&&(dato2.getClass().toString().equals("class java.lang.Float"))){
			bool = (float)dato1 >= (float)dato2;
			}else if ((dato1.getClass().toString().equals("class java.lang.Boolean"))&&(dato2.getClass().toString().equals("class java.lang.Boolean"))){
				if ((boolean) dato1)bool= true;			
				else{
					if (!((boolean) dato2)) bool=true;
				} 
				}
			pila[contadorPila-1] = bool;
			contadorPila--;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el mayor o igual: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void menorIgual() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];
			Object dato2 = pila[contadorPila];
			boolean bool = false;
			if ((dato1.getClass().toString().equals("class java.lang.Float"))&&(dato2.getClass().toString().equals("class java.lang.Float"))){
				bool = (float)dato1 <= (float)dato2;
			}else if ((dato1.getClass().toString().equals("class java.lang.Boolean"))&&(dato2.getClass().toString().equals("class java.lang.Boolean"))){
				if (!((boolean) dato1)) bool = true;			
				else{
					if ((boolean) dato2) bool=true;
				} 
			}
			pila[contadorPila-1] = bool;
			contadorPila--;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el menor o igual: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void igual() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];
			Object dato2 = pila[contadorPila];
			boolean bool = false;
			if ((dato1.getClass().toString().equals("class java.lang.Float"))&&(dato2.getClass().toString().equals("class java.lang.Float"))){
				bool = (float)dato1 == (float)dato2;
			}else if ((dato1.getClass().toString().equals("class java.lang.Boolean"))&&(dato2.getClass().toString().equals("class java.lang.Boolean"))){
				bool = ((boolean) dato1) == ((boolean) dato2);			
				
			}
			pila[contadorPila-1] = bool;
			contadorPila--;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el igual: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void menor() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];
			Object dato2 = pila[contadorPila];
			boolean bool = false;
			if ((dato1.getClass().toString().equals("class java.lang.Float"))&&(dato2.getClass().toString().equals("class java.lang.Float"))){
				bool = (float)dato1 < (float)dato2;
			}else if ((dato1.getClass().toString().equals("class java.lang.Boolean"))&&(dato2.getClass().toString().equals("class java.lang.Boolean"))){
				if ((!((boolean) dato1))&&((boolean) dato2)) bool = true;	
			}
			pila[contadorPila-1] = bool;
			contadorPila--;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el menor: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void mayor() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];
			Object dato2 = pila[contadorPila];
			boolean bool = false;
			if ((dato1.getClass().toString().equals("class java.lang.Float"))&&(dato2.getClass().toString().equals("class java.lang.Float"))){
				bool = (float)dato1 > (float)dato2;
			}else if ((dato1.getClass().toString().equals("class java.lang.Boolean"))&&(dato2.getClass().toString().equals("class java.lang.Boolean"))){
				if (((boolean) dato1)&&(!((boolean) dato2))) bool = true;	
			}
			pila[contadorPila-1] = bool;
			contadorPila--;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el mayor: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void distinto() throws Exception{
		if (contadorPila>=1){
			Object dato1 = pila[contadorPila-1];
			Object dato2 = pila[contadorPila];
			boolean bool = false;
			if ((dato1.getClass().toString().equals("class java.lang.Float"))&&(dato2.getClass().toString().equals("class java.lang.Float"))){
				bool = (float)dato1 != (float)dato2;
			}else if ((dato1.getClass().toString().equals("class java.lang.Boolean"))&&(dato2.getClass().toString().equals("class java.lang.Boolean"))){
				bool = ((boolean) dato1) != ((boolean) dato2);			
				
			}
			pila[contadorPila-1] = bool;
			contadorPila--;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el desplazamiento: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void cambioSigno() throws Exception{
		if (contadorPila>=0){
			Object dato = pila[contadorPila];
				float temp = (float) dato*-1;
				pila[contadorPila] = temp;
				contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el cambio de signo: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void castInt() throws Exception{
		if (contadorPila>=0){
			if ((pila[contadorPila].getClass().toString().equals("class java.lang.Float"))){
				float dato = (float) pila[contadorPila];
				pila[contadorPila] = (float) ((int)dato);				
			}else if(pila[contadorPila].getClass().toString().equals("class java.lang.Character")){  
				char dato = (char) pila[contadorPila];
				pila[contadorPila] = (float) ((int)dato);
			}
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el casting a integer: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void castFloat() throws Exception{
		if (contadorPila>=0){
			float temp = 0;
			if (pila[contadorPila].getClass().toString().equals("class java.lang.Character")){
				char dato = (char)pila[contadorPila];
				temp = (float)dato;
			}
			pila[contadorPila] = temp;
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el casting a float: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void castChar() throws Exception{
		if (contadorPila>=0){
			if ((pila[contadorPila].getClass().toString().equals("class java.lang.Float"))){ 
				float dato = (float) pila[contadorPila];
				pila[contadorPila] = (char) dato;
			}
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el casting a character: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	
	public void castNat() throws Exception{
		if (contadorPila>=0){
			
			if ((pila[contadorPila].getClass().toString().equals("class java.lang.Character"))){ 
				char dato = (char) pila[contadorPila];
			    pila[contadorPila] = (float)dato;
			}
			contadorPrograma++;
		}
		else{
			stop();
			throw new Exception("GestionError al aplicar el casting a natural: No hay suficientes datos en la pila. Line: "+contadorPrograma);
		}
	}
	private void ir_f(int direccion) throws Exception {
		
		if((contadorPila>=0)&&(direccion>=0)){
			if(!((boolean)pila[contadorPila])){
				contadorPrograma=direccion;
			}else contadorPrograma++;
			contadorPila--;
		}else{
			stop();
			throw new Exception("No hay dato en la pila Line: "+contadorPrograma);
		}
	}
	
	private void ir_v(int direccion) throws Exception {
		if((contadorPila>=0)&&(direccion>=0)){
			if((boolean)pila[contadorPila]){
				contadorPrograma=direccion;
			}else contadorPrograma++;
			contadorPila--;
		}else{
			stop();
			throw new Exception("No hay dato en la pila Line: "+contadorPrograma);
		}
	}
	private void ir_a(int direccion) throws Exception {
		if(direccion>=0){
			contadorPrograma=direccion;
		}else{
			stop();
			throw new Exception("No hay dato en la pila Line: "+contadorPrograma);
		}
		
		
	}
	private void copia() throws Exception {
		if((contadorPila>=0)&&(contadorPila+1<tamPila)){
			pila[contadorPila+1]=pila[contadorPila];
			contadorPila++;
			contadorPrograma++;
		}else{
			stop();
			throw new Exception("No hay dato en la pila Line: "+contadorPrograma);
		}
		
		
	}
	private void ir_ind() throws Exception {
		float cimaPila=(float) pila[contadorPila];
		if(cimaPila>=0){
			contadorPrograma=(int) cimaPila;
			contadorPila--;
		}else{
			stop();
			throw new Exception("Direccion negativa Line: "+contadorPrograma);
		}
		
	}
	/*public boolean compatiblesAsign(String tipo1, String tipo2) {
		  if (/*tipo1.equals("terror") ||*//* tipo2.equals("terror")) return false;
		  else if (tipo1.equals(tipo2)) return true;
		  else if (tipo1.equals("integer") && (tipo2.equals("natural"))) return true;
		  else if (tipo1.equals("float") && 
		    (tipo2.equals("integer") || tipo2.equals("natural"))) return true;
		  else return false;
		 }*/
	
	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Object[] getMemoriaDatos() {
		return memoriaDatos;
	}

	public void setMemoriaDatos(Object[] memoriaDatos) {
		this.memoriaDatos = memoriaDatos;
	}

	public Object[] getPila() {
		return pila;
	}

	public void setPila(Object[] pila) {
		this.pila = pila;
	}

	public int getRegistroSwap1() {
		return registroSwap[1];
	}
	
	public void setRegistroSwap1(int numero) {
		this.registroSwap[1] = numero;
	}
	
	public int getRegistroSwap2() {
		return registroSwap[2];
	}
	
	public void setRegistroSwap2(int numero) {
		this.registroSwap[2] = numero;
	}
	
	public int getContadorPrograma() {
		return contadorPrograma;
	}

	public void setContadorPrograma(int contadorPrograma) {
		this.contadorPrograma = contadorPrograma;
	}

	public int getRegistroParada() {
		return registroParada;
	}

	public void setRegistroParada(int registroParada) {
		this.registroParada = registroParada;
	}
	
	public int getContadorPila() {
		return contadorPila;
	}

	public void setContadorPila(int contadorPila) {
		this.contadorPila = contadorPila;
	}

	public ArrayList<String> getMemoriaInstrucciones() {
		return memoriaInstrucciones;
	}

	public void setMemoriaInstrucciones(ArrayList<String> memoriaInstrucciones) {
		this.memoriaInstrucciones = memoriaInstrucciones;
	}

}

