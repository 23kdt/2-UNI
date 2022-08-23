import java.util.*;

public class Ej6 {

	static Scanner TECLADO = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int [] array = {4,5,7,8,9,1,6,46,23,54,84,21,7,49,52,16,4};
		int [] sol;
		
		System.out.println("Introduzca un número \n\n");
		int numeros = TECLADO.nextInt();
		
		System.out.println("El array ordenado es el siguiente:\n");
		
		quicksort(array,0,array.length-1);
		
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		
		System.out.println("\n\nLa solución es: \n");
		
		sol = devolverSolucion(numeros, array);
		
		for(int i=0;i<sol.length;i++) {
			System.out.print(sol[i]+" ");
		}
		
		
		
		
	}
	
	public static int[] devolverSolucion(int numeros, int v[]) {
		int[] solucion= new int[numeros];
		
		for(int i = 0; i<numeros;i++)
			solucion[i]=v[i];
		
		return solucion;
	}
	
	public static void quicksort(int []v, int li, int ls) {
			
		if(li<ls) {
			int pos = divide(v, li, ls);
			quicksort(v,li,pos);
			quicksort(v,pos+1,ls);
			
		}
	}
	
	public static int divide(int []v, int li, int ls) {
		int pivote = v[li];
		
		int izq = li+1;
		int der = ls;
		
		do {
			
			while(v[izq]<=pivote && izq<ls)
				izq++;
			while(v[der]>=pivote && der>li)
				der--;
			
			if(izq<der) {
				intercambiar(v,izq,der);
				izq++;
				der--;
			}
		}while(izq<der);
		
		if(der<=izq)
			intercambiar(v,li,der);
		
		return der;
	}
	
	public static void intercambiar(int []v, int izq, int der) {
		int aux = v[izq];
		v[izq]= v[der];
		v[der]= aux;
	}
	

}
