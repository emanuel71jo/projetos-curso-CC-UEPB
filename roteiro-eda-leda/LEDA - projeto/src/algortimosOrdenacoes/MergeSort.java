package algortimosOrdenacoes;

import sorting.AbstractSorting;

public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void ordena(T[] array, int start, int end) {
		
		if(start < end) {
			int meio = (start + end) / 2;
			ordena(array, start, meio);
			ordena(array, meio + 1, end);
			intercala(array, start, meio, end);
		}
		
	}

	private void intercala(T[] array, int start, int meio, int end) {
		T[] auxiliar = (T[]) new Comparable[array.length];

		for (int i = start; i <= end; i++) {
			auxiliar[i] = array[i];
		}

		int i = start;
		int j = meio + 1;
		int k = start;

		while (i <= meio && j <= end) {
			if (auxiliar[i].compareTo(auxiliar[j]) < 0) {
				array[k] = auxiliar[i];
				i++;
			} else {
				array[k] = auxiliar[j];
				j++;
			}
			k++;
		}

		while (i <= meio) {
			array[k] = auxiliar[i];
			i++;
			k++;
		}

		while (j <= end) {
			array[k] = auxiliar[j];
			j++;
			k++;
		}
		
	}

}
