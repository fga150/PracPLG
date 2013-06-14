package Tipos;

public class TipoConstante implements Tipo{
	String tipo;
	String valor;
	int tam;
	
	public TipoConstante(String tipo, String valor){
		this.tipo = tipo;
		this.valor = valor;
		tam = 1;
	}

	@Override
	public int getTam() {
		return tam;
	}
	
	public String getValor() {
		return valor;
	}

	@Override
	public String getTipo() {
		return tipo;
	}

	@Override
	public boolean esConstante() {
		return true;
	}
}
