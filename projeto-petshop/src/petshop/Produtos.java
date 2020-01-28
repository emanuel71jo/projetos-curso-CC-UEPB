
package petshop;

/**
 *
 * @author usuario
 */
public class Produtos extends SuperClasse{
    private String descricao;
    private double preco;
    private int qtd;

    public Produtos(int cod, String descricao, double preco, int qtd) {
        super(cod);
        this.descricao = descricao;
        this.preco = preco;
        this.qtd = qtd;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
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
