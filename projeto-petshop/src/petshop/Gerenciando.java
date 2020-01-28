
package petshop;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author João Emanuel
 */
public class Gerenciando implements Funcionalidades{

    @Override
    public void cadastrar(SuperClasse sc) {
        ArrayList<SuperClasse> usu = new ArrayList<>();

        try{
            //Lendo o ArrayList
            try{
                InputStream fis = new FileInputStream("Arquivos.tmp");
                ObjectInputStream ois = new ObjectInputStream(fis);

                usu = (ArrayList) ois.readObject();

                ois.close();
                fis.close();

            }catch(FileNotFoundException eo){

            }catch(IOException eo){

            }catch (ClassNotFoundException ex) {
                
            }
            //Adicionando usuario ao ArrayList
            usu.add(sc);
            
            //Gravando o ArrayList
            OutputStream fos = new FileOutputStream("Arquivos.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(usu);
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
            usu.clear();

        }catch(FileNotFoundException eo){
            
        }catch(IOException eo){
            
        }
    }
    
    

    @Override
    public void remover(SuperClasse sc) {
        ArrayList<SuperClasse> usu = new ArrayList<>();

        try{
            //Lendo o ArrayList
            try{
                InputStream fis = new FileInputStream("Arquivos.tmp");
                ObjectInputStream ois = new ObjectInputStream(fis);

                usu = (ArrayList<SuperClasse>) ois.readObject();

                ois.close();
                fis.close();

            }catch(FileNotFoundException eo){

            }catch(IOException eo){

            }catch (ClassNotFoundException ex) {
                
            }
            //Removendo usuario ao ArrayList
            usu.remove(sc);
            
            //Gravando o ArrayList
            OutputStream fos = new FileOutputStream("Arquivos.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(usu);
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
            usu.clear();

        }catch(FileNotFoundException eo){
            
        }catch(IOException eo){
            
        }
    }

    @Override
    public ArrayList<SuperClasse> listar() {
        ArrayList<SuperClasse> sc = new ArrayList<>();
        
        try{
            InputStream fis = new FileInputStream("Arquivos.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);

            sc = (ArrayList<SuperClasse>) ois.readObject();
            
            ois.close();
            fis.close();

        }catch(FileNotFoundException eo){
            
        }catch(IOException eo){
            
        }catch (ClassNotFoundException ex) {
            
        }
        
        return sc;
    }
    
    @Override
    public void cadastrar(ArrayList<SuperClasse> sc) {
        try{            
            //Gravando o ArrayList
            OutputStream fos = new FileOutputStream("Arquivos.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(sc);
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();

        }catch(FileNotFoundException eo){
            
        }catch(IOException eo){
            
        }
    }
}
