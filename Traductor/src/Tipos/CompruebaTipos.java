package Tipos;

import java.util.Vector;

public class CompruebaTipos {
	
	public Tipo defineTipoNivel4(Tipo t, String op){
		if (t == null) return new TipoError("terrorRec");  
		String tipo = t.getTipo();
		     
		  if (tipo.equals("terror") || t.getTipo().equals("terrorRec")) return new TipoError("terrorRec");
		  else if (tipo.equals("elemTupla")) return defineTipoNivel4(((TipoElemTupla) t).getTipoElem(), op);
		  else if (tipo.equals("array") || tipo.equals("tup")) return new TipoError("terror");
		  else if (tipo.equals("boolean") && op.equals("not")) return new TipoBasico("boolean");
		  else {
			  if (op.equals("(int)")) return new TipoBasico("integer");
			  else if (op.equals("(nat)") && (tipo.equals("natural") || tipo.equals("character"))) return new TipoBasico("natural");
			  else if (op.equals("(float)")) return new TipoBasico("float");
			  else if (op.equals("(char)") && (tipo.equals("natural") || tipo.equals("character"))) return new TipoBasico("character");
			  else return new TipoError("terror");
		  }
		 }

	public Tipo defineTipo(Tipo t1, Tipo t2, String operacion) {
		if (t1 == null || t2 == null) return new TipoError("terrorRec");
		String tipo = "terror";
		String tipo1 = t1.getTipo();
		String tipo2 = t2.getTipo();
		if (tipo1.equals("terror") || tipo1.equals("terrorRec") || tipo2.equals("terror") || tipo2.equals("terrorRec"))
			return new TipoError("terrorRec");
		else if (tipo1.equals("array") || tipo1.equals("tup") || tipo2.equals("array") || tipo2.equals("tup")) return new TipoError("terror");
		else if (tipo1.equals("elemTupla")) return defineTipo(((TipoElemTupla)t1).getTipoElem(), t2, operacion);
		else if (tipo2.equals("elemTupla")) return defineTipo(t1, ((TipoElemTupla)t2).getTipoElem(), operacion);
		
		// Comprobar opnivel0   
		  if (operadorBooleano(operacion)){
		   if (tipo1.equals("natural")){
		    if (tipo2.equals("natural")|| tipo2.equals("integer") ||tipo2.equals("float")) tipo = "boolean";
		    else tipo = "terror";
		   } else if (tipo1.equals("integer")){ 
		    if (tipo2.equals("float") || tipo2.equals("integer")) tipo = "boolean";
		    else if (tipo2.equals("natural")) tipo = "boolean";
		   } else if (tipo1.equals("float")){
		    if (esNumero(tipo2)) tipo = "boolean";
		    else tipo = "terror"; 
		   } else if (tipo1.equals("boolean")){   
		    if (tipo2.equals("boolean")) tipo = "boolean";
		    else tipo = "terror"; 
		   } else if (tipo1.equals("character")){   
		    if (tipo2.equals("character")) tipo = "boolean";
		    else tipo = "terror"; 
		   } else tipo = "terror";
		   
		  // Comprobar operadores +,-,*,/
		  } else if (operadorAritmetico(operacion)){
			if (esNumero(tipo1) && esNumero(tipo2)){ 
				if (tipo1.equals("float")||tipo2.equals("float")) tipo = "float";
				else if (tipo1.equals("integer")||tipo2.equals("integer")) tipo = "integer";
				else if (tipo1.equals("natural")||tipo2.equals("natural")) tipo = "natural";
			} else tipo = "terror";

		//Comprobar operadores 
		} else if (operadorLógico(operacion)){
			if (tipo1.equals("boolean")&& tipo2.equals("boolean")) tipo = "boolean";
			else tipo = "terror";
		} else if (operacion.equals("%")){
			if ((tipo1.equals("natural")||tipo1.equals("integer")) && tipo2.equals("natural")) tipo = "natural";
			else tipo = "terror";
		} else if (operacion.equals("<<") || operacion.equals(">>")){
			if (tipo1.equals("natural")&& tipo2.equals("natural")) tipo = "natural";
			else tipo = "terror";
		}
		return new TipoBasico(tipo);
	}
	
	private boolean operadorLógico(String operacion) {
		return (operacion.equals("and")||operacion.equals("or"));
	}

	private boolean esNumero(String tipo){
		return (tipo.equals("natural")||tipo.equals("integer")||tipo.equals("float"));
	}
	private boolean operadorAritmetico(String operacion) {
		
		return (operacion.equals("+")||operacion.equals("-")||operacion.equals("*")
				||operacion.equals("/"));
	}

	private boolean operadorBooleano(String operacion) {
		return (operacion.equals("<")||operacion.equals(">")||operacion.equals(">=")
	   ||operacion.equals("<=")||operacion.equals("==")||operacion.equals("!="));
	}
	
	public Tipo defineTipoAsign(Tipo tipo1, Tipo tipo2) {
		if (tipo1 == null || tipo2 == null) return new TipoError("terrorRec");
		if (compatiblesAsign(tipo1, tipo2)) return tipo1;
		else return new TipoError("terror");
	}

	public boolean compatiblesAsign(Tipo t1, Tipo t2) {
		String tipo1 = t1.getTipo();
		String tipo2 = t2.getTipo();
		if (tipo1.equals("terror") || tipo2.equals("terror") || tipo1.equals("terrorRec") || tipo2.equals("terrorRec")) return false;
		else if (tipo1.equals("elemTupla")) return compatiblesAsign(((TipoElemTupla)t1).getTipoElem(), t2);
		else if (tipo2.equals("elemTupla")) return compatiblesAsign(t1, ((TipoElemTupla)t2).getTipoElem());
		else if (tipo1.equals("array")) {
			if (!tipo2.equals("array")) return false;
			if (((TipoArray)t1).getNElem() != ((TipoArray)t2).getNElem()) return false;
			if (!compatiblesAsign(((TipoArray)t1).getTipoBase(), ((TipoArray)t2).getTipoBase())) return false;
			return true;
		} else if (tipo1.equals("tup")){
			if (!tipo2.equals("tup")) return false;
			TipoTupla tt1 = (TipoTupla)t1;
			TipoTupla tt2 = (TipoTupla)t2;
			if (tt1.getNElem() != tt2.getNElem()) return false;
			
			Vector<TipoElemTupla> c0 = tt1.getCampos();
			Vector<TipoElemTupla> c1 = tt2.getCampos();
			if (c1.size() != c0.size()) return false;
			
			for (int i = 0; i < tt1.getNElem(); i ++){
				if (!compatiblesAsign(c0.get(i).getTipoElem(), c1.get(i).getTipoElem())) return false;
			}
			return true;
		} else if (tipo2.equals("array") || tipo2.equals("tup")) return false;
		else if (t1.esConstante()) return false;
		else if (tipo1.equals(tipo2)) return true;
		else if (tipo1.equals("integer") && (tipo2.equals("natural"))) return true;
		else if (tipo1.equals("float") && (tipo2.equals("integer") || tipo2.equals("natural"))) return true;
		else return false;
	}
	
}
