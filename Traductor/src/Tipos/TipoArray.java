package Tipos;
public class TipoArray implements Tipo {
	String tipo;
	int nElem;
	Tipo tipoBase;
	int tam;
	
	public TipoArray(int nElem, Tipo tipoBase){
		tipo = "array";
		this.nElem = nElem;
		this.tipoBase = tipoBase;
		//FIXME
		this.tam = nElem*tipoBase.getTam(); 
	}

	public Tipo getTipoBase() {
		return tipoBase;
	}
	
	public int getNElem() {
		return nElem;
	}
	
	@Override
	public int getTam() {
		return tam;
	}

	@Override
	public String getTipo() {
		return tipo;
	}

	@Override
	public boolean esConstante() {
		return false;
	}

}
