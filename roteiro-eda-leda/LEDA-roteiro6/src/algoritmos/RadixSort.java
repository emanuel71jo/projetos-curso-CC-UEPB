package algoritmos;

import sorting.AbstractSorting;

public class RadixSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void ordena(T[] array, int inicio, int fim) {
		for(int k = 0; k < 3; k ++){
			int power = (int) Math.pow(10, k+1);
			T[][] z = (T[][]) new Comparable[array.length][10];
			int n[] = new int[10];

			for(int i = 0; i < array.length; i ++){
				T num = array[i];
				z[n[((int) num%power)/(power/10)]][((int) num%power)/(power/10)] = num;
				n[((int) num%power)/(power/10)]++;
				
			}
			int c = 0;
			for(int i = 0; i < 10; i ++){
				for(int j = 0; j < array.length; j ++){
					if(j < n[i]){
						array[c++] = z[j][i];
					}else{break;}
				}
			}
			
		}
		
	}

}
