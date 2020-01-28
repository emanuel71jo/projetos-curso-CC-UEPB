
package petshop;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public abstract class Pets implements Serializable{
    private String nome, especie, raça;

    public Pets( String nome, String especie, String raça) {
        this.nome = nome;
        this.especie = especie;
        this.raça = raça;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

}
