package Practica3;
/**
 * 
 * @author Diego Dorado Galán, Esther Camacho Caro
 *
 */

public class Eopie {
	double capacidad = 0;
	
	/**
	 * Eopie
	 * Método constructor
	 * @param capacidad
	 */
	public Eopie(double capacidad) {
		super();
		this.capacidad = capacidad;
	}
	/**
	 * Getters y Setters
	 */
	public double getCapacidad() {
		return capacidad;
	}
	
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	
	@Override
	/**
	 * toString
	 */
	public String toString() {
		return "Eopie capacidad=" + capacidad;
	}
	
}
