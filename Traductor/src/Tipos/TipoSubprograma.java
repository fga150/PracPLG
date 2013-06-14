package Tipos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class TipoSubprograma implements Tipo{
	String tipo;
	HashMap<String, TipoParametro> params;
	int dirComienzo;
	int tam;
	
	public TipoSubprograma(Vector<TipoParametro> params, int dirComienzo){
		tipo = "proc";
		tam = 0;
		
		this.params = new HashMap<String, TipoParametro>();
		Iterator<TipoParametro> it = params.iterator();
		while (it.hasNext()){
			TipoParametro p = it.next();
			this.params.put(p.getId(), p);
			tam = tam + p.getTam();
		}
		
		this.dirComienzo = dirComienzo;
	}
	
	public int getDirComienzo(){
		return dirComienzo;
	}
	
	public boolean esModoPvar(String idVar){
		if (!params.containsKey(idVar)) return false;
		else return params.get(idVar).getModo() == "pvar";
	}
	
	public int getDespl(String idVar){
		if (!params.containsKey(idVar)) return -1;
		else return params.get(idVar).getDespl();
	}
	
	public int getTam(String idVar){
		if (!params.containsKey(idVar)) return -1;
		else return params.get(idVar).getTam();
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

	public int getNumParams() {
		return params.size();
	}

	public boolean existeParametro(String idVar) {
		return params.containsKey(idVar);
	}
	
	public Tipo getTipo(String idVar){
		if (!params.containsKey(idVar)) return new TipoError("terror");
		else return params.get(idVar).getTipoDelParam();
	}

}
