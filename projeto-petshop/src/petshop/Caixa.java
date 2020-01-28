
package petshop;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author João Emanuel
 */
public class Caixa implements Serializable{
    private double valorTotalDoCaixa;
    private boolean abeturaDeCaixa;
    private ArrayList<SuperClasse> sc = new ArrayList<>();
   
    public boolean getAbeturaDeCaixa() {
        return abeturaDeCaixa;
    }

    public void setAbeturaDeCaixa(boolean abeturaDeCaixa) {
        this.abeturaDeCaixa = abeturaDeCaixa;
    }

    public double getValorTotalDoCaixa() {
        return valorTotalDoCaixa;
    }

    public void setValorTotalDoCaixa(double valorTotalDoCaixa) {
        this.valorTotalDoCaixa += valorTotalDoCaixa;
    }
    
    public void setSc(SuperClasse e){
        this.sc.add(e);
    }
    
    public ArrayList<SuperClasse> getSc(){
        return sc;
    } 
    
}
