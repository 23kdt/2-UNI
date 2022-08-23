package ISO2_2021.Testing_P3;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


	@RunWith(value= Parameterized.class)
	public class EachUseTest {
		
		@Parameters
		public static Iterable<Object[]> eachuse(){
			return Arrays.asList(new Object[][] {
				
				{0,0,0,0,0,0,0,0,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
				{1,99,99,99,99,99,99,99,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
				{10,50,50,50,10,50,50,50,"No obtiene certificado. Nivel de calidad: 1"},
				{10,99,99,99,10,99,99,99,"No obtiene certificado. Nivel de calidad: 1"},
				{35,35,35,35,35,35,35,35,"No obtiene certificado. Nivel de calidad: 2"},
				{35,99,99,99,99,35,99,99,"No obtiene certificado. Nivel de calidad: 2"},
				{50,50,50,50,50,50,50,50,"Obtiene certificado de calidad con un nivel de 3"},
				{50,99,99,50,99,99,99,99,"Obtiene certificado de calidad con un nivel de 3"},
				{70,70,70,90,90,90,90,90,"Obtiene certificado de calidad con un nivel de 4"},
				{70,99,99,99,99,99,99,99,"Obtiene certificado de calidad con un nivel de 4"},
				{90,90,90,90,90,90,90,90,"Obtiene certificado de calidad con un nivel de 5"},
				{100,100,100,100,100,100,100,100,"Obtiene certificado de calidad con un nivel de 5"},
				{-1,-1,-1,-1,-1,-1,-1,-1,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"},
				{101,101,101,101,101,101,101,101,"No cumple alguno de los requisitos para acceder a la prueba de certificado. Valores de adecuación o mantenimiento iguales a 0 o atributos>100 / atributes<0"}
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
		
		public EachUseTest(int completitud, int correccion, int pertinencia, int modularidad, int reusabilidad, int analizabilidad, int c_mod, int c_prob, String esperado) {
			
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
