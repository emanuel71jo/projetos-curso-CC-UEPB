package inputOutputData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import classes.Objeto;
import sorting.AbstractSorting;

public class ManipulacaoArquivo {
	AbstractSorting<Objeto> ordenacao = null;
	Objeto[] objetos = null;
	int posLivre = 0;


	public ManipulacaoArquivo(AbstractSorting<Objeto> sort) {
		this.ordenacao = sort;
		this.objetos = new Objeto[430000];
	}

	public void lendoDados(String arq) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(arq));
			String linha;
			System.out.println(System.currentTimeMillis());
			while((linha = br.readLine()) != null) {
				objetos[posLivre++] = new Objeto(linha.split(" ", 3));
			}
			System.out.println(System.currentTimeMillis());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void gravarDados(String arq) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(arq));
			System.out.println(System.currentTimeMillis());
			for(int i = 0; i < objetos.length; i++) {
				bw.append(objetos[i].getDigito() + " "
						+ objetos[i].getOcorrencia() + " "
						+ objetos[i].getSenha());
				bw.newLine();
				bw.flush();
			}
			System.out.println(System.currentTimeMillis());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ordenar() {
		System.out.println(System.currentTimeMillis());
		ordenacao.sort(objetos);
		System.out.println(System.currentTimeMillis());
	}
}
