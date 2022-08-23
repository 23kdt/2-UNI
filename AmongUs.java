/**************************************************************************************************************************************
*
* Nombre de la clase: AmongUs
* Autor/es: Diego Dorado Galán, Esther Camacho Caro, Grupo B2
* Fecha: 16/03/2021
* Descripción de la clase: Adaptación del conocido juego "Among Us". El objetivo consiste en descubrir
* al impostor, además del ganador de la partida.
*
***************************************************************************************************************************************
*/
package Practica2;
import java.util.*;


public class AmongUs {

	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: main
	 * Descripción: Método principal del programa. Haciendo uso de métodos externos, el método generará un array de jugadores.
	 * Se buscará el impostor de la partida y se calculará el tiempo empleado para ello. También nos mostrará el ganador.
	 * Argumentos de llamada: String[] args
	 * Valor de retorno: void
	 * 
	 * *********************************************************************************************************************************
	 */
	public static void main(String[] args) {
		
		// GENERAMOS TRIPULACIÓN
		Tripulante [] tripulacion = null;
		int jugadores, impostor, ganador;
		jugadores = eleccion();
		tripulacion = generartripulacion(jugadores);
		
		long tinicioimpostor, tfinimpostor;
		
		// ASIGNAMOS IMPOSTOR
		tinicioimpostor = System.nanoTime();
		asignarImpostor(tripulacion);
		impostor = posicionImpostor(tripulacion, 0, tripulacion.length-1);
		tfinimpostor = System.nanoTime();
		//System.out.println(impostor);
		
		System.out.println("Lista de JUGADORES: ");
		for (int i=0; i<tripulacion.length;i++) {
			System.out.println("Jugador "+i+": "+tripulacion[i].toString());
		}
		
		System.out.println("IMPOSTOR: ");
		System.out.println(tripulacion[impostor].toString());
		System.out.println("Tiempo (en nanosegundos) que se ha tardado en encontrar al impostor: "+
							(tfinimpostor-tinicioimpostor));
		
		// BUSCAMOS GANADOR
		System.out.println("GANADOR: ");
		ganador = seleccionGanador(tripulacion,impostor);
		//System.out.println(ganador);
		System.out.println(tripulacion[ganador].toString());
		
	}

	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: asignarImpostor
	 * Descripción: Declaramos un único impostor de manera aleatoria entre los tripulantes
	 * Argumentos de llamada: Array [] con los tripulantes
	 * Valor de retorno: void
	 * 
	 * *********************************************************************************************************************************
	 */
	public static void asignarImpostor (Tripulante [] tripulacion) {
		int impostor = (int) (Math.random() * tripulacion.length);
		tripulacion[impostor].setIra(2);
		tripulacion[impostor].setRol("impostor");

	}
	
	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: posicionImpostor
	 * Descripción: Algoritmo Divide y Vencerás que realiza una búsqueda de la posición del impostor
	 * Argumentos de llamada: Array [] con los tripulantes, un límite inferior y un límite superior
	 * Valor de retorno: int (con la posición)
	 * 
	 * *********************************************************************************************************************************
	 */
	/*
	public static int posicionImpostor (Tripulante [] tripulacion,int li, int ls) {
		int pos=-1;
		int mitad = (li+ls)/2;
		if(li==ls) {
			return mitad;
		} else {
			int iraizq = medidor(tripulacion,li, mitad-1);
			int iradcha = medidor(tripulacion,mitad + 1, ls);
				if (iraizq < iradcha)
					pos = posicionImpostor(tripulacion,li, mitad-1);
				else if (iraizq > iradcha)
				pos =  posicionImpostor(tripulacion,mitad+1, ls);
			}
		return pos;
	}
	*/
	public static int posicionImpostor (Tripulante [] tripulacion,int li, int ls) {
		int pos = -1;
		if(li==ls) {
			pos = li;
		} else {
			int mitad = (li+ls)/2;
			if((ls-li)%2 == 0) {  //nº monedas par
				int iraizq = medidor(tripulacion,li, mitad-1);
				int iradcha = medidor(tripulacion,mitad + 1, ls);
				if (iraizq < iradcha)
					pos = posicionImpostor(tripulacion,li, mitad-1);
				else if (iraizq > iradcha)
				pos = posicionImpostor(tripulacion,mitad+1, ls);
				else pos = mitad;
			}else {   //nº monedas par
				int iraizq = medidor (tripulacion,li, mitad);
				int iradcha = medidor (tripulacion,mitad+1, ls);
				if(iraizq < iradcha)
					pos = posicionImpostor(tripulacion,li,mitad);
				else if (iraizq > iradcha)
					pos = posicionImpostor(tripulacion,mitad+1,ls);
			}
		}
		return pos;
	}
	
	
	
	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: medidor
	 * Descripción: Recorre los elementos(tripulantes) y va sumando uno de sus atributos "ira"
	 * Argumentos de llamada: Array [] con los tripulantes, un límite inferior y un límite superior
	 * Valor de retorno: int 
	 * 
	 * *********************************************************************************************************************************
	 */
	public static int medidor (Tripulante [] tripulantes, int li, int ls) {
		int ira = 0;
		for (int i = li; i< ls;i++) {
			ira += tripulantes[i].getIra();
		}
		return ira;
	}
	
	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: generartripulacion
	 * Descripción: Generamos un array de elementos(tripulación). Hace uso de un método complementario 
	 * que genera cada uno de los elementos
	 * Argumentos de llamada: int (número de elementos que tendra el array)
	 * Valor de retorno: Array []
	 * 
	 * *********************************************************************************************************************************
	 */
	public static Tripulante [] generartripulacion (int jugadores) {
		Tripulante tripulacion[] = new Tripulante[jugadores];
		for (int i = 0; i< jugadores; i++) {
			tripulacion[i] = generarTripulante();
		}
		return tripulacion;
	} 
	
	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: generarTripulante
	 * Descripción: Genera elementos con sus respectivos atributos, que se generarán de manera aleatoria
	 * Argumentos de llamada: 
	 * Valor de retorno: elemento clase Tripulante
	 * 
	 * *********************************************************************************************************************************
	 */
	public static Tripulante generarTripulante () {
		int exp = (int)(Math.random()*5);
		int tareas = (int)(Math.random()*8);
		Tripulante trip = new Tripulante(exp,tareas, 1);
		return trip;
	}
	
	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: eleccion
	 * Descripción: Pide por consola el número de elementos que debe contener el array (número de jugadores)
	 * Argumentos de llamada: 
	 * Valor de retorno: int
	 * 
	 * *********************************************************************************************************************************
	 */
	public static int eleccion () {
		Scanner TECLADO = new Scanner (System.in);
		int jugadores = 0; 
		System.out.println("************ BIENVENIDO a AMONG US ************");
		do {
			System.out.println("Introduzca el número de jugadores (>=3): ");
			jugadores = TECLADO.nextInt();
		}while (jugadores < 3);
		
		return jugadores;
	}	
	
	/***********************************************************************************************************************************
	 * 
	 * Nombre del método: seleccionGanador
	 * Descripción: Serie de comparaciones de distintos atributos para declarar el ganador de la partida
	 * Argumentos de llamada: Array de tripulantes, int posicion del impostor
	 * Valor de retorno: int (jugador ganador)
	 * 
	 * *********************************************************************************************************************************
	 */
	public static int seleccionGanador (Tripulante [] trip, int impostor) {
		int tripderecha;
		
		System.out.println("Comparamos al impostor con el jugador de su derecha");
		if(impostor==trip.length-1) {
			tripderecha=0;
		}
		else {
			tripderecha=impostor+1;
		}
		
		if((trip[impostor].getTareas() > trip[tripderecha].getTareas())) {
			System.out.println("Ha ganado el IMPOSTOR");
			return impostor;
		}
		else if((trip[impostor].getTareas() < trip[tripderecha].getTareas())) {
			System.out.println("Ha ganado el TRIPULANTE");
			return tripderecha;
		}
		else if((trip[impostor].getExp()>trip[tripderecha].getExp())) {
			System.out.println("Ha ganado el IMPOSTOR");
			return impostor;
		}
		else if((trip[impostor].getExp()<trip[tripderecha].getExp())) {
			System.out.println("Ha ganado el TRIPULANTE");
			return tripderecha;
		}
		else {
			System.out.println("Ha ganado el TRIPULANTE");
			return tripderecha;
		}
	}
	
	
	
	
	/*
	public static Tripulante seleccionGanador (Tripulante [] tripulacion) {
		Tripulante ganador = null;
		for(int i=0; i<=tripulacion.length;i++) {
			if(tripulacion[i].getTareas() > tripulacion[i+1].getTareas())
				tripulacion[i] = ganador;
			else if(tripulacion[i].getTareas() == tripulacion[i+1].getTareas()) {
				if(tripulacion[i].getExp() > tripulacion[i+1].getExp()) {
					tripulacion[i] = ganador;
				}
			}
			
			tripulacion[i] = ganador;
		}
		return ganador;
	}
	*/
	
	
	
}