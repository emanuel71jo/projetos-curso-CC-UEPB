
package laboratorio10;

/**
 *
 * @author usuario
 */
public class ClienteIndividual extends Cliente{
    private String CPF;

    public ClienteIndividual(String nome, String endereco, String email, String CPF) {
        super(nome, endereco, email);
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
}
