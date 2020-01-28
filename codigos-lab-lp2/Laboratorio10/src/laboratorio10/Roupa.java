
package laboratorio10;

/**
 *
 * @author usuario
 */
public class Roupa extends Produtos{
    private String tipo;

    public Roupa(String descricao, int quantidade, String tipo, double valor, int cod) {
        super(descricao, quantidade, valor, cod);
        this.tipo = tipo;
    }
    
}
