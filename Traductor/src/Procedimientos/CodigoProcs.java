package Procedimientos;

public class CodigoProcs {
	
	public String codigoPrologo(int tamDatos){
		String cod = "";
		
		cod += "apila_dir(0)\n";
		cod += "apila(2)\n";
		cod += "suma\n";
		cod += "apila_dir(1)\n";
		cod += "desapila_ind\n";
		cod += "apila_dir(0)\n";
		cod += "apila(3)\n";
		cod += "suma\n";
		cod += "desapila_dir(1)\n";
		cod += "apila(" + Integer.toString(tamDatos) + ")\n";
		cod += "apila(2)\n";
		cod += "suma\n";
		cod += "apila_dir(0)\n";
		cod += "suma\n";
		cod += "desapila_dir(0)\n";
		
		return cod;
	}
	
	public String codigoEpilogo(int tamDatos){
		String cod = "";
		
		cod += "apila_dir(0)\n";
		cod += "apila(" + Integer.toString(tamDatos) + ")\n";
		cod += "apila(2)\n";
		cod += "suma\n";
		cod += "resta\n";
		cod += "desapila_dir(0)\n";
		cod += "apila_dir(0)\n";
		cod += "apila(2)\n";
		cod += "suma\n";
		cod += "apila_ind\n";
		cod += "desapila_dir(1)\n";
		cod += "apila_dir(0)\n";
		cod += "apila(1)\n";
		cod += "suma\n";
		cod += "apila_ind\n";
		cod += "ir_ind\n";		
		
		return cod;
	}
	
	public String guardaRetorno(int dirRetorno){
		String cod = "";
		
		cod += "apila_dir(0)\n";
		cod += "apila(1)\n";
		cod += "suma\n";
		cod += "apila(" + Integer.toString(dirRetorno) + ")\n";
		cod += "desapila_ind\n";
		
		return cod;
	}
		
	public String codInicio(int tamDatos){
		String cod = "";
		cod += "apila(" + Integer.toString(tamDatos) + ")\n";
		cod += "apila(1)\n";
		cod += "suma\n";
		cod += "desapila_dir(0)\n";
		cod += "apila(0)\n";
		cod += "desapila_dir(1)\n";
		return cod;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
}
