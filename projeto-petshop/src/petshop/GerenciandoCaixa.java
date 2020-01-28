/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop;

import java.io.*;

/**
 *
 * @author João Emanuel
 */
public class GerenciandoCaixa {
    
    public void create(Caixa sc) {
        try{
                        
            //Gravando o ArrayList
            OutputStream fos = new FileOutputStream("Caixa.tmp");
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
    
    public Caixa read() {
        Caixa caixa = new Caixa();
        
        try{
            InputStream fis = new FileInputStream("Caixa.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);

            caixa = (Caixa) ois.readObject();
            
            ois.close();
            fis.close();

        }catch(FileNotFoundException eo){
            
        }catch(IOException eo){
            
        }catch (ClassNotFoundException ex) {
            
        }
        
        return caixa;
    }
}

