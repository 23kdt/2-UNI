package Ej3;

public class Rango {
	public Rango(int completitud, int correccion, int pertinencia, int modularidad, int reusabilidad,
			int analizabilidad, int capacidad_serModificado, int capacidad_serProbado) {
		super();
		this.completitud = completitud;
		this.correccion = correccion;
		this.pertinencia = pertinencia;
		this.modularidad = modularidad;
		this.reusabilidad = reusabilidad;
		this.analizabilidad = analizabilidad;
		this.capacidad_serModificado = capacidad_serModificado;
		this.capacidad_serProbado = capacidad_serProbado;
	}
		// ATRIBUTOS DEL RANGO DE MEDICIONES. LOS VALORES ESTAN DENTRO DEL SISTEMA.
		// CALCULAR ADECUACION FUNCIONAL
		int completitud; //[0-4]
		int correccion; //[0-5]
		int pertinencia; //[0-5]
		// CALCULAR MANTENIBILIDAD
		int modularidad; //[0-4]
		int reusabilidad; //[0-5]
		int analizabilidad; //[0-5]
		int capacidad_serModificado; //[0-5]
		int capacidad_serProbado; //[0-4]
		
		public int getCompletitud() {
			return completitud;
		}
		public int getCorreccion() {
			return correccion;
		}
		public int getPertinencia() {
			return pertinencia;
		}
		public int getModularidad() {
			return modularidad;
		}
		public int getReusabilidad() {
			return reusabilidad;
		}
		public int getAnalizabilidad() {
			return analizabilidad;
		}
		public int getCapacidad_serModificado() {
			return capacidad_serModificado;
		}
		public int getCapacidad_serProbado() {
			return capacidad_serProbado;
		}
	}

