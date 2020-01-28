package heap.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import heap.sort.HeapIF;
import heap.sort.HeapImpl;

public class MaxHeapTest {
	
	HeapIF<Integer> heap;
	Integer[] vetorRandomico;
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorTamImpart;
	private Integer[] vetorTamPar;
	private Integer[] vetorVazio;
	private Integer[] vetorPiorCaso;
	private Integer[] vetorMelhorCaso;
	
	@BeforeEach
	public void setUp() {
		// ATENÇÃO ATENÇÃO ATENÇÃO
		// TODO: Você precisa implementar o seu próprio comparator de inteiros para atender
		// à especificação do comportamento de um MAX-HEAP.
		// Você pode fazer uma instanciação anônima da interface aqui.
		// Experimento utilizar Lambda expressions e veja como o código fica enxuto e simples.
		// Exemplo: heap = new HeapImpl<Integer>((o1,o2) -> o1.compareTo(o2));
//		Comparator<Integer> meuComparator = null;
//		heap = new HeapImpl<Integer>(meuComparator);
		heap = new HeapImpl<Integer>((o1,o2) -> o1.compareTo(o2));
		
		
		populaVetorValoresIguais(new Integer[] {3, 3, 3, 3, 3, 3, 3, 3,});
		populaVetorTamImpar(new Integer[] {3, 99, 48, 13, 47, 18, 1, 28, 59, 22, 67});
		populaVetorTamPar(new Integer[] {23, 10, 3, 69, 51, 99, 45, 32, 87, 88});
		populaVetorVazio(new Integer[] {});
		populaVetorRepetidos(new Integer[] {2, 6, 98, 54, 6, 78, 2, 34, 87, 78, 2, 1 });
		populaVetorMelhorCaso(new Integer[] {1, 5, 8, 12, 38, 40, 45, 67, 70, 78, 80, 98});
		populaVetorPiorCaso(new Integer[] {59, 43, 36, 20, 19, 17, 13, 10, 8, 5, 2, 1});
		populaVetorRandomico(300,600, 1000);
	}
	
	@Test
	void testHeapSortGenerico() {
		Integer[] entrada = new Integer[] {23, 10, 3, 69, 51, 99, 45, 32, 87, 88};
		assertArrayEquals(new Integer[] {3, 10, 23, 32, 45, 51, 69, 87, 88, 99}, heap.heapsort(entrada));
	}
	
	@Test
	void testBuild() {
		heap.buildHeap(new Integer[] {23, 10, 3, 69, 51, 99, 45, 32, 87, 88});
		assertEquals(10, heap.size());
		assertFalse(heap.isEmpty());
	}

	@Test
	void testIsEmpty() {
		assertTrue(heap.isEmpty());
		heap.buildHeap(new Integer[] {1});
		assertFalse(heap.isEmpty());
	}
	
	@Test
	void testHeapSize() {
		assertEquals(0, heap.size());
		heap.buildHeap(new Integer[] {1});
		assertEquals(1, heap.size());
	}
	
	
	
	
	private void populaVetorRandomico(int min, int max, int size) {
		vetorRandomico = new Integer[size];
		for (int i = 0; i < vetorRandomico.length; i++) {
			vetorRandomico[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
		}
	}

	public void populaVetorRepetidos(Integer[] arrayArgumento) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorValoresIguais(Integer[] arrayArgumento) {
		this.vetorValoresIguais = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorTamImpar(Integer[] arrayArgumento) {
		this.vetorTamImpart = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorTamPar(Integer[] arrayArgumento) {
		this.vetorTamPar = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorVazio(Integer[] arrayArgumento) {
		this.vetorVazio = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorPiorCaso(Integer[] arrayArgumento) {
		this.vetorPiorCaso = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorMelhorCaso(Integer[] arrayArgumento) {
		this.vetorMelhorCaso = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}

	public void testeGenerico(Integer[] array) {
		Integer[] copia1 = {};
		if (array.length > 0) {
			copia1 = Arrays.copyOf(array, array.length);
		}
		array = heap.heapsort(array);
		Arrays.sort(copia1);
		Assert.assertArrayEquals(copia1, array);
	}
	
	@Test
	public void testSortVetorRandomico() {
		testeGenerico(vetorRandomico);
	}
	
	@Test
	public void testSortVetorPar() {
		testeGenerico(vetorTamPar);
	}
	
	@Test
	public void testSortVetorImpar() {
		testeGenerico(vetorTamImpart);
	}
	
	@Test
	public void testSortRepetidos() {
		testeGenerico(vetorValoresRepetidos);
	}
	
	@Test
	public void testSortIguais() {
		testeGenerico(vetorValoresIguais);
	}
	
	@Test
	public void testSortVazio() {
		testeGenerico(vetorVazio);
	}
	
	@Test
	public void testSortPiorCaso() {
		testeGenerico(vetorPiorCaso);
	}
	
	@Test
	public void testSortMelhorCaso() {
		testeGenerico(vetorMelhorCaso);
	}
	
	

	private boolean verifyHeap(Integer[] input, int i) {
		if (2 * i + 2 > input.length) {
			return true;
		}

		boolean left = (input[i] <= input[2 * i + 1]) && verifyHeap(input, 2 * i + 1);

		boolean right = (2 * i + 2 == input.length) || (input[i] <= input[2 * i + 2] && verifyHeap(input, 2 * i + 2));

		return left && right;
	}

}
