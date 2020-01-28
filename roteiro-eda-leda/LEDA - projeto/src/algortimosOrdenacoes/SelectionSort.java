package algortimosOrdenacoes;

import sorting.AbstractSorting;

public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void ordena(T[] array, int start, int end) {
		for(int i = start; i < end; i++) {
			int menor = i;
			for(int j = i + 1; j <= end; j++)
				if(array[j].compareTo(array[menor]) < 0)
					menor = j;
			if(array[i].compareTo(array[menor]) != 0)
				troca(array, menor, i);
		}
	}
	private void troca(T[] array, int menor, int i) {
		T aux = array[menor];
		array[menor] = array[i];
		array[i] = aux;
	}
}
