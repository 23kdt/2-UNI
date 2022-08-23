
public class TornillosTuercas {

	public static void main(String[] args) {
	
		int [] tr = {5,4,7,2,9,2,4};
		int [] tc = {1,9,4,5,3,8,7};
		
		quicksort(0,tr.length-1,tr,tc);
		
		System.out.println("Tornillos: ");
		for(int i=0;i<tr.length;i++)
			System.out.print(tr[i]+" ");
		
		System.out.println("Tuercas: ");
		for(int i=0;i<tc.length;i++)
			System.out.print(tc[i]+" ");
	}
	
	public static void quicksort(int li, int ls, int []tr, int [] tc) {
		
		if(li < ls) {
			
			//comenzamos tomando como pivotes para las tuercas el último tornillo
			int pivote = division(tc,li,ls,tr[ls]);
			//ahora pivotamos los tornillos con la tuerca seleccionada
			division(tr,li,ls,tc[pivote]);
			
			//ordenar partes derecha e izquierda
			quicksort(li,pivote-1,tr,tc);
			quicksort(pivote+1,ls,tr,tc);
			
		}
		
	}
	
	public static int division(int [] v, int li, int ls, int pivote) {
		
		int s = li;
		
		int tem1, tem2;
		for(int i=li;i<ls;i++) {
			
			if(v[i]<pivote) {
				tem1 = v[s];
				v[s]= v[i];
				v[i]= tem1;
				s++;
			}
			else if(v[i]==pivote) {
				tem1 = v[i];
				v[i]= v[ls];
				v[ls]=tem1;
				i--;
			}
		}
		tem2 = v[s];
		v[s]=v[ls];
		v[ls]=tem2;
		
		return s;
	}
	

}
