package Practica3;

import java.util.*;
/**
 * 
 * @author Diego Dorado Gal�n, Esther Camacho Caro
 *
 */
public class Principal {
	
	/**
	 * main
	 * M�todo principal del programa.Fragmentado mediante comentarios respecto a su funcionalidad. 
	 * Declaraci�n de variables, ordenaci�n mediante m�todos quicksort y realizaci�n del algoritmo voraz 
	 * @param args
	 */
	static Scanner TECLADO = new Scanner (System.in);
	public static void main(String[] args) {
		
		//DECLARAMOS LOS ARRAYS DE LAS DISTINTAS CLASES
		Eopie [] eopies = null;
		Contenedor [] contenedores = null;
		
		//PEDIMOS POR TECLADO EL N�MERO DE OBJETOS DE CADA CLASE
		int neopies = eleccionEopies(); 
		int ncontenedores = eleccionContenedores(neopies);
		
		System.out.println("Con "+ncontenedores+" contenedores y " +neopies+" eopies hemos logrado transportar lo siguiente");
		double cantidadTotal = 0;	
		
		//BUCLE PARA MOSTRAR LOS RESULTADOS DE UNA SEMANA
		for (int k=0; k<7;k++) {
			
			System.out.println("\n\t #########  Noche "+(k+1)+"  #########\n");
			
			//COMPLETAMOS LOS ARRAYS DE LAS CLASES
			eopies = hordaEopies(neopies);						
			contenedores = conjContenedores (ncontenedores);
			
			//ORDENAMOS AMBOS ARRAYS MEDIANTE UN M�TODO QUICKSORT
			quicksortCont(contenedores,0, ncontenedores-1);
			quicksortEopie(eopies, 0, neopies -1);
			
			//MOSTRAMOS POR PANTALLA LOS ARRAYS CON LOS OBJETOS ORDENADOS EN FUNCI�N DE SU CAPACIDAD
			System.out.println("Nuestros amigos eopies tienen la capacidad de transportar las siguientes capacidades, de menor a mayor capacidad");
			for (int i=0; i<eopies.length;i++) {
				System.out.print((i+1)+"| "+eopies[i].getCapacidad()+" \t");
			}
			System.out.println("\nContamos adem�s con los siguientes contenedores, ordenados por su capacidad");
			for (int i=0; i<contenedores.length;i++) {
				System.out.print((i+1)+"| "+contenedores[i].getCapacidad()+" \t");
			}
			
			//REALIZAMOS EL ALGORITMO VORAZ DONDE SE COMPLETA EL FUNCIONAMIENTO DEL PROGRAMA
			double [] solucion = cargarEopies(eopies,contenedores);
			
			//MOSTRAMOS RESULTADOS
			System.out.println("\n"+ solucion[0]+" unidades de agua transportada  "+ (int)solucion[1]+" eopies no han sido utilizados esta noche");
			
			cantidadTotal += solucion[0];
		}
		System.out.println("\nLa cantidad de agua transportada esta semana ha sido de "+cantidadTotal+" unidades");
	}
	
	/**
	 * eleccionEopies
	 * M�todo para pedir por teclado el n�mero de Eopies verificando que sea mayor que 0 
	 * @return eopies, n�mero de eopies
	 */
	public static int eleccionEopies() {
		int eopies = 0;
		System.out.println("\t************ BIENVENIDO AL PLANETA TATOOINE ************");
		System.out.println("Buenos d�as l�der, planifiquemos la extracci�n de hoy \nLe recuerdo que el n�mero de Eopies debe ser menor que el de contenedores");
		do{
				try {
					System.out.println("Como l�der del grupo de Jawas, introduzca el n�mero de eopies que disponemos");
					eopies = TECLADO.nextInt();
		        } catch (InputMismatchException ex) {
		            System.out.println("El valor debe ser num�rico y superior a 0");
		            eopies = TECLADO.nextInt();
		        }	
		}while (eopies<1);

		return eopies;
}
	/**
	 * eleccionContenedores
	 * M�todo para pedir por teclado el n�mero de Contenedores verificando que sea mayor que el n�mero de Eopies
	 * @param numero, variable que representa el n�mero de Eopies introducido anteriormente
	 * @return contenedores, n�mero de contenedores a utilizar
	 */
	public static int eleccionContenedores (int numero) {
		int contenedores = 0; 
		do{
			try {
				System.out.println("Introduzca el n�mero de contenedores. Debe ser mayor que el n�mero de eopies");
				if (TECLADO.hasNextLine())
					contenedores = TECLADO.nextInt();
	        } catch (InputMismatchException ex) {
	            System.out.println("El valor debe ser num�rico y superior a 0");
	            contenedores = TECLADO.nextInt();
	        }	
	}while (contenedores <= numero);

	return contenedores;
	}
	
	/**
	 * generarEopie
	 * Genera un objeto de la clase Eopie
	 * @return eop, objeto de la clase Eopie
	 */
	public static Eopie generarEopie () {
		double capacidad = ((Math.random()*49)+1);
		Eopie eop = new Eopie(capacidad);
		return eop;
	}
	
	/**
	 * generarContenedor
	 * Genera un objeto de la clase Contenedor
	 * @return con, objeto de la clase Contenedor
	 */
	public static Contenedor generarContenedor() {
		double capacidad = ((Math.random()*49)+1);
		Contenedor con = new Contenedor(capacidad, false);
		return con;
	}
	
	/**
	 * hordaEopies
	 * Completa un array de la clase Eopie a partir del metodo generarEopie()
	 * @param numero, n�mero de Eopies a utilizar, introducido anteriormente
	 * @return eopies, array de objetos de la clase Eopie completado
	 */
	public static Eopie [] hordaEopies (int numero) {
		Eopie [] eopies = new Eopie [numero];
		for (int i = 0; i< numero; i++) {
			eopies[i] = generarEopie();
		}
		return eopies;
	} 
	
	/**
	 * conjContenedores
	 * Completa un array de la clase Contenedor a partir del m�todo generarContenedor()
	 * @param numero, n�mero de Contenedores a utilizar, introducido anteriormente
	 * @return contenedores, array de objetos de la clase Contenedor completado
	 */
	public static Contenedor[] conjContenedores (int numero) {
		Contenedor [] contenedores = new Contenedor [numero];
		for (int i = 0; i< numero; i++) {
			contenedores[i] = generarContenedor();
		}
		return contenedores;
	}
	
	/**
	 * quicksortEopie
	 * M�todo que ordena el array de Eopies en funcion de su variable capacidad
	 * @param A, array de objetos de la clase Eopie
	 * @param izq, �ndice inferior del array, que es 0
	 * @param der, �ndice superior del array, que ser� igual a la longitud del array -1
	 */
	public static void quicksortEopie(Eopie A[], int izq, int der) {

		  double pivote=A[izq].getCapacidad(); // tomamos primer elemento como pivote
		  int i=izq;         // i realiza la b�squeda de izquierda a derecha
		  int j=der;         // j realiza la b�squeda de derecha a izquierda
		  double aux;
		 
		  while(i < j){                          // mientras no se crucen las b�squedas                                   
		     while(A[i].getCapacidad() <= pivote && i < j) i++; // busca elemento mayor que pivote
		     while(A[j].getCapacidad() > pivote) j--;           // busca elemento menor que pivote
		     if (i < j) {                        // si no se han cruzado                      
		         aux= A[i].getCapacidad();                      // los intercambia
		         A[i].setCapacidad(A[j].getCapacidad());
		         A[j].setCapacidad(aux);
		     }
		   }
		   
		   A[izq].setCapacidad(A[j].getCapacidad());      // se coloca el pivote en su lugar de forma que tendremos                                    
		   A[j].setCapacidad(pivote);      // los menores a su izquierda y los mayores a su derecha
		   
		   if(izq < j-1)
		      quicksortEopie(A,izq,j-1);          // ordenamos subarray izquierdo
		   if(j+1 < der)
		      quicksortEopie(A,j+1,der);          // ordenamos subarray derecho 
		}
	
	/**
	 * quicksortCont
	 * M�todo que ordena el array de Contenedorers en funcion de su variable capacidad
	 * @param A, array de objetos de la clase Contenedor
	 * @param izq, �ndice inferior del array, que es 0
	 * @param der, �ndice superior del array, que ser� igual a la longitud del array -1
	 */
	public static void quicksortCont(Contenedor A[], int izq, int der) {
	
		  double pivote=A[izq].getCapacidad(); // tomamos primer elemento como pivote
		  int i=izq;         // i realiza la b�squeda de izquierda a derecha
		  int j=der;         // j realiza la b�squeda de derecha a izquierda
		  double aux;
		 
		  while(i < j){                          // mientras no se crucen las b�squedas                                   
		     while(A[i].getCapacidad() <= pivote && i < j) i++; // busca elemento mayor que pivote
		     while(A[j].getCapacidad() > pivote) j--;           // busca elemento menor que pivote
		     if (i < j) {                        // si no se han cruzado                      
		         aux= A[i].getCapacidad();                      // los intercambia
		         A[i].setCapacidad(A[j].getCapacidad());
		         A[j].setCapacidad(aux);
		     }
		   }
		   
		   A[izq].setCapacidad(A[j].getCapacidad());      // se coloca el pivote en su lugar de forma que tendremos                                    
		   A[j].setCapacidad(pivote);      // los menores a su izquierda y los mayores a su derecha
		   
		   if(izq < j-1)
		      quicksortCont(A,izq,j-1);          // ordenamos subarray izquierdo
		   if(j+1 < der)
		      quicksortCont(A,j+1,der);          // ordenamos subarray derecho 
		}
	
	/**
	 * cargarEopies
	 * Algoritmo voraz que sirve para recorrer el array de eopies, buscando de mayor a menor entre los elementos del array de contenedores
	 * uno de estos con una capacidad igual o menor a la del eopie correspondiente, cambiando el valor de la variable "usado" de contenedores,
	 * que almacena los valores de las capacidades transportadas, e indica el n�mero de eopies no utilizados
	 * @param eopies, array de objetos de la clase Eopie
	 * @param contenedor, array de objetos de la clase Contenedor
	 * @return solucion, array con dos valores, el primero con la cantidad de agua transportada ese d�a, y el n�mero de eopies que no han sido utilizados
	 */
	
	public static double[] cargarEopies (Eopie [] eopies, Contenedor [] contenedor) {
		
		int contador_eopies =0;
		for (int i= (eopies.length-1); i>=0;i--) {
			for(int j=(contenedor.length-1); j>=0;j--) {
				if (eopies[i].getCapacidad()>= contenedor[j].getCapacidad() && contenedor[j].isUsado() == false) {
					contador_eopies ++;
					contenedor[j].setUsado(true);
					break;
				}
			}
		}
		double cantidad = calcularAguaTrans(contenedor);
		double [] solucion = {cantidad, (double)(eopies.length -contador_eopies)};
		return solucion;
	}
	
	/**
	 * calcularAguaTrans
	 * M�todo que sirve para calcular la cantidad de agua transportada por los contenedores usados
	 * @param c, array de objetos de la clase Contenedor
	 * @return cantidad, double con la cantidad total transportada en un d�a
	 */
	public static double calcularAguaTrans (Contenedor [] c) {
		double cantidad=0;
		for (int i=0; i<c.length;i++) {
			if(c[i].isUsado()) {
				cantidad += c[i].getCapacidad();
			}
		}
		return cantidad;
	}
	}
		
		