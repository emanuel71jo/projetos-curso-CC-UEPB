
package laboratorio05;

import java.util.Scanner;

/**
 *
 * @author João Emanuel
 */
public class Laboratorio05 {
    
    public static void main(String[] args) {
        int nJogador1 = 1, nJogador2 = 2;
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1 = new Jogador(nJogador1);
        Jogador jogador2 = new Jogador(nJogador2);
        Jogo jogar = new Jogo();
        jogar.jogando(jogador1, jogador2, tabuleiro);
    }  
}
