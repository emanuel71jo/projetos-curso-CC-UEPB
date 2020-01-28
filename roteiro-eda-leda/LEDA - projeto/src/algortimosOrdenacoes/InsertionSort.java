package algortimosOrdenacoes;

import sorting.AbstractSorting;

public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public void ordena(T[] array, int start, int end) {
		for(int i = 1; i <= end; i++) {
			for(int j = start; j < i; j++) {
				if(array[i].compareTo(array[j]) < 0)
					troca(array, i, j);
			}
		}
	}

	private void troca(T[] array, int i, int j) {
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

}
