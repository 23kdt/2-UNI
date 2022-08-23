
public class EJ1 {

	public static void main(String[] args) {
		System.out.println("Array antes de la ordenación\n");
		int [] array = {9,2,6,4,8,4,6,2,4,7};
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		
		quicksort(array,0,array.length-1);
		System.out.println("\nArray después de ordenar\n");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		
	}
	public static void quicksort(int []v, int li, int ls) {
		
		if(li<ls) {
			int pos = divide(v,li,ls);
			quicksort(v,li,pos-1);
			quicksort(v,pos+1,ls); 
		}
		
	}
	public static int divide(int[]v, int li, int ls) {
		int pivote = v[li];
		
		int izq = li+1;
		int der = ls;
		
		do {
			
			while(v[izq]<=pivote && izq < ls)
				izq++;
			while(v[der]>=pivote && der > li)
				der--;
			
			if(izq<der) {
				intercambia(v,izq,der);
				izq++;
				der--;
			}
		}while(izq<der);
		
		if(der<= izq)
			intercambia(v,li,der);
		return der;
	}
	
	public static void intercambia(int[]v, int izq, int der) {
		int aux;
		aux = v[izq];
		v[izq] = v[der];
		v[der]= aux;
		
	}
	

}
