package netflixdeLivros;

import java.util.ArrayList;

public interface FuncionalidadesArquivosLeitor {
	/***
	 * Grava os arquivos;
	 * 
	 * @param l
	 * 			ArrayListde Leitor.
	 */
	public void Gravar_Array(ArrayList<Leitor> l);
	
	/***
	 * Ler os arquivos.
	 * 
	 * @return 
	 * 			Um ArrayList com os dados contidos no arquivo.
	 */
    public ArrayList<Leitor> Lendo_Array();
}
