
package laboratorio06;

/**
 *
 * @author João Emanuel
 */

public class Jogador {
    private int x , y, jogador;

    public Jogador(int jogador) {
        this.jogador = jogador;
    }
    
    /**
     * Realiza a jogada de um determinado jogador
     * @param tabuleiro objeto do Tabuleiro
     * @return true se foi bem sucedida a jogada
     * Jogador 1 = 'X' e Jogador 2 = 'O'
     */
    public boolean realizandoJogada(Tabuleiro tabuleiro){
        if(this.jogador == 1){
            return tabuleiro.estadoTabuleiro(this.x, this.y, 'X');
            
        }
        return tabuleiro.estadoTabuleiro(this.x, this.y, 'O');
    }
    
    public String checandoGanhador(Tabuleiro tabuleiro){
        if(!tabuleiro.checaSeTabuleiroCheio()){
            if(!tabuleiro.verificandoSeGanhou('X')){
                return "O GANHADOR FOI O JOGADOR 1";
            }else if(!tabuleiro.verificandoSeGanhou('O')){
                return "O GANHADOR FOI O JOGADOR 2";
            }
            return "O JOGO FOI EMPATE";
        }

        if(!tabuleiro.verificandoSeGanhou('O')){
            return "O GANHADOR FOI O JOGADOR 2";
        }else if(!tabuleiro.verificandoSeGanhou('X')){
            return "O GANHADOR FOI O JOGADOR 1";
        }
        return "CONTINUE";
    }
    
    // Métodos especiais.
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}
