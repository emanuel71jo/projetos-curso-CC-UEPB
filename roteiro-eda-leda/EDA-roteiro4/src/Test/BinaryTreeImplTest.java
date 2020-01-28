package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.EmptyBinaryTreeException;
import Exceptions.NodeNotFoundException;
import roteiro4.BinaryTreeImpl;
import roteiro4.NodoBinaryTree;

class BinaryTreeImplTest {

	BinaryTreeImpl<Integer> binaryTree = null;
	NodoBinaryTree<Integer> nodo1 = null, nodo2 = null, 
			nodo3 = null, nodo4 = null, nodo5 = null, nodo6 = null;
	
	@BeforeEach
	public void setUp() {
		this.binaryTree = new BinaryTreeImpl<Integer>();
		this.nodo1 = new NodoBinaryTree<Integer>(new Integer(5));
		this.nodo2 = new NodoBinaryTree<Integer>(new Integer(15));
		this.nodo3 = new NodoBinaryTree<Integer>(new Integer(14));
		this.nodo4 = new NodoBinaryTree<Integer>(new Integer(7));
		this.nodo5 = new NodoBinaryTree<Integer>(new Integer(1));
		this.nodo6 = new NodoBinaryTree<Integer>(new Integer(10));
		
	}
	
	@Test
	public void testInsertCaso1() {
		this.binaryTree.insert(this.nodo1);
		this.binaryTree.insert(this.nodo3);
		this.binaryTree.insert(this.nodo6);
		
		assertEquals(this.nodo1, this.binaryTree.search(new Integer(5)));
		assertEquals(this.nodo3, this.binaryTree.search(new Integer(14)));
		assertEquals(this.nodo6, this.binaryTree.search(new Integer(10)));
		
		assertNotEquals(this.nodo2, this.binaryTree.search(new Integer(14)));
		assertNotEquals(this.nodo1, this.binaryTree.search(new Integer(14)));
		assertNotEquals(this.nodo4, this.binaryTree.search(new Integer(10)));
		assertNotEquals(this.nodo6, this.binaryTree.search(new Integer(1)));
		assertNotEquals(this.nodo5, this.binaryTree.search(new Integer(7)));
		
	}
	
	@Test
	public void testSearchCaso2() {
		
		assertNull(this.binaryTree.getRoot());
		
		assertThrows(EmptyBinaryTreeException.class, () -> {
			this.binaryTree.search(new Integer(10));
		});
		
		this.binaryTree.insert(this.nodo1);
		this.binaryTree.insert(this.nodo3);
		this.binaryTree.insert(this.nodo6);
		
		assertEquals(this.nodo1, this.binaryTree.search(new Integer(5)));
		assertEquals(this.nodo3, this.binaryTree.search(new Integer(14)));
		assertEquals(this.nodo6, this.binaryTree.search(new Integer(10)));
		
		assertNotEquals(this.nodo2, this.binaryTree.search(new Integer(14)));
		assertNotEquals(this.nodo1, this.binaryTree.search(new Integer(14)));
		assertNotEquals(this.nodo4, this.binaryTree.search(new Integer(10)));
		assertNotEquals(this.nodo6, this.binaryTree.search(new Integer(1)));
		assertNotEquals(this.nodo5, this.binaryTree.search(new Integer(7)));

		
		assertThrows(NodeNotFoundException.class, () -> {
			this.binaryTree.search(new Integer(5));
			this.binaryTree.search(new Integer(14));
			this.binaryTree.search(new Integer(10));
			this.binaryTree.search(new Integer(50));
		});
		
	}
	
	@Test
	public void testRemoveCaso3() {
		
		assertNull(this.binaryTree.getRoot());
		
		assertThrows(EmptyBinaryTreeException.class, () -> {
			this.binaryTree.remove(new Integer(10));
		});
		
		this.binaryTree.insert(this.nodo2);
		this.binaryTree.insert(this.nodo5);
		this.binaryTree.insert(this.nodo6);
		
		assertEquals(this.nodo2, this.binaryTree.remove(new Integer(15)));
		assertEquals(this.nodo5, this.binaryTree.remove(new Integer(1)));
		assertEquals(this.nodo6, this.binaryTree.remove(new Integer(10)));
		
		assertThrows(EmptyBinaryTreeException.class, () -> {
			this.binaryTree.remove(new Integer(10));
		});

		this.binaryTree.insert(this.nodo1);
		this.binaryTree.insert(this.nodo4);
		this.binaryTree.insert(this.nodo3);

		
		assertThrows(NodeNotFoundException.class, () -> {
			this.binaryTree.remove(new Integer(5));
			this.binaryTree.remove(new Integer(7));
			this.binaryTree.remove(new Integer(14));
			this.binaryTree.remove(new Integer(50));
		});	
		
	}
	
	@Test
	public void testSuccessorCaso4() {
		assertNull(this.binaryTree.getRoot());
		this.binaryTree.insert(this.nodo2);
		this.binaryTree.insert(this.nodo5);
		this.binaryTree.insert(this.nodo6);
		this.binaryTree.insert(this.nodo1);
		this.binaryTree.insert(this.nodo4);
		this.binaryTree.insert(this.nodo3);
		
		assertEquals(this.nodo3, this.binaryTree.successor(new Integer(10)));
		assertEquals(this.nodo6, this.binaryTree.successor(new Integer(1)));
		assertEquals(this.nodo4, this.binaryTree.successor(new Integer(5)));
		
	}
	
	@Test
	public void testPredecessorCaso5() {
		
		assertNull(this.binaryTree.getRoot());
		this.binaryTree.insert(this.nodo2);
		this.binaryTree.insert(this.nodo5);
		this.binaryTree.insert(this.nodo6);
		this.binaryTree.insert(this.nodo1);
		this.binaryTree.insert(this.nodo4);
		this.binaryTree.insert(this.nodo3);
		
		assertEquals(this.nodo5, this.binaryTree.predecessor(new Integer(15)));
		assertEquals(this.nodo1, this.binaryTree.predecessor(new Integer(10)));
	}
	
	@Test
	public void testPrintInOrderCaso6() {
		
		assertNull(this.binaryTree.getRoot());
		this.binaryTree.insert(this.nodo2);
		this.binaryTree.insert(this.nodo5);
		this.binaryTree.insert(this.nodo6);
		this.binaryTree.insert(this.nodo1);
		this.binaryTree.insert(this.nodo4);
		this.binaryTree.insert(this.nodo3);
		
		assertEquals("1, 5, 7, 10, 14, 15", this.binaryTree.printInOrder(new Integer(15)));
		assertEquals("1, 5, 7, 10, 14", this.binaryTree.printInOrder(new Integer(1)));
		assertEquals("5, 7, 10, 14", this.binaryTree.printInOrder(new Integer(10)));
		assertEquals("5, 7", this.binaryTree.printInOrder(new Integer(5)));
		
	}
	
	@Test
	public void testPrintPreOrderCaso7() {
		
		assertNull(this.binaryTree.getRoot());
		this.binaryTree.insert(this.nodo2);
		this.binaryTree.insert(this.nodo5);
		this.binaryTree.insert(this.nodo6);
		this.binaryTree.insert(this.nodo1);
		this.binaryTree.insert(this.nodo4);
		this.binaryTree.insert(this.nodo3);
		
		assertEquals("15, 1, 10, 5, 7, 14", this.binaryTree.printPreOrder(new Integer(15)));
		assertEquals("1, 10, 5, 7, 14", this.binaryTree.printPreOrder(new Integer(1)));
		assertEquals("10, 5, 7, 14", this.binaryTree.printPreOrder(new Integer(10)));
		assertEquals("5, 7", this.binaryTree.printPreOrder(new Integer(5)));
		
	}
	
	@Test
	public void testPrintPostOrderCaso8() {
		
		assertNull(this.binaryTree.getRoot());
		this.binaryTree.insert(this.nodo2);
		this.binaryTree.insert(this.nodo5);
		this.binaryTree.insert(this.nodo6);
		this.binaryTree.insert(this.nodo1);
		this.binaryTree.insert(this.nodo4);
		this.binaryTree.insert(this.nodo3);
		
		assertEquals("7, 5, 14, 10, 1, 15", this.binaryTree.printPostOrder(new Integer(15)));
		assertEquals("7, 5, 14, 10, 1", this.binaryTree.printPostOrder(new Integer(1)));
		assertEquals("7, 5, 14, 10", this.binaryTree.printPostOrder(new Integer(10)));
		assertEquals("7, 5", this.binaryTree.printPostOrder(new Integer(5)));
		
	}
	
	@Test
	public void testPrintSortedValuesCaso9() {
		
		assertNull(this.binaryTree.getRoot());
		this.binaryTree.insert(this.nodo2);
		this.binaryTree.insert(this.nodo5);
		this.binaryTree.insert(this.nodo6);
		this.binaryTree.insert(this.nodo1);
		this.binaryTree.insert(this.nodo4);
		this.binaryTree.insert(this.nodo3);
		
		assertEquals("1, 5, 7, 10, 14, 15", this.binaryTree.printPostOrder(new Integer(15)));
		assertEquals("1, 5, 7, 10, 14", this.binaryTree.printPostOrder(new Integer(1)));
		assertEquals("5, 7, 10, 14", this.binaryTree.printPostOrder(new Integer(10)));
		assertEquals("5, 7", this.binaryTree.printPostOrder(new Integer(5)));
		
	}
	
	
	

}
