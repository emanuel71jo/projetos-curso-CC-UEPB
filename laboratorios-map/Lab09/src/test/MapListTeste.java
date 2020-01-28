package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.ListIF;
import classes.MapList;

class MapListTeste {

	ListIF lista;
	ListIF lista2;
	ListIF lista3;
	
	@BeforeEach
	public void setUp() throws Exception {
		lista = new MapList();
		lista2 = new MapList();
		lista3 = new MapList();

		lista2.add(0, 2);
		lista2.add(1, 3);
		
		int cont = 0;
		for (int i = 17; i >= 0; i--) {
			lista.add(cont, i);
			lista3.add(cont, i);
			cont++;
		}
	}

	@Test
	public void AddTest() {
		assertTrue(lista2.contains(2));
		assertEquals(2, lista2.size());
		
		assertTrue(lista.contains(17));
		assertEquals(18, lista.size());
		
	}

	@Test
	public void ContainsTest() {
		assertTrue(lista2.contains(2));
		assertFalse(lista2.contains(5));
		
		assertTrue(lista.contains(17));
		assertFalse(lista.contains(20));
		
	}
	
	@Test
	public void EqualsTest() {
		assertFalse(lista.equals(lista2));
	}
	
	@Test
	public void GetTest() {
		assertEquals(2, lista2.get(0));
		assertEquals(3, lista2.get(1));
		
		assertEquals(17, lista.get(0));
		assertNotEquals(2, lista.get(0));
		
	}
	
	@Test
	public void IsEmptyTest() {
		assertEquals(18, lista3.size());
		lista3.clear();
		assertTrue(lista3.isEmpty());
		assertEquals(0, lista3.size());

	}
	
	@Test
	public void RemoveTest(){
		assertTrue(lista.remove(0));
		assertFalse(lista.remove(20));

		assertEquals(17, lista.size());
	}
	
	@Test
	public void SizeTest() {
		lista.remove(11);
		lista3.clear();
		assertEquals(17, lista.size());
		assertEquals(0, lista3.size());
		assertEquals(2, lista2.size());

	}
	
	
	@Test
	public void ClearTest() {
		lista.clear();
		lista3.clear();
		lista2.clear();
		assertEquals(0, lista.size());
		assertEquals(0, lista3.size());
		assertEquals(0, lista2.size());

	}

}
