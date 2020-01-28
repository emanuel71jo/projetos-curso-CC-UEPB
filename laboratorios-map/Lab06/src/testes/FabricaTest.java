package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Fabrica;

class FabricaTest {

	Fabrica fabrica;
	
	@BeforeEach
	public void setUp() {
		fabrica = new Fabrica();
	}
	
	@Test
	public void testAdicionandoQuadrados() {
		fabrica.addQuadrado(40);
		assertEquals(1, fabrica.getQtdQuadrado());
		fabrica.addQuadrado(50);
		fabrica.addQuadrado(50);
		fabrica.addQuadrado(1000);
		assertEquals(4, fabrica.getQtdQuadrado());
	}
	
	@Test
	public void testAreaQuadrado() {
		assertEquals("vazio\n", fabrica.getAreaQuadrados());
		fabrica.addQuadrado(10);
		assertEquals("Area: 20.0\n", fabrica.getAreaQuadrados());
	}
	
	@Test
	public void testPerimetroQuadrado() {
		assertEquals("vazio\n", fabrica.getPerimetroQuadrados());
		fabrica.addQuadrado(10);
		assertEquals("Perimetro: 40.0\n", fabrica.getPerimetroQuadrados());
	}
	
	@Test
	public void testInfoTrianguloEquilatero() {
		assertNull(fabrica.getInfoTrianguloEquilatero());
		fabrica.setTriangulo(10);
		assertEquals("Triangulo Equilatero\nArea: 50.0\nPerimetro: 30.0", fabrica.getInfoTrianguloEquilatero());
	}
	
	@Test
	public void testInfoTrianguloIsosceles() {
		assertNull(fabrica.getInfoTrianguloIsosceles());
		fabrica.setTriangulo(10, 10);
		assertEquals("Triangulo Isosceles\nArea: 50.0\nPerimetro: 30.0", fabrica.getInfoTrianguloIsosceles());
	}
	
	@Test
	public void testInfoTrianguloRetangulo() {
		assertNull(fabrica.getInfoTrianguloRetangulo());
		fabrica.setTriangulo(10, 10, 10);
		assertEquals("Triangulo Retangulo\nArea: 50.0\nPerimetro: 30.0", fabrica.getInfoTrianguloRetangulo());
	}
	
	@Test
	public void testInfoCirculo() {
		assertNull(fabrica.getInfoCirculo());
		fabrica.setCirculo(10);
		assertEquals("Circulo\nArea: 314.0\nPerimetro: 62.800000000000004", fabrica.getInfoCirculo());
	}
	

}




