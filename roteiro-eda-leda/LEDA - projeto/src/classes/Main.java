package classes;

import algortimosOrdenacoes.CoutingSort;
import inputOutputData.ManipulacaoArquivo;

public class Main {

	public static void main(String[] args) {
		//ManipulacaoArquivo ma = new ManipulacaoArquivo(new CoutingSort<Objeto>());
		ManipulacaoArquivo ma = new ManipulacaoArquivo(new CoutingSort<Objeto>());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ma.lendoDados("senhas.txt");
		ma.ordenar();
		ma.gravarDados("coutingsort_ordem_ocorrencia.txt");
	}
}
