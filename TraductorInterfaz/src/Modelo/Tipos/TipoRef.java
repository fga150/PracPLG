package Modelo.Tipos;
public class TipoRef implements Tipo{
	String tipo;
	String id;
	int tam;
	
	public TipoRef(String id, int tam){
		tipo = "ref";
		this.id = id;
		this.tam = tam;
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
