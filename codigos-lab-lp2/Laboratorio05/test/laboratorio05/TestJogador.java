
package laboratorio05;

import junit.framework.Assert;
import org.junit.Test;
/**
 *
 * @author João Emanuel
 */
public class TestJogador {
    
    /**
     * Verificando os métodos Getters e Setters
     */
    @Test
    public void testMetodosEspeciais(){
        Jogador jogador = new Jogador(1);
        jogador.setX(0);
        jogador.setY(0);
        Assert.assertEquals(0, jogador.getX());
        Assert.assertEquals(0, jogador.getY());
        jogador.setX(1);
        jogador.setY(2);
        Assert.assertEquals(1, jogador.getX());
        Assert.assertEquals(2, jogador.getY());
    }
    
    /**
     * Realizando uma jogada para o jogador 1, sabendo o local do tabuleiro está vazio.
     */
    @Test
    public void testRealizandoJogadaValidaJogador1(){
        Jogador jogador = new Jogador(1);
        Tabuleiro tabuleiro = new Tabuleiro();
        jogador.setX(0);
        jogador.setY(0);
        Assert.assertTrue(jogador.realizandoJogada(tabuleiro));
    }
    
    /**
     * Realizando uma jogada para o jogador 2, sabendo o local do tabuleiro está vazio.
     */
    @Test
    public void testRealizandoJogadaValidaJogador2(){
        Jogador jogador = new Jogador(2);
        Tabuleiro tabuleiro = new Tabuleiro();
        jogador.setX(0);
        jogador.setY(0);
        Assert.assertTrue(jogador.realizandoJogada(tabuleiro));
    }
    
    /**
     * Testando se retorna false ao tentar realizar uma jogada no lugar onde já está ocupado. Jogador 1.
     */
    @Test
    public void testRealizandoJogadaInvalidaJogador1(){
        Jogador jogador = new Jogador(1);
        Tabuleiro tabuleiro = new Tabuleiro();
        jogador.setX(0);
        jogador.setY(0);
        jogador.realizandoJogada(tabuleiro);
        Assert.assertFalse(jogador.realizandoJogada(tabuleiro));
    }
    
    /**
     * Testando se retorna false ao tentar realizar uma jogada no lugar onde já está ocupado. Jogador 2.
     */
    @Test
    public void testRealizandoJogadaInvalidaJogador2(){
        Jogador jogador = new Jogador(2);
        Tabuleiro tabuleiro = new Tabuleiro();
        jogador.setX(1);
        jogador.setY(1);
        jogador.realizandoJogada(tabuleiro);
        Assert.assertFalse(jogador.realizandoJogada(tabuleiro));
    }
}
