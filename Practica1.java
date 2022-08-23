/**************************************************************************************************************************************
*
* Nombre de la clase: Practica1
* Autor/es: Diego Dorado Gal�n, Esther Camacho Caro, Grupo B2
* Fecha: 16/03/2021
* Descripci�n de la clase: Implementaci�n de  cuadro formas de c�lculo o algoritmos
* diferentes para calcular la ra�z cuadrada perfecta de una lista de n�meros dado.
* Determinar emp�ricamente el tiempo de ejecuci�n de los algoritmos y mostrar los
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
	 * Nombre del m�todo: main 
	 * Descripci�n: M�todo principal del programa. Declaramos las variables y la lista de numeros a trabajar. 
	 * Seg�n la opci�n elegida por el usuario, mostraremos en pantalla la informaci�n detallada del
	 * c�lculo de las ra�ces de 4 m�todos distintos. 
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
				System.out.printf("i = " + numeros[i] + "| Tiempo forma b�sica: " + nstoms(tfinbasic - tiniciobasic)
						+ " ms | Tiempo Babilonico: " + nstoms(tfinbabilonico - tiniciobabilonico)
						+ " ms | Tiempo binarySearch: " + nstoms(tfinbinary - tiniciobinary)
						+ " ms | Tiempo recursivo: " + nstoms(tfinrecur - tiniciorecur) + " ms");
				System.out.println();

			}
			if (opciones == 2) {
				System.out.printf("i = " + numeros[i] + "| Tiempo forma b�sica: " + (tfinbasic - tiniciobasic)
						+ "| Tiempo Babilonico: " + (tfinbabilonico - tiniciobabilonico) + "| Tiempo binarySearch: "
						+ (tfinbinary - tiniciobinary) + "| Tiempo recursivo: " + (tfinrecur - tiniciorecur));
				System.out.println();
			}
		}
	}


	/***********************************************************************************************************************************
	 * 
	 * Nombre del m�todo: binary 
	 * Descripci�n: C�lculo de ra�ces basado en la b�squeda binaria 
	 * Argumentos de llamada: int (n�mero entero del que queramos hallar su ra�z) 
	 * Valor de retorno: double (ra�z)
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
	 * Nombre del m�todo: basico 
	 * Descripci�n: C�lculo de ra�z usando la clase Math
	 * Argumentos de llamada: int (n�mero entero del que queramos hallar su ra�z)
	 * Valor de retorno: double (ra�z)
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
	 * Nombre del m�todo: sqrtSearch 
	 * Descripci�n: C�lculo de ra�z de manera recursiva 
	 * Argumentos de llamada: Recibir� de manera recursiva el n�mero entero del cual queramos hallar la ra�z 
	 * Valor de retorno: int
	 * 
	 * *********************************************************************************************************************************
	 */
	static int sqrtSearch(int low, int high, int N) {

		// Si el rango sigue siendo v�lido
		if (low <= high) {

			// Encuentra el valor medio del rango
			int mid = (int) (low + high) / 2;

			// Caso base
			if ((mid * mid <= N) && ((mid + 1) * (mid + 1) > N)) {
				return mid;
			}

			// Condici�n para comprobar si el el espacio de b�squeda izquierdo es inservible
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
	 * Nombre del m�todo: babilon 
	 * Descripci�n: C�lculo de ra�z utilizando el m�todo Babilonio 
	 * Argumentos de llamada: int (n�mero entero del que queramos hallar su ra�z) 
	 * Valor de retorno: double (ra�z)
	 * 
	 * *********************************************************************************************************************************
	 */
	public static double babilon(int numero) {

		// Definici�n variables
		double n = 0, nn = 0, r, x = numero;
		double min = Double.MAX_VALUE;
		double aux;

		// Busca n�mero m�s cercano
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
	 * Nombre del m�todo: opciones
	 * Descripci�n: Pide por consola la unidad de tiempo de ejecuci�n de los algoritmos
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
			System.out.println("Opci�n incorrecta. Vuelva a introducir una opci�n (1. Milisegundos / 2. Nanosegundos)");
			eleccion = TECLADO.nextInt();
		}
		return eleccion;
	}

	/***********************************************************************************************************************************
	 * 
	 * Nombre del m�todo: nstoms
	 * Descripci�n: Realiza el c�lculo de nanosegundos a milisegundos
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