
package laboratorio10;

/**
 *
 * @author usuario
 */
public class Eletronicos extends Produtos{
    private String marca, tipo;

    public Eletronicos(String descricao, int quantidade, double valor, String marca, String tipo, int cod) {
        super(descricao, quantidade, valor, cod);
        this.marca = marca;
        this.tipo = tipo;
    }
    
}
