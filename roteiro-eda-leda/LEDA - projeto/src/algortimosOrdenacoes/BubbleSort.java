package algortimosOrdenacoes;

import sorting.AbstractSorting;

public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void ordena(T[] array, int start, int end) {
		boolean houveTroca = true;
		while(houveTroca) {
			houveTroca = false;
			for(int i = start; i < end; i++) {
				if(array[i].compareTo(array[i+1]) > 0) {
					troca(array, i, (i+1));
					houveTroca = true;
				}
			}
		}
		
	}
	
	private void troca(T[] array, int i, int j) {
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
		
	}

	
}
