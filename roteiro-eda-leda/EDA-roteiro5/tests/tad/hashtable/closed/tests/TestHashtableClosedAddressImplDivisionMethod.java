package tad.hashtable.closed.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tad.hashFunction.HashFunctionClosedAddressMethod;
import tad.hashtable.closed.AbstractHashtableClosedAddress;
import tad.hashtable.closed.HashtableClosedAddressImpl;

public class TestHashtableClosedAddressImplDivisionMethod {
	
	private static final int PROPOSED_SIZE = 200;
	protected AbstractHashtableClosedAddress<Integer> table1 = null;
	protected AbstractHashtableClosedAddress<Integer> table2 = null;
	ArrayList<Integer> elementsData = new ArrayList<Integer>(PROPOSED_SIZE);

	@BeforeEach
	void setUp() throws Exception {
		table1 = new HashtableClosedAddressImpl<Integer>(PROPOSED_SIZE, 
				HashFunctionClosedAddressMethod.DIVISION);
		
		for (int currentKey = 200; currentKey < 600; currentKey = currentKey + 5) {
			table1.insert(currentKey);
			elementsData.add(currentKey);
		}
		
		table2 = new HashtableClosedAddressImpl<Integer>(PROPOSED_SIZE,
				HashFunctionClosedAddressMethod.DIVISION);
		
		System.out.println("HashtableClosedAddressImplDivisionMethodTest.setUp() - collinsion factor: " + table1.getCOLLISIONS());
	}
	
	@Test
	public void testInsert() {
		assertEquals(0, table1.getCOLLISIONS());
		table1.insert(105); // nao produz colisao
		assertEquals(0, table1.getCOLLISIONS());
		assertEquals(105, table1.indexOf(105));
		table1.insert(110); // nao produz colisao
		assertEquals(0, table1.getCOLLISIONS());
		assertEquals(110, table1.indexOf(110));
		table1.insert(101); // produz colisao no 0
		assertEquals(1, table1.getCOLLISIONS());
		assertEquals(0, table1.indexOf(101));

		table2.insert(103); // nao produz colisao inserindo 1 elemento na talbe
							// vazia
		assertEquals(0, table2.getCOLLISIONS());
		assertEquals(2, table2.indexOf(103));
	}
	
	@Test
	public void testSearch() {
		// busca um elemento inexistente. compara a posicao
		assertNull(table1.search(100));
		assertEquals(-1, table1.indexOf(100));

		// busca um elemento existente. compara a posicao
		assertEquals(new Integer(305), table1.search(305));
		assertEquals(2, table1.indexOf(305));
	}

	/**
     * This test looks up all elements of the hash table by searching
     * for their keys.  When found, the element is confirmed to be non-null
     * and to have the correct data.
     */
    @Test
    public void testBatchSearch() {
        for (Integer element : elementsData) {
        	Integer searchedElement = table1.search(element);
            assertNotNull(searchedElement);
            assertEquals(searchedElement,(element));
        }
    }

    @Test
	public void testRemove2() {
		int currentSize = table1.size();
		table1.remove(200); // elemento existente
		assertEquals(currentSize - 1, table1.size());
		assertEquals(-1, table1.indexOf(200));
	}

	@Test
	public void testIsEmpty() {
		assertFalse(table1.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(table1.isFull());
	}

	@Test
	public void testSize() {
		assertEquals(80, table1.size());
	}

}
