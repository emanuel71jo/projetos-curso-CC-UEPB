
package laboratorio06;

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
    
    /**
     * testando o medo checandoGanhador();
     * verificando se o jogador 1 que ganha
     */
    @Test
    public void checandoJogador1Ganha(){
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador = new Jogador(1);
        jogador.setX(0);
        jogador.setY(0);
        jogador.realizandoJogada(tabuleiro);
        jogador.setX(0);
        jogador.setY(1);
        jogador.realizandoJogada(tabuleiro);
        jogador.setX(0);
        jogador.setY(2);
        jogador.realizandoJogada(tabuleiro);
        Assert.assertEquals("O GANHADOR FOI O JOGADOR 1", jogador.checandoGanhador(tabuleiro));
        
    }
    
    /**
     * testando o metodo checandoGanhador();
     * verificando se o jogador 2 que ganha
     */
    @Test
    public void checandoJogador2Ganha(){
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador = new Jogador(2);
        jogador.setX(0);
        jogador.setY(0);
        jogador.realizandoJogada(tabuleiro);
        jogador.setX(0);
        jogador.setY(1);
        jogador.realizandoJogada(tabuleiro);
        jogador.setX(0);
        jogador.setY(2);
        jogador.realizandoJogada(tabuleiro);
        Assert.assertEquals("O GANHADOR FOI O JOGADOR 2", jogador.checandoGanhador(tabuleiro));
        
    }
    
    /**
     * testando o metodo checandoGanhador()
     * verificando se obtem EMPATE como retorno
     */
    @Test
    public void checandoEmpate(){
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1 = new Jogador(1);
        Jogador jogador2 = new Jogador(2);
        jogador1.setX(0);
        jogador1.setY(0);
        jogador1.realizandoJogada(tabuleiro);
        jogador1.setX(1);
        jogador1.setY(1);
        jogador1.realizandoJogada(tabuleiro);
        jogador1.setX(2);
        jogador1.setY(1);
        jogador1.realizandoJogada(tabuleiro);
        jogador1.setX(0);
        jogador1.setY(2);
        jogador1.realizandoJogada(tabuleiro);
        jogador1.setX(1);
        jogador1.setY(2);
        jogador1.realizandoJogada(tabuleiro);
        jogador2.setX(0);
        jogador2.setY(1);
        jogador2.realizandoJogada(tabuleiro);
        jogador2.setX(1);
        jogador2.setY(0);
        jogador2.realizandoJogada(tabuleiro);
        jogador2.setX(2);
        jogador2.setY(2);
        jogador2.realizandoJogada(tabuleiro);
        jogador2.setX(2);
        jogador2.setY(0);
        jogador2.realizandoJogada(tabuleiro);
        
        Assert.assertEquals("O JOGO FOI EMPATE", jogador1.checandoGanhador(tabuleiro));
        Assert.assertEquals("O JOGO FOI EMPATE", jogador2.checandoGanhador(tabuleiro));
        
    }
}
