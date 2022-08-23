package Practica4;
/**
 * 
 * @author Diego Dorado Galán, Esther Camacho Caro
 *
 */
import java.util.ArrayList;
import java.util.*;

public class JuegoCifras {

	private static final Operaciones[] OPERACIONES = { new Suma(), new Resta(), new Multiplicacion(), new Division() };
	private ArrayList<String> solucion = new ArrayList<>();
	/**
	 * main
	 * Método principal del programa. Fragmentado mediante comentarios respecto a su funcionalidad. 
	 * Declaración de variables y uso de los distintos métodos 
	 * @param args
	 */
	public static void main(String[] args) {

		// GENERAMOS NÚMEROS
		int numGrandes = eleccionNumGrandes();
		int[] numeros = new int[6];
		numeros = seleccionNumeros(numeros, numGrandes);
		mostrarNumeros(numeros);
		// GENERAMOS NÚMERO SOLUCION
		int total = generarTotal();
		System.out.println("El número solución a alcanzar es "+total);
		//EJECUCIÓN DEL PROGRAMA PARA ENCONTRAR UNA SOLUCION
		JuegoCifras juego = new JuegoCifras();
		if(juego.esSolucion(numeros, numeros.length, total)) {
			System.out.println("Se ha encontrado la siguiente solución: ");
			juego.imprimirSolucion();
		}else {
			System.out.println("No se ha encontrado ninguna solucion");
		}

	}
	
	/**
	 * esSolucion
	 * Método para calcular la solución del enunciado, basado en algoritmo backtracking
	 * @param numeros,elementos a usar
	 * @param size(numero de elementos)
	 * @param total(resultado)
	 * @return boolean
	 */
	public boolean esSolucion(int[] arrayNumeros, int size, int total) {

		for (int i = 0; i < size; i++) {
			
			if (arrayNumeros[i] == total) {
				return true;
			}

			for (int j = i + 1; j < size; j++) {
				for (int k = 0; k < OPERACIONES.length; k++) {
					
					int res = OPERACIONES[k].elementos(arrayNumeros[i], arrayNumeros[j]);

					if (res != 0) {
						int primero = arrayNumeros[i];
						int segundo = arrayNumeros[j];
						arrayNumeros[i] = res;
						arrayNumeros[j] = arrayNumeros[size - 1];

						if (esSolucion(arrayNumeros, size - 1, total)) {
							solucion.add(Math.max(primero, segundo) + " " + OPERACIONES[k].simbolo() + " "
									+ Math.min(primero, segundo) + " = " + res);
							return true;
						}

						arrayNumeros[i] = primero;
						arrayNumeros[j] = segundo;
					}
				}
			}
		}

		return false;
	}
	
	/**
	 * imprimirSolucion
	 * Método que imprime la solucion por pantalla
	 */
	public void imprimirSolucion() {
	    for (int i = solucion.size() - 1; i >= 0; i--) {
	      System.out.println(solucion.get(i));
	    }
	  }

	/**
	 * eleccionNumGrandes
	 * Método para pedir por teclado el número de elementos del conjunto de numeros grandes a usar
	 * @return numero, número de elementos grandes
	 */
	public static int eleccionNumGrandes() {
		Scanner TECLADO = new Scanner(System.in);
		int numero = 0;
		System.out.println("\t************ JUEGO DE LAS CIFRAS ************");
		System.out
				.println("CONJUNTOS DE NÚMEROS: \nGrandes: {25, 50, 75, 100} \nPequeños:{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, "
						+ "6, 6, 7, 7, 8, 8, 9, 9, 10, 10}");
		do {
			System.out.println("Introduzca el número de números grandes con los que desea jugar (=<4): ");
			numero = TECLADO.nextInt();
		} while (numero < 0 || numero > 4);

		return numero;
	}

	/**
	 * seleccionNumeros
	 * Método para generar la lista de los 6 numeros a utilizar en nuestro programa
	 * @return numeros, array de elementos
	 */
	public static int[] seleccionNumeros(int[] numeros, int numGrandes) {

		int[] arrayGrandes = { 25, 50, 75, 100 };
		int[] arrayPequeños = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10 };

		int aleatorioGrandes, aleatorioPequeños;
		boolean repetido;

		// AÑADIMOS LOS NÚMEROS GRANDES
		for (int i = 0; i < numGrandes; i++) {
			do {
				aleatorioGrandes = (int) (Math.random() * arrayGrandes.length);
				repetido = esRepetido(arrayGrandes[aleatorioGrandes], numeros, 0);
			} while (repetido);
			numeros[i] = arrayGrandes[aleatorioGrandes];
		}

		// AÑADIMOS LOS NUMEROS PEQUEÑOS
		for (int i = numGrandes; i < numeros.length; i++) {
			do {
				aleatorioPequeños = (int) (Math.random() * arrayPequeños.length);
				repetido = esRepetido(arrayPequeños[aleatorioPequeños], numeros, numGrandes);
			} while (repetido);
			numeros[i] = arrayPequeños[aleatorioPequeños];
		}
		return numeros;
	}

	/**
	 * esRepetido
	 * Método para calcular si el elemento seleccionado ya ha sido previamente introducido en el array de numeros
	 * @param elemento, variable que queremos introducir
	 * @param numeros, array de numeros
	 * @param indice, posicion de partida a la hora de revisar los numeros introducidos
	 * @return boolean
	 */
	public static boolean esRepetido(int elemento, int[] numeros, int indice) {
		boolean repetido = false;
		for (int i = indice; i < numeros.length; i++) {
			if (elemento == numeros[i]) {
				repetido = true;
				break;
			}
		}
		return repetido;
	}

	/**
	 * mostrarNumeros
	 * Método para mostrar por pantalla los numeros seleccionados
	 * @param numeros, array de numeros
	 */
	public static void mostrarNumeros(int[] numeros) {
		System.out.println("La lista de números es la siguiente: ");
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * generarTotal
	 * Genera un numero aleatorio entre un rango dado
	 * @return total, numero resultado
	 */
	public static int generarTotal() {
		int numMin = 101, numMax = 999;
		int total = (int) (Math.random() * (numMax + 1 - numMin)) + numMin;
		return total;
	}

	
}
