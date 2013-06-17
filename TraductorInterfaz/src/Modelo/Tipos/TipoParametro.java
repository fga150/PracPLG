package Modelo.Tipos;

public class TipoParametro implements Tipo{
	String tipo;
	String modo;
	int despl;
	Tipo tipoDelParam;
	String id;
	int tam;
	
	public TipoParametro(String modo, int despl, Tipo tipoDelParam, String id){
		tipo = "param";
		this.modo = modo;
		this.despl = despl;
		this.tipoDelParam = tipoDelParam;
		this.id = id;
		tam = tipoDelParam.getTam();
	}
	
	public String getId(){		
		return id;
	}
	
	public String getModo(){
		return modo;
	}
	
	public int getDespl(){
		return despl;
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
	
	public Tipo getTipoDelParam(){
		return tipoDelParam;
	}
	
}
