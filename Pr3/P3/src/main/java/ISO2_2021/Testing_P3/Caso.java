package ISO2_2021.Testing_P3;

/**********************************************************
Programa que determine:
	- si un producto software puede ser certificable
	- si lo es, que nivel de certificacion obtendria
***********************************************************/

public class Caso {
	int completitud;
	int correccion;
	int pertinencia;
	int modularidad;
	int reusabilidad;
	int analizabilidad;
	int c_mod;
	int c_prob;
	
	public Caso() {
		
	}

	

	public String funcionamiento(int completitud, int correccion, int pertinencia, int modularidad, int reusabilidad, int analizabilidad, int c_mod, int c_prob) {
		
		int v_adec = 0;
		int v_mant = 0;
		
		int [][] matriz_adecuacion = {{0,0,0},{1,1,2},{2,1,2},{2,2,3},{3,3,4},{4,5,5}};
		int [][] matriz_manten = {{0,0,0,0,0},{1,1,0,1,1},{2,2,1,2,1},{3,3,3,4,4},{4,5,5,5,4}};
		
	
		int adecuacion [] = {completitud,correccion,pertinencia};
		int mantenibilidad[] = {modularidad,reusabilidad,analizabilidad,c_mod,c_prob};
		
		adecuacion = devolvervalor(adecuacion,matriz_adecuacion);
		mantenibilidad = devolvervalor(mantenibilidad, matriz_manten);
		
		System.out.println("\nValores de adecuación: \n");
		for (int i=0; i<adecuacion.length;i++) {
			System.out.print(adecuacion[i]+" ");
		}
		
		System.out.println("\nValores de mantenimiento: \n");
		for (int i=0; i<mantenibilidad.length;i++) {
			System.out.print(mantenibilidad[i]+" ");
		}
		
		
		v_adec = obtenerminimo(adecuacion);
		v_mant = obtenerminimo(mantenibilidad);
		
		String cadena = "";
		
		if(!isvalido(v_adec,v_mant))
			cadena = "No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0";
		else {
			int [] resultado = obtenercertificado(v_adec, v_mant);
			if(resultado[0]==0)
					cadena="No obtiene certificado. Nivel de calidad: "+  String.valueOf(resultado[1]);
				else
					cadena ="Obtiene certificado de calidad con un nivel de "+ String.valueOf(resultado[1]);
			
			}
		
		return cadena;
	}
	
	public boolean isvalido(int v_adec, int v_mant) {
		
		boolean valido = false;
		
		if (v_adec <1 || v_mant < 1)
			valido = false;
		else {
			valido = true;
		}
		return valido;
	}


	public int [] devolvervalor (int [] entradas ,int [][]matriz) {
		
			int valor, rango;
			int [] resultado = new int [entradas.length];
			
			for (int i=0; i<entradas.length;i++) {
				valor = entradas[i];
				if(valor>=0 && valor<=100) {
					if(valor < 10)
						rango = 0;
					else if (valor>=10 && valor <35)
						rango = 1;
					else if (valor >= 35 && valor <50)
						rango = 2;
					else if (valor >= 50 && valor<70)
						rango = 3;
					else if (valor >= 70 && valor <90)
						rango = 4;
					else
						rango = 5;
				resultado[i] = rango;
			}
				else
					rango = 0;
				
			}
			return resultado;
	}
	
	public int obtenerminimo(int[] array) {
		int min = 5;
		
		for (int i = 0; i < array.length; i++) {
            
	        if(array[i]< min){
	        
	            min=array[i];
	            
	        }
		}
		return min;
	}
	
	
	public int [] obtenercertificado(int adecuacion_funcional, int mantenibilidad) {
		int [] resultado = {0,0};
		int nivel = 0;
		
		int certificado;
		int [][] matriz = {{1,1,1,1,1},{1,2,2,2,2},{2,2,3,3,3},{3,3,3,3,4},{3,3,4,4,5}};
				
		nivel = matriz[adecuacion_funcional-1][mantenibilidad-1];
		
		if(nivel<3) {
			certificado = 0;
		}
		else { 
			certificado = 1;
		}
		
		resultado[0]=certificado;
		resultado[1]=nivel;
		
		return resultado;
	}
	}



