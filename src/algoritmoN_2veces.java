
public class algoritmoN_2veces {

	public static void main(String args[]) {
		
		int veces;
		int [] v = {1,1,1,1,1,1,1,1,2};
		veces = divideVenceras(v,0,v.length-1);
		
		System.out.println(veces);
		
		
	}
	
	
	public static int divideVenceras(int []v, int li, int ls) {
		
		int mayor=1;
		
		if(li==ls)
			mayor=1;
		else {
			int centro = (li+ls)/2;
			int mayor1 = divideVenceras(v,li,centro);
			if(mayor1 > 0) {
				mayor = comprobar(v,mayor1,li,ls);
				if (mayor < (li+ls)/2) {
					int mayor2 = divideVenceras(v,centro+1,ls);
					if(mayor2>0)
						mayor = comprobar(v,mayor2,li,ls);
				}
				
			}
		}
		return mayor;
		
	}
	
	public static int comprobar(int []v, int x, int li, int ls) {
		int veces = 0;
		for(int i = li;i<ls;i++) {
			if(v[i]==x)
				veces++;
		}
		return veces;
		
	}
	
	
	
	
}
