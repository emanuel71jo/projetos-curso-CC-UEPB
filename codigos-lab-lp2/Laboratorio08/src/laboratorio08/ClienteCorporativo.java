
package laboratorio08;

/**
 *
 * @author usuario
 */
public class ClienteCorporativo extends Cliente{
    private String CNPJ;

    public ClienteCorporativo(String nome, String endereco, String email, String CNPJ) {
        super(nome, endereco, email);
        this.CNPJ = CNPJ;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    
}
