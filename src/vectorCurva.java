
public class vectorCurva {
	
	public static void main(String args[]) {
		vectorCurva x=new vectorCurva(new int[]{9,8,7,3,2,4,6});
		System.out.println(x); 

		vectorCurva y=new vectorCurva(new int[]{9,8,7,3,2,4,6});
		System.out.println(y); 

		vectorCurva z=new vectorCurva(new int[]{5,4,2});
		System.out.println(z); 

		vectorCurva w=new vectorCurva(new int[]{9,8,7,3,2});
		System.out.println(w); 
	}
	
	int [] sol;
	int k;
	
	
	public vectorCurva(int []x) {
		sol = x;
		if(x.length==1)
			k=0;
		else
			k= solucion(0,sol.length-1);
	}
	
	//Método divide y vencerás 
	private int solucion(int li, int ls) {
		int s=-1;
		//caso trivial
		if(ls <= li+1) {
			
			//si estamos en un subvector de dos posiciones
			//o es li o ls
			if(vale(sol,li))
				s = li;
			else
				s = ls;
		}else {
			int mid = (ls + li)/2;
			
			if(vale(sol,mid))
				s = mid;
			else {
				if(sol[mid]> sol[mid-1])
					s = solucion(li,mid);
				else
					s = solucion(mid+1,ls);
			}
		}
		return s;
	}
	
	private boolean vale(int []s, int v) {
		//si la posicion es la primera el valor siguiente es menor
		//si la posicion es la ultima el valor anterior es menor
		//si es otra posicion, menor que el posterior y menor que el anterior
		
		return (v == 0 && sol[v+1]>sol[v]) 
				|| (v==sol.length-1 && sol[v-1]>sol[v])
				|| (v>0 && v< sol.length-1 && sol[v] < sol[v-1] && sol[v]< sol[v+1]);		
	}
	
	public String toString() {
		String s= "";
		for(int i=0;i<sol.length;i++)
			s = s + sol[i]+" ";
		
		s = s + " K-> "+k+" valor-> "+sol[k];
		return s;
	}
	
}
