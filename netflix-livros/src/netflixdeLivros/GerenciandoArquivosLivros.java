
package netflixdeLivros;

import java.io.*;
import java.util.ArrayList;

public class GerenciandoArquivosLivros implements FuncionalidadesArquivosLivros{

	/***METODO LENDO ARRAYLIST
	 * 
	 * Ler os dados contidos no arquivo e os coloca em um ArrayList para ser retornado e manipulado.
	 * 
	 * @return Retorna ArrayList contendo os dados presentes no arquivo.
	 */
	
	public ArrayList<Livros> Lendo_Array() {
		ArrayList<Livros> sc = new ArrayList<Livros>();
        
        try{
            InputStream fis = new FileInputStream("Livros.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            sc = (ArrayList<Livros>) ois.readObject();
            
            ois.close();
            fis.close();

        }catch(FileNotFoundException eo){
        	 //System.out.println("Nao ha elementos cadastrados!");
        }catch(IOException eo){

        }catch (ClassNotFoundException ex) {

        }
        
        return sc;
	}
	
	/***METODO GRAVAR ARRAYLIST
	 * 
	 * Grava o ArrayList que esta sendo passado por parametro.
	 * 
	 * @param l ArrayList que será gravado no arquivo.
	 */
	public void Gravar_Array(ArrayList<Livros> l) {
		try{
            
            //Gravando o ArrayList
            OutputStream fos = new FileOutputStream("Livros.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(l);
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();

        }catch(FileNotFoundException eo){
            
        }catch(IOException eo){
            
        }
	}
	
	

}
