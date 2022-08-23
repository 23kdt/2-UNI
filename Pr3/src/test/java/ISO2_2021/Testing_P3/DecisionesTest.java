package ISO2_2021.Testing_P3;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value=Parameterized.class)
public class DecisionesTest {
	
	@Parameters
	public static Iterable<Object[]> eachuse(){
		return Arrays.asList(new Object[][] {
			
			// (valor<0 or valor>100) 
			{-1,80,80,80,80,80,80,80,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
			{101,80,80,80,80,80,80,80,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
			{20,99,99,99,99,99,99,99,"No obtiene certificado. Nivel de calidad: 1"}, //F
			// (valor<10) 
			{5,80,80,80,80,80,80,80,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
			{11,80,80,80,80,80,80,80,"No obtiene certificado. Nivel de calidad: 1"}, //F
			//(valor>=10 and valor <35) 
			{0,45,89,48,49,98,99,99,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"}, //F
			{36,20,20,20,20,20,20,20,"No obtiene certificado. Nivel de calidad: 1"},//F
			{20,20,20,20,20,20,20,20,"No obtiene certificado. Nivel de calidad: 1"},
			//(valor >= 35 and valor <50) 
			{30,36,36,36,35,35,35,35,"No obtiene certificado. Nivel de calidad: 1"},//F, (30<35)
			{55,45,45,45,45,45,45,45,"No obtiene certificado. Nivel de calidad: 2"},//F  (55>50)
			{40,40,40,40,40,40,40,40,"No obtiene certificado. Nivel de calidad: 2"},
			//(valor >= 50 and valor<70)
			{45,55,55,55,55,55,55,55,"No obtiene certificado. Nivel de calidad: 2"},// (45<50)
			{75,55,55,55,55,55,55,55,"Obtiene certificado de calidad con un nivel de 3"},
			{55,55,55,55,55,55,55,55,"Obtiene certificado de calidad con un nivel de 3"},
			//(valor >= 70 && valor <90)
			{65,75,75,75,75,75,75,75,"Obtiene certificado de calidad con un nivel de 3"},// (65<70)
			{95,75,75,75,75,75,75,75,"Obtiene certificado de calidad con un nivel de 3"},
			{75,75,75,75,75,75,75,75,"Obtiene certificado de calidad con un nivel de 3"},
			//(nivel < 3)
			{57,90,87,55,86,78,99,15,"No obtiene certificado. Nivel de calidad: 2"}, //F
			{99,99,99,55,99,99,99,99,"Obtiene certificado de calidad con un nivel de 4"},
			{99,99,99,99,99,99,99,99,"Obtiene certificado de calidad con un nivel de 5"}
			
		});
	}
	
	//
	int completitud;
	int correccion;
	int pertinencia;
	int modularidad;
	int reusabilidad;
	int analizabilidad;
	int c_mod;
	int c_prob;

	//valor esperado
	
	String esperado;
	
	public DecisionesTest(int completitud, int correccion, int pertinencia, int modularidad, int reusabilidad, int analizabilidad, int c_mod, int c_prob, String esperado) {
		
		this.completitud = completitud;
		this.correccion = correccion;
		this.pertinencia = pertinencia;
		this.modularidad = modularidad;
		this.reusabilidad = reusabilidad;
		this.analizabilidad = analizabilidad;
		this.c_mod = c_mod;
		this.c_prob = c_prob;
		this.esperado = esperado;
	}

	@Test
	public void testing() {
		Caso caso = new Caso();
		String result= caso.funcionamiento(completitud, correccion, pertinencia, modularidad, reusabilidad, analizabilidad, c_mod, c_prob);
		assertEquals(esperado, result);
		
	}
}