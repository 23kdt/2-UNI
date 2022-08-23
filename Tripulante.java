/*************************************************************************************************************************
 * 
 * Nombre de la clase: Jugador
 * Autor/es: Diego Dorado Galán, Esther Camacho Caro, Grupo B2
 * Fecha: 16/03/2021
 * Descripción de la clase: Creamos la clase Tripulante, junto con sus atributos, constructor y métodos (getters y setters).
 * 		Nos será de ayuda para implementar nuestra clase principal. 
 * 
 * ***********************************************************************************************************************
 */
package Practica2;

public class Tripulante{
	private String rol = "tripulante";
	private int exp;
	private int tareas;
	private int ira = 1;
	
	public Tripulante(String rol, int exp, int tareas, int ira) {
		super();
		this.rol = rol;
		this.exp = exp;
		this.tareas = tareas;
		this.ira = ira;
	}
	
	public Tripulante(int exp, int tareas, int ira) {
		super();
		this.exp = exp;
		this.tareas = tareas;
		this.ira = ira;
	}

	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getTareas() {
		return tareas;
	}

	public void setTareas(int tareas) {
		this.tareas = tareas;
	}

	public int getIra() {
		return ira;
	}

	public void setIra(int ira) {
		this.ira = ira;
	}
	
	@Override
	public String toString() {
		return ("El " +rol+ " tiene " + exp +" unidades de exp, ha realizado "+ tareas+"  tareas y tiene un nivel de ira de "+ira);
	}

	/*
	@Override
	public int compareTo(Tripulante t2) {
		if (tareas < t2.tareas) {
            return -1;
        }
        if (tareas > t2.tareas) {
            return 1;
        }
        if (tareas == t2.tareas) {
        	if (exp < t2.exp) {
                return -1;
            }
            if (exp > t2.exp) {
                return 1;
            }
        }
        
        return 0;
	}
	*/

	
}
