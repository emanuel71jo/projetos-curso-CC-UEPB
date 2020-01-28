
package petshop;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Pacotes extends SuperClasse{
    private String descricao;
    ArrayList<SuperClasse> itens = new ArrayList<>();

    public Pacotes(int cod, String descricao, ArrayList<SuperClasse> servicos) {
        super(cod);
        this.descricao = descricao;
        this.itens = servicos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<SuperClasse> getItens() {
        return itens;
    }

    public void setItens(ArrayList<SuperClasse> itens) {
        this.itens = itens;
    }
    
    public double getPreco(){
        double pre = 0;
        for(SuperClasse p: itens){
            if(p instanceof Servicos){
                pre += ((Servicos)p).getPreco();
                
            }
            
        }
        
        return pre - (pre * 0.1);
    }
    
}
