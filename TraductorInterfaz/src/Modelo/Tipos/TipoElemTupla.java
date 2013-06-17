package Modelo.Tipos;

public class TipoElemTupla implements Tipo {
	String tipo;
	int id;
	Tipo tipoElem;
	int despl;
	
	public TipoElemTupla(int id, Tipo tipoElem, int despl){
		this.tipo = "elemTupla";
		this.id = id;
		this.tipoElem = tipoElem;
		this.despl = despl;
	}
	
	public Tipo getTipoElem(){
		return tipoElem;
	}
	
	public int getDespl(){
		return despl;
	}
	
	@Override
	public int getTam() {
		return tipoElem.getTam();
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
