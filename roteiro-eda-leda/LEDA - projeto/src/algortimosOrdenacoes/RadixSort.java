package algortimosOrdenacoes;

import java.util.LinkedList;
import java.util.Queue;

import ArraysSenha.MeuArray;
import Senha.Senha;
import sorting.Sort;

public class RadixSort{
	
	private static final int MAX_CHARS = 28;
	
	@Override
	public MeuArray sortOccurrences(MeuArray array) {

		Senha[] arraystring = new Senha[array.getTamanho()];
		Senha[] arrayAuxstring = new Senha[array.getTamanho()];
		int qtdDigitos = 0;

		boolean flag;

		for (int i = 0; i < arraystring.length; i++) {
			arraystring[i] = new Senha(array.getElemento(i).getTamSenha(), array.getElemento(i).getQtdSenhas(),
					array.getElemento(i).getSenha());
		}

		for (int i = 0; i < array.getTamanho(); i++) {
			if (Integer.toString(array.getElemento(i).getQtdSenhas()).length() > qtdDigitos)
				qtdDigitos = Integer.toString(array.getElemento(i).getQtdSenhas()).length();
		}

		for (int i = 0; i < arraystring.length; i++) {
			if (arraystring[i].getQtdSn().length() < qtdDigitos) {

				for (int j = 0; j < (qtdDigitos - arraystring[i].getQtdSn().length()); j++) {
					arraystring[i].setQtdSn("0" + arraystring[i].getQtdSn());
				}
			}
		}

		flag = (qtdDigitos > 0);

		while (flag) {
			int[] digitos = new int[10];
			
			for (int i = 0; i < arraystring.length; i++) {
				String string = arraystring[i].getQtdSn();
				int number = (int) (string.charAt(qtdDigitos - 1));
				digitos[number - 48]++;
			}

			for (int i = 1; i < digitos.length; i++) {
				digitos[i] += digitos[i - 1];
			}

			for (int i = array.getTamanho() - 1; i >= 0; i--) {
				int number = (int) (arraystring[i].getQtdSn().charAt(qtdDigitos - 1));
				arrayAuxstring[--digitos[number - 48]] = arraystring[i];

			}
			for (int i = 0; i < arraystring.length; i++) {
				arraystring[i] = arrayAuxstring[i];
			}
			qtdDigitos--;
			flag = (qtdDigitos > 0);

		}

		for (int i = 0; i < arrayAuxstring.length; i++) {
			array.setElemento(i, arrayAuxstring[i]);
		}

		return array;
	}

	@Override
	public MeuArray sortPassword(MeuArray vetor) {
		Queue<Senha> queues[] = createQueues();
		for (int pos = maxSize(vetor); pos >= 0; pos--) {
			if(vetor.getElemento(pos) == null){
				break;
			}
			for (int i = 0; i < vetor.getTamanho(); i++) {
				if(vetor.getElemento(i) == null){
					break;
				}
				int q = queueNo(vetor.getElemento(i).getSenha(), pos);
				queues[q].add(vetor.getElemento(i));
			}
			restore(queues, vetor);
		}
		
		return vetor;
	}
	
	private void restore(Queue<Senha>[] qs, MeuArray vetor) {
		int contv = 0;
		for (int q = 0; q < qs.length; q++)
			while (qs[q].size() > 0)
				vetor.setElemento(contv++, qs[q].remove());
	}

	private Queue<Senha>[] createQueues() {
		@SuppressWarnings("unchecked")
		LinkedList<Senha>[] result = new LinkedList[MAX_CHARS];
		for (int i = 0; i < MAX_CHARS; i++) {
			result[i] = new LinkedList<Senha>();
		}
		return result;
	}

	private int queueNo(String string, int pos) {
		if (pos >= string.length()) {
			return 0;
		}
		char ch = string.charAt(pos);
		if ((ch >= 'A') && (ch <= 'Z')) {
			return (ch - 'A' + 1);
		}
		else if (ch >= 'a' && ch <= 'z') {
			return ch - 'a' + 1;
		}
		else {
			return 27;
		}
	}
	
	private static int maxSize(MeuArray vetor) {
		int maxValue = vetor.getElemento(0).getSenha().length();
		
		for (int i = 1; i < vetor.getTamanho() - 2; i++) {
			if(maxValue < vetor.getElemento(i).getSenha().length()) {
				maxValue = vetor.getElemento(i).getSenha().length();
			}
		}
		
		return maxValue;
	}

}
