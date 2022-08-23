
public class Ej3 {

	public static void main(String[] args) {
		
		int v[] = {-3, -2, 2, 4, 5, 7};
		int res = divideVenceras(v, 0, v.length);
		System.out.println("Recursivo " + res);
		
		
	}
	
	public static int divideVenceras(int v[], int li, int ls) {
		  int res = -1;
		  if (li <= ls) {
		    int mitad = (li + ls) / 2;
		    if (mitad == v[mitad]) {
		      res = mitad;
		    } else if (mitad < v[mitad]) {
		       res = divideVenceras(v, li , mitad - 1);
		    } else {
		      res = divideVenceras(v,  mitad + 1, ls);
		    } 
		  }
		  return res;
		}
	
	
}
