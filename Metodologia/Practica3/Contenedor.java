package Practica3;
/**
 * 
 * @author Diego Dorado Galán, Esther Camacho Caro
 *	Variables: double capacidad, boolean usado
 */
public class Contenedor {
	double capacidad = 0;
	boolean usado = false;
	
	/**
	 * Contenedor
	 * Método Constructor
	 * @param capacidad
	 * @param usado
	 */
	public Contenedor(double capacidad, boolean usado) {
		super();
		this.capacidad = capacidad;
		this.usado = usado;
	}
	/**
	 * Getters y Setters
	 */
	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

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
		return "Contenedor [capacidad=" + capacidad + ", usado=" + usado + "]";
	}
	
}

