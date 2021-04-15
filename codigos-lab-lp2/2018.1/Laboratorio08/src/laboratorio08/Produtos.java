
package laboratorio08;

/**
 *
 * @author usuario
 */
public class Produtos {
    private String descricao;
    private int quantidade, codigo;
    private double valor;

    public Produtos(String descricao, int quantidade, double valor, int codigo) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValor() {
        return valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
