
package laboratorio06;

/**
 *
 * @author João Emanuel
 */
/**
 * Em relação ao Lab anterior, foi acrescentado apenas a função de jogar contra o computador
 * Foi acrescentado apenas uma classe para jogar com o computador --> jogandoComJogador1eComputador();
 * Outra classe que seta as coordenadas do computador no tabuleiro --> setCoordenadas();
 * E outra que serve para obter uma nova coordenada enquanto a obtida for inválida --> coordenadasComputador();
 * Tambem um menu(); simples, que serve para escolher se jogar com 2 jogadores ou contra o computador.
 * @author João Emanuel
 */
public class Laboratorio05 {
    
    public static void main(String[] args) {
        int nJogador1 = 1, nJogador2 = 2;
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1 = new Jogador(nJogador1);
        Jogador jogador2 = new Jogador(nJogador2);
        Jogo jogar = new Jogo();
        if(jogar.menu() == 1){
            jogar.jogandoComJogador1eComputador(jogador1, jogador2, tabuleiro);
        }else{
            jogar.jogandoComJogador1eJogador2(jogador1, jogador2, tabuleiro);
        }
    }  
}
