package adt.avltree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adt.arvoreBinaria.ArvoreVaziaException;
import adt.arvoreBinaria.ExceptionBST;
import adt.arvoreBinaria.NoArvoreBinaria;

public class AVLTest {

	private AVLTree<Integer> avl;
	private NoArvoreBinaria<Integer> NIL = new NoArvoreBinaria<Integer>();

	@BeforeEach
	public void setUp() {
		avl = new AVLTreeImpl<Integer>();
	}

	@Test
	public void testInit() throws ExceptionBST {
		assertTrue(avl.vazio());
		assertEquals(0, avl.tamanho());
		assertEquals(0, avl.altura());
		assertTrue(NIL.equals(avl.getRaiz()));
	}

	@Test
	public void testInsert() throws ExceptionBST {
		avl.inserir(-10);
		assertEquals(1, avl.tamanho());
		assertEquals(0, avl.altura());
		try {
			assertEquals(Arrays.toString(new Integer[] { -10 }), avl.imprimePreOrdem(avl.getRaiz().getChave()));
		} catch (ExceptionBST e2) {
			fail();
		}

		assertFalse(avl.vazio());
		assertEquals(new Integer(-10), avl.getRaiz().getChave());

		avl.inserir(-15);
		assertEquals(2, avl.tamanho());
		assertEquals(1, avl.altura());
		try {
			assertEquals(Arrays.toString(new Integer[] { -10, -15 }), avl.imprimePreOrdem(avl.getRaiz().getChave()));
		} catch (ExceptionBST e1) {
			fail();
		}

		avl.inserir(20);
		assertEquals(3, avl.tamanho());
		assertEquals(1, avl.altura());
		try {
			assertEquals(Arrays.toString(new Integer[] { -10, -15, 20 }), avl.imprimePreOrdem(avl.getRaiz().getChave()));
		} catch (ExceptionBST e) {
			fail();
		}
	}

	@Test
	public void testRemove() throws ExceptionBST, ArvoreVaziaException {
		avl.inserir(55);
		avl.inserir(9);
		avl.inserir(91);
		avl.inserir(12);

		
		try {
			// avl.remover(-1);
			assertEquals(4, avl.tamanho());

			avl.remover(91);
			assertEquals(3, avl.tamanho());
			assertEquals(Arrays.toString(new Integer[] { 12, 9, 55 }), avl.imprimePreOrdem(avl.getRaiz().getChave()));
		} catch (ExceptionBST e) {
			fail();
		}

		
		try {
			avl.remover(12);
			assertEquals(2, avl.tamanho());
			assertEquals(Arrays.toString(new Integer[] { 55, 9 }), avl.imprimePreOrdem(avl.getRaiz().getChave()));
			avl.remover(9);
			avl.remover(55);
		} catch (ExceptionBST e) {
			fail();
		}

		
		assertEquals(NIL, avl.getRaiz());
		assertTrue(avl.vazio());
	}
}

