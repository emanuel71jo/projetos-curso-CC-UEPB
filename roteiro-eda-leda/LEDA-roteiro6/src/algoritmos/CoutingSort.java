package algoritmos;

import sorting.AbstractSorting;

public class CoutingSort<T extends Comparable<T>> extends AbstractSorting<T>  {

	@Override
	public void ordena(T[] array, int inicio, int fim) {
		// Verificando se o array é vazio
		if(array.length == 0)
			return;
		
		// Pegando o maior elemento do array
		int maior = (int) array[0];
		for(int i = 0; i < array.length; i++) {
			if((int) array[i] > maior)
				maior = (int) array[i];
		}
		
		// Criando um array do tamanho do maior elemento
		int arrayTemporario[] = new int[maior + 1];
		
		// Contando a ocorrencia de cada elemento
		for(int i = 0; i < array.length; i++)
			arrayTemporario[(int) array[i]]++;
		
		// Fazendo o complementar no array aux
		for(int i = 1; i <= maior; i++)
			arrayTemporario[i] += arrayTemporario[i - 1];
		
		// Ordenando o array
		T[] aux = (T[]) new Comparable[array.length];
		for(int i = 0; i< array.length; i++) {
			aux[arrayTemporario[(int) array[i]] - 1] = array[i];
			arrayTemporario[(int) array[i]]--;
		}
		
		// Colocando os valores no array principal
		for(int i = 0; i < array.length; i++)
			array[i] = aux[i];
		
	}

}
