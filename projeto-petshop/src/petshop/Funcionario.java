
package petshop;

/**
 *
 * @author usuario
 */
public class Funcionario extends SuperClasse{
    private String nome, cpf;

    public Funcionario(int cod, String nome, String cpf) {
        super(cod);
        this.nome = nome;
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
