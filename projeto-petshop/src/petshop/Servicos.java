
package petshop;

/**
 *
 * @author usuario
 */
public class Servicos extends SuperClasse{
    private String descricao;
    private double preco;

    public Servicos(int cod, String descricao, double preco) {
        super(cod);
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    
}
