package algoritmos;

import sorting.AbstractSorting;

/**
 * QuickSort de pivô extra foca na implementação de um método de pivoteamento
 * O(n) para escolher um pivo com base nos valores do array. Este método deve
 * analisar os elementos do array e obter uma média dos valores para que seja 
 * usado como o pivô.
 * Lembre de identificar pivô que de fato existam no array, ou seja, você precisa
 * fazer uma busca no próprio array.
 * @author fabioleite
 *
 * @param <T>
 */
public class QuickSortExtraPivo<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public void ordena(T[] array, int inicio, int fim) {
		if(inicio < fim) {
			int q = particiona(array, inicio, fim);
			ordena(array, inicio, q - 1);
			ordena(array, q + 1, fim);
		}
	}

	private int particiona(T[] array, int inicio, int fim) {
		T pivo = array[escolhaPivo(array, inicio, fim)];
		int i = inicio - 1;
		
		for(int j = inicio; j < fim; j++) {
			if(array[j].compareTo(pivo) < 0) {
				i++;
				T aux = array[i];
				array[i] = array[j];
				array[j] = aux;
			}
		}
		T aux = array[i + 1];
		array[i + 1] = array[fim];
		array[fim] = aux;		
		
		return (i + 1);
	}

	/**
	 *O metodo em si pega como pivo o ultimo elemento, e vai fazer uma varredura
	 *e escolher o menor e o meior elemento, dai o pivo vai ser o ultimo elemento a 
	 *ser verificado que seja maior que o menor e menor que o maior.
	 * @param array
	 * @param inicio
	 * @param fim
	 * @return
	 */
	private int escolhaPivo(T[] array, int inicio, int fim) {
		int pivo = fim, menor = inicio, maior = inicio;
	
		for(int i = inicio; i < fim; i++) {
			if(array[i].compareTo(array[menor]) < 0) {
				menor = i;
			}
			if(array[i].compareTo(array[maior]) > 0) {
				maior = i;
			}
			if(array[menor].compareTo(array[i]) > 0 
					&& array[maior].compareTo(array[i]) < 0) {
				pivo = i;
			}
		}
		return pivo;
	}

}
