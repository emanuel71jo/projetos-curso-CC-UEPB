package testes;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algoritmos.CoutingSortExtends;
import algoritmos.MergeSort;
import sorting.AbstractSorting;

class NovosTestesCoutingSortExtends {
	
	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpart;
	private Integer[] vetorVazio;
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private AbstractSorting<Integer> Implementacao;
	private Integer[] vetorPiorCaso;
	private Integer[] vetorMelhorCaso;
	private Integer[] vetorRandomico;
	
	@BeforeEach
	public void setUp() {
		populaVetorValoresIguais(new Integer[] {3, 3, 3, 3, 3, 3, 3, 3,});
		populaVetorTamImpar(new Integer[] {3, 99, 48, 13, 47, 18, 1, 28, 59, 22, 67});
		populaVetorTamPar(new Integer[] {23, 10, 3, 69, 51, 99, 45, 32, 87, 88});
		populaVetorVazio(new Integer[] {});
		populaVetorRepetidos(new Integer[] {2, 6, 98, 54, 6, 78, 2, 34, 87, 78, 2, 1 });
		populaVetorMelhorCaso(new Integer[] {1, 5, 8, 12, 38, 40, 45, 67, 70, 78, 80, 98});
		populaVetorPiorCaso(new Integer[] {59, 43, 36, 20, 19, 17, 13, 10, 8, 5, 2, 1});
		populaVetorRandomico(300,600, 1000);
		getImplementacao();
	}
	
	private void populaVetorRandomico(int min, int max, int size) {
		vetorRandomico = new Integer[size];
		for (int i = 0; i < vetorRandomico.length; i++) {
			vetorRandomico[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
		}
	}

	private void getImplementacao() {
		//TODO: colocar a implementação do método a ser testada
		this.Implementacao = new CoutingSortExtends<Integer>();
//		Assert.fail("falhar quando não tiver implementação");
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
		Implementacao.sort(array);
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
}
