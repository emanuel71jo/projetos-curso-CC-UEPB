package algortimosOrdenacoes;

import classes.Objeto;
import sorting.AbstractSorting;

public class CoutingSort<T extends Comparable<T>> extends AbstractSorting<T>  {

	@Override
	public void ordena(T[] array, int inicio, int fim) {
		// Verificando se o array é vazio
		if(array.length == 0)
			return;
		
		// Pegando o maior elemento do array
		
		Objeto[] arr = (Objeto[]) array;
		
		int maior = (int) arr[0].getOcorrencia();
		for(int i = 0; i < array.length; i++) {
			if((int) arr[i].getOcorrencia() > maior)
				maior = (int) arr[i].getOcorrencia();
		}
		
		// Criando um array do tamanho do maior elemento
		int arrayTemporario[] = new int[maior + 1];
		
		// Contando a ocorrencia de cada elemento
		for(int i = 0; i < array.length; i++)
			arrayTemporario[(int) arr[i].getOcorrencia()]++;
		
		// Fazendo o complementar no array aux
		for(int i = 1; i <= maior; i++)
			arrayTemporario[i] += arrayTemporario[i - 1];
		
		// Ordenando o array
		Objeto[] aux = new Objeto[array.length];
		for(int i = 0; i< array.length; i++) {
			aux[arrayTemporario[(int) arr[i].getOcorrencia()] - 1] = arr[i];
			arrayTemporario[(int) arr[i].getOcorrencia()]--;
		}
		
		// Colocando os valores no array principal
		for(int i = 0; i < array.length; i++)
			array[i] = (T) aux[i];
		
	}
}