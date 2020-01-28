
package petshop;

import java.util.ArrayList;


/**
 *
 * @author João Emanuel
 */
public class Cliente extends SuperClasse{
    private String nome, cpf;
    ArrayList<Pets> al = new ArrayList<>();
    ArrayList<SuperClasse> carrinho = new ArrayList<>();
    

    public Cliente(String nome, int cod, String cpf, ArrayList<Pets> pets) {
        super(cod);
        this.nome = nome;
        this.cpf = cpf;
        this.al = pets;
    }


    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPets(ArrayList<Pets> a){
        this.al = a;
    }
    
    public void setPets(Pets s){
        this.al.add(s);
    }
    
    public ArrayList<Pets> getPets(){
        return this.al;
    }
    
    public int qtdPets(){
        return this.al.size();
    }

    public ArrayList<SuperClasse> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<SuperClasse> carrinho) {
        this.carrinho = carrinho;
    }
    
    public void setCarrinho(SuperClasse car){
        this.carrinho.add(car);
    }
    
    public int qtdItensCarrinho(){
        if(this.carrinho == null){
            return 0;
        }
        return this.carrinho.size();
    }
}
