package Modelo.Tipos;

public class TipoError implements Tipo {
	String tipo;
	
	public TipoError(String tipo){
		this.tipo = tipo;
	}

	@Override
	public int getTam() {
		return 0;
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
