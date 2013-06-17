package Modelo.Tipos;
import java.util.Vector;


public class TipoTupla implements Tipo {
	String tipo;
	int nElem;
	Vector<TipoElemTupla> campos;
	int tam;
	
	public TipoTupla(){
		tipo = "tup";
		nElem = 0;
		campos = new Vector<TipoElemTupla>();
		tam = 0;
	}
	
	public TipoTupla(Tipo tipoElem){
		tipo = "tup";
		nElem = 0;
		campos = new Vector<TipoElemTupla>();
		tam = 0;
		anyadeElemTupla(tipoElem);
	}
	
	public void anyadeElemTupla(Tipo tipoElem){
		if (campos.size() > 0) {
			int newId = campos.size();
			TipoElemTupla last = campos.lastElement();
			int despl = last.getDespl() + last.getTam();
			TipoElemTupla elem = new TipoElemTupla(newId, tipoElem, despl);
			campos.add(elem);
		} else {
			TipoElemTupla elem = new TipoElemTupla(0, tipoElem, 0);
			campos.add(elem);
		}
		nElem++;
		tam = tam + tipoElem.getTam();
	}
	
	public TipoElemTupla getTipoElemTupla(int n){
		return campos.get(n);
	}

	public Vector<TipoElemTupla> getCampos() {
		return campos;
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
