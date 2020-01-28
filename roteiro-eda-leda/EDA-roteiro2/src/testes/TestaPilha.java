package testes;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import tad.pilha.MinhaPilha;
import tad.pilha.PilhaCheiaException;
import tad.pilha.PilhaIF;
import tad.pilha.PilhaVaziaException;

public class TestaPilha {
	
	private PilhaIF<Integer> pilha = null;
	
	@Before
	public void iniciar() {
		pilha = new MinhaPilha();
	}
	
	@Test
	public void empilharTest() throws PilhaCheiaException {
		pilha.empilhar(3);
		Assert.assertEquals(new Integer(3), pilha.topo());
		pilha.empilhar(5);
		Assert.assertEquals(new Integer(5), pilha.topo());
		pilha.empilhar(7);
		Assert.assertEquals(new Integer(7), pilha.topo());
		pilha.empilhar(4);
		Assert.assertEquals(new Integer(4), pilha.topo());
		pilha.empilhar(2);
		Assert.assertEquals(new Integer(2), pilha.topo());
	}
	
	@Test
	public void topoTest() throws PilhaCheiaException {
		Assert.assertNull(pilha.topo());
		pilha.empilhar(3);
		Assert.assertEquals(new Integer(3), pilha.topo());
		pilha.empilhar(5);
		Assert.assertEquals(new Integer(5), pilha.topo());
		pilha.empilhar(7);
		Assert.assertEquals(new Integer(7), pilha.topo());
		pilha.empilhar(4);
		Assert.assertEquals(new Integer(4), pilha.topo());
		pilha.empilhar(2);
		Assert.assertEquals(new Integer(2), pilha.topo());
		
	}
	
	@Test
	public void desempilharTest() throws PilhaCheiaException, PilhaVaziaException {
		try {
			pilha.desempilhar();
			Assert.fail("deveria lançar uma exceção quando chamar o desempilhar de uma pilha vazia");
		} catch (Exception e) {}
		pilha.empilhar(3);
		Assert.assertEquals(new Integer(3), pilha.topo());
		pilha.empilhar(5);
		Assert.assertEquals(new Integer(5), pilha.topo());
		pilha.empilhar(7);
		Assert.assertEquals(new Integer(7), pilha.topo());
		pilha.empilhar(4);
		Assert.assertEquals(new Integer(4), pilha.topo());
		pilha.empilhar(2);
		Assert.assertEquals(new Integer(2), pilha.topo());
		Assert.assertEquals(new Integer(2), pilha.desempilhar());
		Assert.assertEquals(new Integer(4), pilha.topo());
		
		Assert.assertEquals(new Integer(4), pilha.desempilhar());
		Assert.assertEquals(new Integer(7), pilha.topo());
		
		Assert.assertEquals(new Integer(7), pilha.desempilhar());
		Assert.assertEquals(new Integer(5), pilha.topo());
		
		Assert.assertEquals(new Integer(5), pilha.desempilhar());
		Assert.assertEquals(new Integer(3), pilha.topo());
		
		Assert.assertEquals(new Integer(3), pilha.topo());
	}
	
	@Test
	public void isEmptyTest() throws PilhaCheiaException, PilhaVaziaException {
		Assert.assertTrue(pilha.isEmpty());
		pilha.empilhar(3);
		Assert.assertEquals(new Integer(3), pilha.topo());
		Assert.assertFalse(pilha.isEmpty());
		pilha.desempilhar();
		Assert.assertTrue(pilha.isEmpty());
		pilha.empilhar(4);
		pilha.empilhar(6);
		Assert.assertFalse(pilha.isEmpty());
	}
	
	@Test
	public void pilhaVaziaTest() {
		assertThrows(PilhaVaziaException.class, () -> {
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
			pilha.desempilhar();
			pilha.desempilhar();
			pilha.desempilhar();
			pilha.desempilhar();
	    });
	}
	
	@Test
	public void pilhaCheiaTest() {
		assertThrows(PilhaCheiaException.class, () -> {
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
	    });
	}
	
	//Neste teste a pilha tem que estourar o tamanho depois de 999
	@Test(expected=PilhaCheiaException.class)
	public void empilharEstouroTeste() throws PilhaCheiaException {
		pilha = new MinhaPilha(1000);
		for (int i = 0; i <= 1000; i++) {
			pilha.empilhar(i);
		}
	}
	

}
