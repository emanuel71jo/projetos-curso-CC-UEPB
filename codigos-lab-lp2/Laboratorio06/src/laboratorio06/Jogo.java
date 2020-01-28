
package laboratorio06;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author João Emanuel
 */
public class Jogo {
    private Scanner teclado = new Scanner(System.in);
    private int nJogador1 = 1, nJogador2 = 2;
    private Random random =  new Random();
    
    /**
     * Lógica do jogo, realizando as jogadas, obtendo coordenas, atualizando tabuleiro
     * Jogando com dois jogadores
     * @param jogador1
     * @param jogador2
     * @param tabuleiro 
     */
    public void jogandoComJogador1eJogador2(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro){
        /**
         * Loop que roda enquanto não tiver um ganhador ou o tabuleiro vazio
         */
        
        while(tabuleiro.checaSeTabuleiroCheio()){
            
            obtendoCoordenadas(tabuleiro, jogador1, this.nJogador1, true);
            
            verificaLocalOcupado(jogador1, tabuleiro, this.nJogador1);
            
            /**
             * Verifica se tem um ganhador após o jogador1 realizar a jogada
             */
            if(!jogador1.checandoGanhador(tabuleiro).equals("CONTINUE")){
                limpa();
                System.out.println("" + tabuleiro.formaTabuleiro());
                System.out.println("" + jogador1.checandoGanhador(tabuleiro));
                break;
            }
            
            obtendoCoordenadas(tabuleiro, jogador2, this.nJogador2, true);
            
            verificaLocalOcupado(jogador2, tabuleiro, this.nJogador2);
            
            /**
             * Verifica se tem um ganhador após o jogador2 realizar a jogada
             */
            if(!jogador2.checandoGanhador(tabuleiro).equals("CONTINUE")){
                limpa();
                System.out.println("" + tabuleiro.formaTabuleiro());
                System.out.println("" + jogador2.checandoGanhador(tabuleiro));
                break;
            }            
        }
    }
    /**
     * Lógica do jogo, realizando as jogadas, obtendo coordenas, atualizando tabuleiro
     * Jogando com o computador
     * @param jogador1
     * @param jogador2
     * @param tabuleiro 
     */
    public void jogandoComJogador1eComputador(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro){
        /**
         * Loop que roda enquanto não tiver um ganhador ou o tabuleiro vazio
         */
        
        while(tabuleiro.checaSeTabuleiroCheio()){
            
            obtendoCoordenadas(tabuleiro, jogador1, this.nJogador1, true);
            
            verificaLocalOcupado(jogador1, tabuleiro, this.nJogador1);
            
            /**
             * Verifica se tem um ganhador após o jogador1 realizar a jogada
             */
            if(!jogador1.checandoGanhador(tabuleiro).equals("CONTINUE")){
                limpa();
                System.out.println("" + tabuleiro.formaTabuleiro());
                System.out.println("" + jogador1.checandoGanhador(tabuleiro));
                break;
            }
            
            coordenadasComputador(jogador2, tabuleiro);
            
            /**
             * Verifica se tem um ganhador após o jogador2 realizar a jogada
             */
            if(!jogador2.checandoGanhador(tabuleiro).equals("CONTINUE")){
                limpa();
                System.out.println("" + tabuleiro.formaTabuleiro());
                System.out.println("" + jogador2.checandoGanhador(tabuleiro));
                break;
            }            
        }
    }
    
    /**
     * Obtendo as coordenadas para realizar a jogada.
     * @param tabuleiro
     * @param jogador 
     * @param nJogador o jogador ao qual vai fazer a jogada
     * @param permissao gambiarra que interrompe o metodo de limpar();
     */
    private void obtendoCoordenadas(Tabuleiro tabuleiro, Jogador jogador, int nJogador, boolean permissao){
        do{
            if(permissao){
                limpa();
            }
            System.out.println("" + tabuleiro.formaTabuleiro());
            System.out.println("JOGADOR " + nJogador);
            System.out.println("Coordenada X: \b");
            jogador.setX(teclado.nextInt());
            System.out.println("Coordenada Y: \b");
            jogador.setY(teclado.nextInt());
            if((jogador.getX() < 0) || (jogador.getX() > 2) || (jogador.getY() < 0) || (jogador.getY() > 2)){
                limpa();
                System.out.println("Tente novamente");
                System.out.println("Coordenadas fora do intervalo\n");
                permissao = false;
            }
        }while((jogador.getX() < 0) || (jogador.getX() > 2) || (jogador.getY() < 0) || (jogador.getY() > 2));
    }
    /**
     * Se o local estiver ocupado informa e pede as coordenadas novamente
     * @param jogador o que está realizando a jogada
     * @param tabuleiro
     * @param nJogador  numero do jogador
     */
    private void verificaLocalOcupado(Jogador jogador, Tabuleiro tabuleiro, int nJogador){
        while(!jogador.realizandoJogada(tabuleiro)){
            limpa();
            System.out.println("Local já ocupado");
            System.out.println("Tente novamente\n");
            obtendoCoordenadas(tabuleiro, jogador, nJogador, false);
        }
    }
    /**
     * Gambiarra para limpar a tela
     */
    private void limpa(){
        for(int i=0; i<20; i++){
            System.out.println("");
        }
    }
    
    public int menu(){
        System.out.println("JOGAR COM:");
        System.out.println("<1> COMPUTADOR.");
        System.out.println("<2> JOGADOR 1 x JOGADOR 2");
        return teclado.nextInt();
    }
    
    /**
     * Enquanto jogada inválida obtem novas coordenadas
     * @param jogador
     * @param tabuleiro 
     */
    private void coordenadasComputador(Jogador jogador,Tabuleiro tabuleiro){
        while(!jogador.realizandoJogada(tabuleiro)){
            setCoordenadas(jogador);
        }
    }
    
    /**
     * Setando as coordenadas X e Y apartir do numero gerado no random
     * @param jogador 
     */
    private void setCoordenadas(Jogador jogador){
        int numero = random.nextInt(8);
        switch (numero) {
            case 0:
                jogador.setX(0);
                jogador.setY(0);
                break;
            case 1:
                jogador.setX(0);
                jogador.setY(1);
                break;
            case 2:
                jogador.setX(0);
                jogador.setY(2);
                break;
            case 3:
                jogador.setX(1);
                jogador.setY(0);
                break;
            case 4:
                jogador.setX(1);
                jogador.setY(1);
                break;
            case 5:
                jogador.setX(1);
                jogador.setY(2);
                break;
            case 6:
                jogador.setX(2);
                jogador.setY(0);
                break;
            case 7:
                jogador.setX(2);
                jogador.setY(1);
                break;
            default:
                jogador.setX(2);
                jogador.setY(2);
                break;
        }
    }
}
