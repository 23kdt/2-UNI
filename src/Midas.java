
public class Midas {

	public static void main(String[] args) {
		
		int [] bolsa = {0,0,0,0,0,0,0,1,0,0,0,0};
		int pos;
		
		System.out.println("La moneda falsa está en la posición :");
		pos = monedaFalsa(bolsa,0,bolsa.length-1);
		System.out.println(pos);
		
		
	}
	
	public static int monedaFalsa(int []v, int li, int ls) {
		
		int pos = -1;
		
		if(li==ls)
			pos= li;
		else {
			int mitad = (li+ls)/2;
			
			if(((ls+1)-li) %2 != 0) { //nº monedas impar
				
				int pesoizq = pesar(v,li,mitad-1);
				int pesoder = pesar(v,mitad+1,ls);
				if(pesoizq>pesoder)
					pos = monedaFalsa(v,li,mitad-1);
				else if(pesoizq < pesoder)
					pos = monedaFalsa(v,mitad+1,ls);
				else
					pos = mitad;
				
			}
			else { //nº monedas par
				int pesoizq = pesar(v,li,mitad);
				int pesoder = pesar(v,mitad+1,ls);
				if(pesoizq>pesoder)
					pos = monedaFalsa(v,li,mitad);
				else
					pos = monedaFalsa(v,mitad+1,ls);
			}
			
				
		}
		return pos;
	}
	
	public static int pesar(int []v, int li, int ls) {
		int peso=0;
		for(int i=li;i<ls;i++) {
			peso+=v[i];
		}
		return peso;
	}

}
