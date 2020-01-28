
package netflixdeLivros;

import java.io.Serializable;

/**
 *
 * @author Dijay, João e Pedro.
 */
public abstract class Pacote implements Serializable {
	
	
	private int quantidadeLivros;
    private double valor;
    /***
     * Construtor de Pacote.
     * 
     * @param quantidadeLivros Quantidade de Livros permitidos serem acessados.
     * @param valor Valor de cada Pacote.
     */
    public Pacote(int quantidadeLivros, double valor) {
        this.quantidadeLivros = quantidadeLivros;
        this.valor = valor;
        
    }

    public int getQuantidadeLivros() {
        return quantidadeLivros;
    }

    public void setQuantidadeLivros(int quantidadeLivros) {
        this.quantidadeLivros = quantidadeLivros;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}