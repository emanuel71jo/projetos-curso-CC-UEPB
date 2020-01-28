package algoritmos;

import sorting.AbstractSorting;

public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void ordena(T[] array, int inicio, int fim) {
		if(inicio < fim) {
			int meio = (inicio + fim) / 2;
			ordena(array,inicio,meio);
			ordena(array,meio + 1, fim);
			intercala(array, inicio, meio, fim);
		}
	}

	private void intercala(T[] array, int inicio, int meio, int fim) {
		T[] auxiliar = (T[]) new Comparable[array.length];

		for (int i = inicio; i <= fim; i++) {
			auxiliar[i] = array[i];
		}

		int i = inicio;
		int j = meio + 1;
		int k = inicio;

		while (i <= meio && j <= fim) {
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

		while (j <= fim) {
			array[k] = auxiliar[j];
			j++;
			k++;
		}
	}

}
