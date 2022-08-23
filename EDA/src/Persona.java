public class Persona {

	String concierto, tipoEntrada;
	/*********************************************************************
	*
	* Method name: Persona
	* 
	* Description of the Method: CONSTRUCTOR
	*
	*********************************************************************/
	public Persona(String concierto, String tipoEntrada) {
			this.concierto=concierto;
			this.tipoEntrada=tipoEntrada;	
	}
	
	//GETTER
	public String get_concierto() {
		return concierto;
	}

	public String get_tipoEntrada() {
		return tipoEntrada;
	}
	
	//SETTER


	public void set_concierto(String concierto) {
		this.concierto = concierto;
	}
	
	public void set_tipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}
	
	public int setTAtencion(int t) {
		int tiempo = 0;
		// TODO Auto-generated method stub
		if(tipoEntrada=="Platinum")
			tiempo=2;
		if(tipoEntrada=="Gold")
			tiempo=3;
		if(tipoEntrada=="Silver Mar")
			tiempo=4;
		if(tipoEntrada=="Silver Sirena")
			tiempo=4;
		return tiempo;
	}
}

