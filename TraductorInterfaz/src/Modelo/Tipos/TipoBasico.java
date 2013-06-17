package Modelo.Tipos;
public class TipoBasico implements Tipo {
		String tipo;
		int tam;
		
		public TipoBasico(String tipo){
			this.tipo = tipo;
			this.tam = 1;
		}
		
		public String getTipo() {
			return tipo;
		}
		
		@Override
		public int getTam() {
			return tam;
		}

		@SuppressWarnings("unused")
		public boolean esCompatibleAsign(String valor) {
			if (tipo == "integer"){
				try {
					int a = Integer.parseInt(valor);
					return true;
				} catch (Exception e) {
					return false;
				}
			} else if (tipo == "natural"){
				try {
					int a = Integer.parseInt(valor);
					return a >= 0;
				} catch (Exception e) {
					return false;
				}
			} else if (tipo == "character") {
				return valor.length() == 3;
			} else if (tipo == "boolean"){
				return valor.equals("true") || valor.equals("false");
			} else if (tipo == "float"){
				try {
					float a = Float.parseFloat(valor);
					return true;
				} catch (Exception e) {
					return false;
				}
			} else return false;
		}

		@Override
		public boolean esConstante() {
			return false;
		}
	}
