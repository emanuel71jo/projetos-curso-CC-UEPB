package algoritmos;

import sorting.AbstractSorting;

public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void ordena(T[] array, int inicio, int fim) {
		if(inicio < fim) {
			int q = particiona(array, inicio, fim);
			ordena(array, inicio, q - 1);
			ordena(array, q + 1, fim);
		}
	}

	private int particiona(T[] array, int inicio, int fim) {
		T pivo = array[fim];
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

}
