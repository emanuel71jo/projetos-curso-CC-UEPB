
package laboratorio08;

/**
 *
 * @author usuario
 */
public class Perfume extends Produtos{
    private String marca;
    
    public Perfume(String descricao, int quantidade, double valor, String marca, int cod) {
        super(descricao, quantidade, valor, cod);
        this.marca = marca;
    }
    
}
