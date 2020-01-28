package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import classes.Circulo;
import classes.FiguraGeometrica;
import classes.Quadrado;
import classes.Retangulo;

class testFiguraGeometrica {
	FiguraGeometrica figura;

	
	@Test
	public void testAreaRetangulo() throws Exception {
		figura = new Retangulo(10, 10);
		assertEquals(100, figura.area());
		assertNotEquals(1, figura.area());
		
		figura = new Retangulo(1, 5);
		assertEquals(5, figura.area());
		assertNotEquals(10, figura.area());
		
		figura = new Retangulo(0, 10);
		assertThrows(Exception.class, () -> {
			figura.area();
		});
		
		figura = new Retangulo(10, -5);
		assertThrows(Exception.class, () -> {
			figura.area();
		});
	}
	
	@Test
	public void testPerimetroRetangulo() throws Exception {
		figura = new Retangulo(10, 10);
		assertEquals(40, figura.perimetro());
		assertNotEquals(1, figura.perimetro());
		
		figura = new Retangulo(1, 5);
		assertEquals(12, figura.perimetro());
		assertNotEquals(10, figura.perimetro());
		
		figura = new Retangulo(0, 10);
		assertThrows(Exception.class, () -> {
			figura.perimetro();
		});
		
		figura = new Retangulo(10, -5);
		assertThrows(Exception.class, () -> {
			figura.perimetro();
		});
	}
	
	@Test
	public void testAreaCirculo() throws Exception {
		figura = new Circulo(5);
		assertEquals(11, figura.area());
		assertNotEquals(1, figura.area());
		
		figura = new Circulo(1);
		assertEquals(7, figura.area());
		assertNotEquals(10, figura.area());
		
		figura = new Circulo(0);
		assertThrows(Exception.class, () -> {
			figura.area();
		});
		
		figura = new Circulo(-5);
		assertThrows(Exception.class, () -> {
			figura.area();
		});
	}
	
	@Test
	public void testPerimetroCirculo() throws Exception {
		figura = new Circulo(5);
		assertEquals(15, figura.perimetro());
		assertNotEquals(1, figura.perimetro());
		
		figura = new Circulo(1);
		assertEquals(3, figura.perimetro());
		assertNotEquals(10, figura.perimetro());
		
		figura = new Circulo(0);
		assertThrows(Exception.class, () -> {
			figura.perimetro();
		});
		
		figura = new Circulo(-5);
		assertThrows(Exception.class, () -> {
			figura.perimetro();
		});
	}
	
	@Test
	public void testAreaQuadrado() throws Exception {
		figura = new Quadrado(5);
		assertEquals(25, figura.area());
		assertNotEquals(1, figura.area());
		
		figura = new Quadrado(1);
		assertEquals(1, figura.area());
		assertNotEquals(10, figura.area());
		
		figura = new Quadrado(0);
		assertThrows(Exception.class, () -> {
			figura.area();
		});
		
		figura = new Quadrado(-5);
		assertThrows(Exception.class, () -> {
			figura.area();
		});
	}
	
	@Test
	public void testPerimetrQuadrado() throws Exception {
		figura = new Quadrado(5);
		assertEquals(20, figura.perimetro());
		assertNotEquals(1, figura.perimetro());
		
		figura = new Quadrado(1);
		assertEquals(4, figura.perimetro());
		assertNotEquals(10, figura.perimetro());
		
		figura = new Quadrado(0);
		assertThrows(Exception.class, () -> {
			figura.perimetro();
		});
		
		figura = new Quadrado(-5);
		assertThrows(Exception.class, () -> {
			figura.perimetro();
		});
	}
	
	
}
