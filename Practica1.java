/**************************************************************************************************************************************
*
* Nombre de la clase: Practica1
* Autor/es: Diego Dorado Galán, Esther Camacho Caro, Grupo B2
* Fecha: 16/03/2021
* Descripción de la clase: Implementación de  cuadro formas de cálculo o algoritmos
* diferentes para calcular la raíz cuadrada perfecta de una lista de números dado.
* Determinar empíricamente el tiempo de ejecución de los algoritmos y mostrar los
* resultados por pantalla
*
***************************************************************************************************************************************
*/
package Practica1;

import java.util.*;
import java.math.*;

public class Practica1 {

	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: main 
	 * Descripción: Método principal del programa. Declaramos las variables y la lista de numeros a trabajar. 
	 * Según la opción elegida por el usuario, mostraremos en pantalla la información detallada del
	 * cálculo de las raíces de 4 métodos distintos. 
	 * Argumentos de llamada: 
	 * Valor de retorno: void
	 * 
	 * *********************************************************************************************************************************
	 */
	public static void main(String[] args) {
		Scanner TECLADO = new Scanner(System.in);

		long tiniciobasic, tfinbasic;
		long tiniciorecur, tfinrecur;
		long tiniciobabilonico, tfinbabilonico;
		long tiniciobinary, tfinbinary;

		int[] numeros = { 1, 4, 9, 16, 25, 36, 49, 56, 81, 100, 121, 144, 169, 196, 225,
				256, 289, 324, 361, 400 };

		int opciones = opciones();

		for (int i = 0; i < numeros.length; i++) {
			tiniciobasic = System.nanoTime();
			basico(numeros[i]);
			tfinbasic = System.nanoTime();

			tiniciorecur = System.nanoTime();
			sqrtSearch(0, numeros[i], numeros[i]);
			tfinrecur = System.nanoTime();

			tiniciobabilonico = System.nanoTime();
			babilon(numeros[i]);
			tfinbabilonico = System.nanoTime();

			tiniciobinary = System.nanoTime();
			binary(numeros[i]);
			tfinbinary = System.nanoTime();

			if (opciones == 1) {
				System.out.printf("i = " + numeros[i] + "| Tiempo forma básica: " + nstoms(tfinbasic - tiniciobasic)
						+ " ms | Tiempo Babilonico: " + nstoms(tfinbabilonico - tiniciobabilonico)
						+ " ms | Tiempo binarySearch: " + nstoms(tfinbinary - tiniciobinary)
						+ " ms | Tiempo recursivo: " + nstoms(tfinrecur - tiniciorecur) + " ms");
				System.out.println();

			}
			if (opciones == 2) {
				System.out.printf("i = " + numeros[i] + "| Tiempo forma básica: " + (tfinbasic - tiniciobasic)
						+ "| Tiempo Babilonico: " + (tfinbabilonico - tiniciobabilonico) + "| Tiempo binarySearch: "
						+ (tfinbinary - tiniciobinary) + "| Tiempo recursivo: " + (tfinrecur - tiniciorecur));
				System.out.println();
			}
		}
	}


	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: binary 
	 * Descripción: Cálculo de raíces basado en la búsqueda binaria 
	 * Argumentos de llamada: int (número entero del que queramos hallar su raíz) 
	 * Valor de retorno: double (raíz)
	 * 
	 * *********************************************************************************************************************************
	 */
	public static double binary(int x) {
		double epsilon = 0.000001;
		double bajo = 0;
		double alto = x;
		double respuesta = (alto + bajo) / 2;

		while (Math.abs((respuesta * respuesta) - x) >= epsilon) {
			if ((respuesta * respuesta) < x) {
				bajo = respuesta;
			} else {
				alto = respuesta;
			}
			respuesta = (alto + bajo) / 2;
		}
		return respuesta;
	}

	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: basico 
	 * Descripción: Cálculo de raíz usando la clase Math
	 * Argumentos de llamada: int (número entero del que queramos hallar su raíz)
	 * Valor de retorno: double (raíz)
	 * 
	 * *********************************************************************************************************************************
	 */
	public static double basico(int numero) {
		double raiz;
		raiz = Math.sqrt(numero);
		return raiz;
	}

	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: sqrtSearch 
	 * Descripción: Cálculo de raíz de manera recursiva 
	 * Argumentos de llamada: Recibirá de manera recursiva el número entero del cual queramos hallar la raíz 
	 * Valor de retorno: int
	 * 
	 * *********************************************************************************************************************************
	 */
	static int sqrtSearch(int low, int high, int N) {

		// Si el rango sigue siendo válido
		if (low <= high) {

			// Encuentra el valor medio del rango
			int mid = (int) (low + high) / 2;

			// Caso base
			if ((mid * mid <= N) && ((mid + 1) * (mid + 1) > N)) {
				return mid;
			}

			// Condición para comprobar si el el espacio de búsqueda izquierdo es inservible
			else if (mid * mid < N) {
				return sqrtSearch(mid + 1, high, N);
			} else {
				return sqrtSearch(low, mid - 1, N);
			}
		}
		return low;
	}

	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: babilon 
	 * Descripción: Cálculo de raíz utilizando el método Babilonio 
	 * Argumentos de llamada: int (número entero del que queramos hallar su raíz) 
	 * Valor de retorno: double (raíz)
	 * 
	 * *********************************************************************************************************************************
	 */
	public static double babilon(int numero) {

		// Definición variables
		double n = 0, nn = 0, r, x = numero;
		double min = Double.MAX_VALUE;
		double aux;

		// Busca número más cercano
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			r = i * i;
			aux = Math.abs(r - x);
			if (aux < min) {
				n = i;
				nn = r;
				min = aux;
			} else {
				break;
			}
		}
		double m_babilonico = (x + nn) / (2 * n);
		return m_babilonico;
	}


	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: opciones
	 * Descripción: Pide por consola la unidad de tiempo de ejecución de los algoritmos
	 * Argumentos de llamada: 
	 * Valor de retorno: int
	 * 
	 * *********************************************************************************************************************************
	 */
	public static int opciones() {
		Scanner TECLADO = new Scanner(System.in);
		int eleccion;
		System.out.println("Seleccione la unidad de tiempo en la que mostrar los resultados: \n1.Milisegundos\n2.Nanosegundos");
		eleccion = TECLADO.nextInt();
		while ((eleccion != 1 && eleccion != 2)) {
			System.out.println("Opción incorrecta. Vuelva a introducir una opción (1. Milisegundos / 2. Nanosegundos)");
			eleccion = TECLADO.nextInt();
		}
		return eleccion;
	}

	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: nstoms
	 * Descripción: Realiza el cálculo de nanosegundos a milisegundos
	 * Argumentos de llamada: double
	 * Valor de retorno: double
	 * 
	 * *********************************************************************************************************************************
	 */
	public static double nstoms(double t) {
		double ms = (t * (Math.pow(10, -6)));
		return ms;
	}
}