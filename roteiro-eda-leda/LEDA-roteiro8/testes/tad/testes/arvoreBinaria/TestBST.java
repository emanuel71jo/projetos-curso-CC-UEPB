package tad.testes.arvoreBinaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tad.arvoreBinaria.ArvoreBinariaImpl;
import tad.arvoreBinaria.ArvoreBinaria_IF;
import tad.arvoreBinaria.ArvoreVaziaException;
import tad.arvoreBinaria.ExceptionBST;
import tad.arvoreBinaria.NoArvoreBinaria;

class TestBST {

	ArvoreBinariaImpl<Integer> bst = null;
	Integer[] arrayAux = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };
	
	@BeforeEach
	public void setUp() {
		bst = new ArvoreBinariaImpl<>();
	}

	//M�todo auxilar para os testes
	public void insereElementosNaBST(Integer[] array) throws ExceptionBST {
		for (int i = 0; i < array.length; i++) {
			bst.inserir(array[i]);
		}
	}

	@Test //Testa se inser��es est�o sendo feitas na BST
	public void testInserir() throws ExceptionBST {
		insereElementosNaBST(arrayAux);
		assertEquals(new Integer(8), bst.buscar(new Integer(8)).getChave());
		assertEquals(new Integer(12), bst.buscar(new Integer(12)).getChave());
		assertEquals(new Integer(6), bst.buscar(new Integer(6)).getChave());
		assertEquals(new Integer(1), bst.buscar(new Integer(1)).getChave());
		bst.inserir(16);
		bst.inserir(17);
		assertEquals(new Integer(16), bst.buscar(new Integer(16)).getChave());
		assertEquals(new Integer(17), bst.buscar(new Integer(17)).getChave());
	}
	
	@Test //Testando a estrutura do NodeBST
	public void testNodeBST() throws ExceptionBST {
		insereElementosNaBST(arrayAux);
		NoArvoreBinaria<Integer> node = bst.buscar(new Integer(12));
		assertEquals(new Integer(8), node.getPai().getChave());
		assertEquals(new Integer(10), node.getFilhoEsquerdo().getChave());
		assertEquals(new Integer(14), node.getFilhoDireito().getChave());
	}

	@Test //Testa casos de sucessos na busca
	public void testBuscar1() throws ExceptionBST {
		insereElementosNaBST(arrayAux);
		assertEquals(new Integer(8), bst.buscar(new Integer(8)).getChave());
		assertEquals(new Integer(15), bst.buscar(new Integer(15)).getChave());
		assertEquals(new Integer(2), bst.buscar(new Integer(2)).getChave());
		assertEquals(new Integer(10), bst.buscar(new Integer(10)).getChave());
		
		bst.inserir(new Integer(16));
		assertEquals(new Integer(16), bst.buscar(new Integer(16)).getChave());
	}
	
	@Test //Testa casos de falhas na busca
	public void testBuscar2() throws ExceptionBST {
		insereElementosNaBST(arrayAux);
		assertThrows(ExceptionBST.class, () -> bst.buscar(16)); //busca elemento n�o contido na bst
		bst = new ArvoreBinariaImpl<>();
		assertThrows(ExceptionBST.class, () -> bst.buscar(8)); //busca elemento com a bst vazia
	}
	
	@Test //Tenta remover um elemento de uma BST vazia
	public void testRemoverBSTVazia() {
		bst = new ArvoreBinariaImpl<>();
		assertThrows(ExceptionBST.class, () -> bst.remover(8));
		assertThrows(ExceptionBST.class, () -> bst.remover(9));
	}
	
	@Test //Tenta remover um elemento que n�o existe na BST
	public void testRemoverElementoNaoExistente() throws ExceptionBST {
		insereElementosNaBST(arrayAux);
		assertThrows(ExceptionBST.class, () -> bst.remover(16));
		assertThrows(ExceptionBST.class, () -> bst.remover(17));
	}
	
	@Test //Remove n� folha
	public void testRemoverFolha() throws ExceptionBST, ArvoreVaziaException{
		insereElementosNaBST(new Integer[] {15, 23, 6, 7, 4, 5, 71, 50});
		assertEquals(new Integer(7), bst.remover(7).getChave());
		Integer[] emOrdem = {4, 5, 6, 15, 23, 50, 71};
		assertTrue(Arrays.toString(emOrdem).equals(bst.imprimeEmOrdem(15)));
	}
	
	@Test //Remove n� com filho esquerdo
	public void testRemoveNoComFilhoEsquerdo() throws ExceptionBST, ArvoreVaziaException {
		insereElementosNaBST(new Integer[] {15, 23, 6, 4, 5, 20, 21});
		assertEquals(new Integer(6), bst.remover(6).getChave());
		Integer[] emOrdem = {4, 5, 15, 20, 21, 23};
		assertTrue(Arrays.toString(emOrdem).equals(bst.imprimeEmOrdem(15)));
	}
	
	@Test //Remove n� com filho direito
	public void testRemoveNoComFilhoDireito() throws ExceptionBST, ArvoreVaziaException {
		insereElementosNaBST(new Integer[] {15, 10, 20, 8, 9, 25, 22, 30});
		assertEquals(new Integer(20), bst.remover(20).getChave());
		Integer[] emOrdem = {8, 9, 10, 15, 22, 25, 30};
		assertTrue(Arrays.toString(emOrdem).equals(bst.imprimeEmOrdem(15)));
	}
	
	@Test //Remove n� com dois filhos
	public void testRemoveNoComDoisFilhos() throws ExceptionBST, ArvoreVaziaException {
		insereElementosNaBST(new Integer[] {15, 23, 6, 7, 4, 5, 71, 50});
		assertEquals(new Integer(6), bst.remover(6).getChave());
		Integer[] emOrdem = {4, 5, 7, 15, 23, 50, 71};
		assertTrue(Arrays.toString(emOrdem).equals(bst.imprimeEmOrdem(15)));
	}
	
	@Test //Testa casos de sucesso para busca do sucessor
	public void testSucessor1() throws ExceptionBST, ArvoreVaziaException {
		insereElementosNaBST(arrayAux);
		assertEquals(new Integer(3), bst.sucessor(2).getChave());
		assertEquals(new Integer(13), bst.sucessor(12).getChave());
		assertEquals(new Integer(9), bst.sucessor(8).getChave());
	}
	
	@Test //Testa casos de falha para busca do sucessor
	public void testSucessor2() throws ExceptionBST, ArvoreVaziaException {
		insereElementosNaBST(arrayAux);
		assertThrows(ExceptionBST.class, () -> bst.sucessor(16)); //busca sucessor de elemento inexistente
		assertNull(bst.sucessor(9)); //n�o tem sucessor
		
		bst = new ArvoreBinariaImpl<>();
		assertThrows(Exception.class, () -> bst.sucessor(8)); //busca sucessor em �rvove vazia
	}
	
	@Test //Testa casos de sucesso para busca do predecessor
	public void testPredecessor1() throws ExceptionBST, ArvoreVaziaException {
		insereElementosNaBST(arrayAux);
		assertEquals(new Integer(1), bst.predecessor(2).getChave());
		assertEquals(new Integer(11), bst.predecessor(12).getChave());
		assertEquals(new Integer(7), bst.predecessor(8).getChave());
	}
	
	@Test //Testa casos de falha para busca do predecessor
	public void testPredecessor2() throws ExceptionBST, ArvoreVaziaException {
		insereElementosNaBST(arrayAux);
		assertThrows(ExceptionBST.class, () -> bst.predecessor(16)); //busca predecessor de elemento inexistente
		assertNull(bst.predecessor(9)); //n�o tem predecessor
		
		bst = new ArvoreBinariaImpl<>();
		assertThrows(Exception.class, () -> bst.predecessor(8)); //busca predecessor em �rvove vazia
	}

	@Test //testa impress�o em ordem e casos de falhas
	public void testImprimeEmOrdem() throws ExceptionBST {
		insereElementosNaBST(arrayAux);
		Integer[] emOrdem = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		assertTrue(Arrays.toString(emOrdem).equals(bst.imprimeEmOrdem(8)));
		
		Integer[] emOrdem2 = {9, 10, 11, 12, 13, 14, 15};
		assertTrue(Arrays.toString(emOrdem2).equals(bst.imprimeEmOrdem(12)));
		
		assertTrue("[9]".equals(bst.imprimeEmOrdem(9)));
		
		assertThrows(ExceptionBST.class, () -> bst.imprimeEmOrdem(16)); //elemento inexistente
		
		bst = new ArvoreBinariaImpl<>();
		assertThrows(ExceptionBST.class, () -> bst.imprimeEmOrdem(8)); // BST vazia
	}
	
	@Test //testa impress�o pr� ordem e casos de falhas
	public void testImprimePreOrdem() throws ExceptionBST {
		insereElementosNaBST(arrayAux);
		Integer[] preOrdem = { 8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15 };
		assertTrue(Arrays.toString(preOrdem).equals(bst.imprimePreOrdem(8)));

		Integer[] preOrdem2 = { 12, 10, 9, 11, 14, 13, 15 };
		assertTrue(Arrays.toString(preOrdem2).equals(bst.imprimePreOrdem(12)));

		assertTrue("[9]".equals(bst.imprimePreOrdem(9)));

		assertThrows(ExceptionBST.class, () -> bst.imprimePreOrdem(16)); // elemento inexistente

		bst = new ArvoreBinariaImpl<>();
		assertThrows(ExceptionBST.class, () -> bst.imprimePreOrdem(8)); // BST vazia
	}
	
	@Test //testa impress�o p�s ordem e casos de falhas
	public void testImprimePosOrdem() throws ExceptionBST {
		insereElementosNaBST(arrayAux);
		Integer[] posOrdem = { 1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 14, 12, 8 };
		assertTrue(Arrays.toString(posOrdem).equals(bst.imprimePosOrdem(8)));
		
		Integer[] posOrdem2 = { 9, 11, 10, 13, 15, 14, 12 };
		assertTrue(Arrays.toString(posOrdem2).equals(bst.imprimePosOrdem(12)));
		
		assertTrue("[9]".equals(bst.imprimePosOrdem(9)));
		
		assertThrows(ExceptionBST.class, () -> bst.imprimePosOrdem(16)); // elemento inexistente

		bst = new ArvoreBinariaImpl<>();
		assertThrows(ExceptionBST.class, () -> bst.imprimePosOrdem(8)); // BST vazia
	}
	
	@Test //testa impress�o dos valores ordenados e casos de falha
	public void testImprimeValoresOrdenados() throws ExceptionBST {
		insereElementosNaBST(arrayAux);
		Integer[] valoresOrdenados = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		assertTrue(Arrays.toString(valoresOrdenados).equals(bst.imprimeValoresOrdenados(8)));
		
		Integer[] valoresOrdenados2 = { 1, 2, 3, 4, 5, 6, 7 };
		assertTrue(Arrays.toString(valoresOrdenados2).equals(bst.imprimeValoresOrdenados(4)));
		
		assertTrue("[9]".equals(bst.imprimeValoresOrdenados(9)));
		
		assertThrows(ExceptionBST.class, () -> bst.imprimeValoresOrdenados(16)); //elemento inexistente
		
		bst = new ArvoreBinariaImpl<>();
		assertThrows(ExceptionBST.class, () -> bst.imprimeValoresOrdenados(8)); // BST vazia
	}
}