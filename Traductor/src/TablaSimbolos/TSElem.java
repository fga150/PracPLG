package TablaSimbolos;

import Tipos.*;

public class TSElem {
	String clase;
	int dir;
	Tipo tipo;
	
	public TSElem(String clase, int dir, Tipo tipo){
		this.clase = clase;
		this.dir = dir;
		this.tipo = tipo;
	}

	public String getClase() {
		return clase;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public int getDir() {
		return dir;
	}
	
}
