package netflixdeLivros;

import java.util.ArrayList;

public interface FuncionalidadesArquivosLivros {
	
	/***
	 * Grava os arquivos;
	 * 
	 * @param l
	 * 			ArrayListde Leitor.
	 */
    public void Gravar_Array(ArrayList<Livros> l);
    
    /***
	 * Ler os arquivos.
	 * 
	 * @return 
	 * 			Um ArrayList com os dados contidos no arquivo.
	 */
    public ArrayList<Livros> Lendo_Array();
}
