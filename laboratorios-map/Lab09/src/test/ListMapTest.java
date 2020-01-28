package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.ListMap;
import classes.MapIF;

class ListMapTest {

	MapIF mapa;
	MapIF mapa2;
	MapIF mapa3;
	
	@BeforeEach
	public void setUp() throws Exception {
		mapa = new ListMap();
		mapa2 = new ListMap();
		mapa3 = new ListMap();

		mapa2.put(0, 2);
		mapa2.put(1, 3);
		
		int cont = 0;
		for (int i = 17; i >= 0; i--) {
			mapa.put(cont, i);
			mapa3.put(cont, i);
			cont++;
		}
	}

	@Test
	public void PutTeste() {
		assertTrue(mapa2.containsValue(2));
		assertEquals(2, mapa2.size());
		
		assertTrue(mapa.containsValue(17));
		assertEquals(18, mapa.size());
		
	}

	@Test
	public void ContainsTest() {
		assertTrue(mapa2.containsValue(2));
		assertFalse(mapa2.containsValue(5));
		
		assertTrue(mapa.containsValue(17));
		assertFalse(mapa.containsValue(20));
		
	}
	
	@Test
	public void EqualsTest() {
		assertFalse(mapa.equals(mapa2));
	}
	
	@Test
	public void GetTest() {
		assertEquals(2, mapa2.get(0));
		assertEquals(3, mapa2.get(1));
		
		assertEquals(17, mapa.get(0));
		assertNotEquals(2, mapa.get(0));
		
	}
	
	@Test
	public void IsEmptyTest() {
		assertEquals(18, mapa3.size());
		mapa3.clear();
		assertTrue(mapa3.isEmpty());
		assertEquals(0, mapa3.size());

	}
	
	@Test
	public void RemoveTest(){
		assertTrue(mapa.remove(0));
		assertFalse(mapa.remove(20));

		assertEquals(17, mapa.size());
	}
	
	@Test
	public void SizeTest() {
		mapa.remove(11);
		mapa3.clear();
		assertEquals(17, mapa.size());
		assertEquals(0, mapa3.size());
		assertEquals(2, mapa2.size());

	}
	
	
	@Test
	public void ClearTest() {
		mapa.clear();
		mapa3.clear();
		mapa2.clear();
		assertEquals(0, mapa.size());
		assertEquals(0, mapa3.size());
		assertEquals(0, mapa2.size());

	}
}
