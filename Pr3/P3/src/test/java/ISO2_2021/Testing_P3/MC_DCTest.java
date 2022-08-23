package ISO2_2021.Testing_P3;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value=Parameterized.class)
public class MC_DCTest {
	
	@Parameters
	public static Iterable<Object[]> eachuse(){
		return Arrays.asList(new Object[][] {
			
			// (v_adec < 1 or v_mant<1)
			{99,99,99,99,99,99,99,99,"Obtiene certificado de calidad con un nivel de 5"}, //F
			{99,99,99,9,99,99,99,99,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
			{9,99,99,99,99,99,99,99,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
			{1,99,99,1,99,99,99,99,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
			// (valor <10) --> Rango 0 
			{5,80,80,80,80,80,80,80,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
			{80,80,80,5,80,80,80,80,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
			{5,80,80,5,80,80,80,80,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
			// (valor>=10 && valor <35) --> Adecuación o mantenibilidad Rango 1
			{20,99,99,99,99,99,99,99,"No obtiene certificado. Nivel de calidad: 1"},
			{99,99,99,20,99,99,99,99,"Obtiene certificado de calidad con un nivel de 3"},
			// (valor >= 35 and valor <50) --> Adecuación o mantenibilidad Rango 2
			{37,99,99,99,99,99,99,99,"No obtiene certificado. Nivel de calidad: 2"},
			{99,99,99,99,37,99,99,99,"Obtiene certificado de calidad con un nivel de 3"},
			// (valor >= 50 and valor<70)  --> Adecuación o mantenibilidad Rango 3
			{55,99,99,99,99,99,99,99,"Obtiene certificado de calidad con un nivel de 3"},
			{99,99,99,55,99,99,99,99,"Obtiene certificado de calidad con un nivel de 4"},
			// (valor >= 70 && valor <90) --> Adecuación o mantenibilidad Rango 4
			{75,99,99,99,99,99,99,99,"Obtiene certificado de calidad con un nivel de 4"},
			{99,99,99,75,99,99,99,99,"Obtiene certificado de calidad con un nivel de 4"},
			// (valor >= 70 && valor <90) --> Adecuación o mantenibilidad Rango 5
			{99,90,90,90,90,90,90,90,"Obtiene certificado de calidad con un nivel de 5"},
			{70,19,14,90,97,99,95,94, "No obtiene certificado. Nivel de calidad: 1"},
			//(valor <0 or valor > 100)
			{-1,99,99,99,99,99,99,99,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
			{105,59,59,65,48,98,80,99,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
			//(nivel <3)
			{37,99,99,99,99,99,99,99,"No obtiene certificado. Nivel de calidad: 2"},
			{75,99,99,99,99,99,99,99,"Obtiene certificado de calidad con un nivel de 4"} //F
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
	
	public MC_DCTest(int completitud, int correccion, int pertinencia, int modularidad, int reusabilidad, int analizabilidad, int c_mod, int c_prob, String esperado) {
		
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