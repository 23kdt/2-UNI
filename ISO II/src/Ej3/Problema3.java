package Ej3;

/**********************************************************
Programa que determine:
	- si un producto software puede ser certificable
	- si lo es, que nivel de certificacion obtendria
***********************************************************/
import java.math.*;
import java.util.*;


public class Problema3 {
	static Scanner TECLADO = new Scanner (System.in);
	public static void main(String[] args) {
		
		int v_adec = 0;
		int v_mant = 0;
		
		int [][] matriz_adecuacion = {{0,0,0},{1,1,2},{2,1,2},{2,2,3},{3,3,4},{4,5,5}};
		int [][] matriz_manten = {{0,0,0,0,0},{1,1,0,1,1},{2,2,1,2,1},{3,3,3,4,4},{4,5,5,5,4}};
		
		int [] adecuacion = new int[3];
		int [] mantenibilidad = new int[5];
		
		System.out.println("ADECUACIÓN FUNCIONAL DEL PRODUCTO \n");
		System.out.println("Introduzca el valor de completitud \n");
		adecuacion[0] = TECLADO.nextInt();
		System.out.println("Introduzca el valor de corrección \n");
		adecuacion[1] = TECLADO.nextInt();
		System.out.println("Introduzca el valor de pertinencia \n");
		adecuacion[2]= TECLADO.nextInt();
		
		
		System.out.println(" \n\nMANTENIBILIDAD DEL PRODUCTO \n");
		System.out.println("Introduzca la modularidad \n");
		mantenibilidad[0] = TECLADO.nextInt();
		System.out.println("Introduzca la reusabilidad \n");
		mantenibilidad[1] = TECLADO.nextInt();
		System.out.println("Introduzca la analizabilidad \n");
		mantenibilidad[2] = TECLADO.nextInt();
		System.out.println("Introduzca la capacidad de ser modificado \n");
		mantenibilidad[3] = TECLADO.nextInt();
		System.out.println("Introduzca la capacidad de ser probado \n");
		mantenibilidad[4] = TECLADO.nextInt();
		
		
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
		
		
		if (v_adec <1 || v_mant < 1)
			System.out.println("\n\nNo cumple alguno de los requisitos para obtener certificado");
		else {
			int [] resultado = obtenercertificado(v_adec, v_mant);
			if(resultado[0]==0)
				System.out.println("\n\nNo obtiene certificado. Nivel de calidad: "+resultado[1]);
			else
				System.out.println("\n\n Obtiene certificado de calidad con un nivel de "+resultado[1]);
				
		}
		
		}
		


	public static int [] devolvervalor (int [] entradas ,int [][]matriz) {
		
			int valor, rango;
			int [] resultado = new int [entradas.length];
			
			for (int i=0; i<entradas.length;i++) {
				valor = entradas[i];
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
			
			return resultado;
	}
	
	public static int obtenerminimo(int[] array) {
		int min = 5;
		
		for (int i = 0; i < array.length; i++) {
            
	        if(array[i]< min){
	        
	            min=array[i];
	            
	        }
		}
		return min;
	}
	
	
	public static int [] obtenercertificado(int adecuacion_funcional, int mantenibilidad) {
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

		
