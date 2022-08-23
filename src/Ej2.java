
public class Ej2 {

	public static void main(String[] args) {
		
		int [] v = {10,2,3,4,5,6,7,8,9,10};
		
		int min = divideVenceras(v,0, v.length);
		
		System.out.println("El mínimo del vector es: "+ min);
		
		
	}
	
	public static int divideVenceras(int []v, int ls, int li) {
		int min = 0;
		
				
		if(ls == li)
			return v[ls];
		
		else {
			int mitad = (li+ls)/2;
			int minIzq = getMin(v,mitad,li);
			int minDer = getMin(v,ls,mitad+1);
			min = Math.min(minIzq, minDer);	
		}
		
		
		return min;
	}
	
	public static int getMin(int []v, int ls, int li) {
		int min = v[0];
		
		for(int i=0;i< ls;i++) {
			if(min > v[i])
				min = v[i];
		}
		return min;
	}
	
	

}
