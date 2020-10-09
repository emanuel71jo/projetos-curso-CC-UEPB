/** Classe OitoRainhasFB
 *  Utiliza técnica de força bruta aleatória.
 * */ 

import java.security.SecureRandom;

public class OitoRainhasFB{
    private static SecureRandom sorteio = new SecureRandom();

    public static final int TAMANHO = 8;
    private static char[][] tabuleiro;
    private static int rainhas;

    // Método para validar um movimento
    public static boolean movimentoValido(int linha, int coluna){
        return (linha >= 0 && linha < TAMANHO && coluna >= 0 && coluna < TAMANHO);
    } // Fim do método movimentoValido

    // Método para verificar se há casas do tabuleiro disponíveis
    public static boolean casaDisponivel(){
        for(int linha = 0; linha < tabuleiro.length; linha++){
            for(int coluna = 0; coluna < tabuleiro[linha].length; coluna++){
                if(tabuleiro[linha][coluna] == '\0')  // pode usar: (char) 0
                    return true;
            } // Fim do for interno
        } // Fim do for externo
        
        return false;
    } // Fim do método casaDisponivel

    // Falha 1: Havia digitado *verficarRainha* (correto é: verificarRainha)
    // Verifica se uma rainha pode ser colocada sem ataque
    public static boolean verificarRainha(int valorLinha, int valorColuna){
        int linha = valorLinha, coluna = valorColuna;

        // Verificar linha e coluna para uma rainha
        for(int posicao = 0; posicao < TAMANHO; posicao++){
            if(tabuleiro[linha][posicao] == 'R' || tabuleiro[posicao][coluna] == 'R')
                return false;
        }

        // Verificar diagonal superior esquerda
        for(int casa = 0; casa < TAMANHO && movimentoValido(--linha, --coluna); casa++){
            if(tabuleiro[linha][coluna] == 'R')
                return false;
        }

        // Retoma os valores de linha e coluna
        linha = valorLinha;
        coluna = valorColuna;

        // diagonal superior direita
        for(int diagonal = 0; diagonal < TAMANHO && movimentoValido(--linha, ++coluna); diagonal++){
            if(tabuleiro[linha][coluna] == 'R')
                return false;
        }

        // Retoma os valores de linha e coluna
        linha = valorLinha;
        coluna = valorColuna;

        // diagonal inferior esquerda
        for(int diagonal = 0; diagonal < TAMANHO && movimentoValido(++linha, --coluna); diagonal++){
            if(tabuleiro[linha][coluna] == 'R'){
                return false;
            }
        }

        // Retoma os valores de linha e coluna
        linha = valorLinha;
        coluna = valorColuna;

        // diagonal inferior direita
        for(int diagonal = 0; diagonal < TAMANHO && movimentoValido(++linha, ++coluna); diagonal++){
            if(tabuleiro[linha][coluna] == 'R')
                return false;
        }

        // Falha 2: faltou escrever essa instrução (:
        return true;  // sem colisões entre as rainhas

    }  // Fim do método verificarRainha

    // Falha 3: os métodos abaixo estavam no escopo do método...
    // ... verificarRainha(int, int)
    // Marcações NSLO: onde não colocar uma rainha
    public static void marcacoes(int linha, int coluna){
        for(int i = 0; i < TAMANHO; i++){
            
            // Marque uma linha ocupada com rainha
            if(tabuleiro[linha][i] == '\0')  // '\0' é equivalente a: (char) 0
                tabuleiro[linha][i] = '+';

            // Marque uma coluna ocupada com rainha
            if(tabuleiro[i][coluna] == '\0')  // '\0' é equivalente a: (char) 0
                tabuleiro[i][coluna] = '+';
        } // Fim do for

        // Marque as diagonais ocupadas com rainha
        marcacoesDiagonais(linha, coluna);

    } // Fim do método marcacoes

    // Marcações nas 4 direções diagonais (superiores e inferiores, esquerdas e direitas)
    public static void marcacoesDiagonais(int valorLinha, int valorColuna){
        int linha = valorLinha, coluna = valorColuna;

        /**
        * 
        * if(i == linha+coluna-j || i == linha-coluna+j) {  // bloqueia as diagonais
			this.tabuleiro[i][j] = '+';
           }
        */
            
        // diagonal superior esquerda
        for(int diagonal = 0; diagonal < TAMANHO && movimentoValido(--linha, --coluna); diagonal++){
            tabuleiro[linha][coluna] = '+';
        }

        // Retoma valores passados na chamada do método
        linha = valorLinha;
        coluna = valorColuna;

        // diagonal superior direita
        for(int diagonal = 0; diagonal < TAMANHO && movimentoValido(--linha, ++coluna); diagonal++){
            tabuleiro[linha][coluna] = '+';
        }

        // Retoma valores passados na chamada do método
        linha = valorLinha;
        coluna = valorColuna;

        // diagonal inferior direita
        for(int diagonal = 0; diagonal < TAMANHO && movimentoValido(++linha, ++coluna); diagonal++){
            tabuleiro[linha][coluna] = '+';
        }

        // Retoma valores passados na chamada do método
        linha = valorLinha;
        coluna = valorColuna;

        // diagonal inferior esquerda
        for(int diagonal = 0; diagonal < TAMANHO && movimentoValido(++linha, --coluna); diagonal++){
               tabuleiro[linha][coluna] = '+';
        }
    } // Fim do método marcacoesDiagonais

    // Imprime o tabuleiro
    public static void imprimeTabuleiro(){
        
        for(int i = 0; i < TAMANHO; i++)    
            System.out.printf("\t%d", i);

        System.out.printf("\n\n");

        for(int linha = 0; linha < tabuleiro.length; linha++){
            
            System.out.printf("%d", linha);  // Falha 4: corrigi aqui o printf

            for(int coluna = 0; coluna < tabuleiro[linha].length; coluna++){
                System.out.printf("\t%c", tabuleiro[linha][coluna]);
            } // For interno

            System.out.printf("\n\n");
        } // For externo

        System.out.printf("\nForam %d rainhas posicionadas no tabuleiro.\n\n", rainhas);
  
    } // Fim do método imprimeTabuleiro

    // O main para colocar as rainhas no tabuleiro
    public static void main(String args[]){

        while(rainhas < TAMANHO){

            int moveLinha;
            int moveColuna;
            
            // campo para indicar que todas as casas foram preenchidas
            boolean concluido = false;

            tabuleiro = new char[TAMANHO][TAMANHO];
            rainhas = 0;
            
            // Laço para colocar rainhas enquanto houver casas
            // Ou se ainda faltar alguma rainha
            while(!concluido){
                
                // sorteie duas posições (movimentos)
                moveLinha = sorteio.nextInt(8);
                moveColuna = sorteio.nextInt(8);

                // Se movimento válido, coloque a rainha
                // e retire marcações de colisão
                if(verificarRainha(moveLinha, moveColuna)){
                    tabuleiro[moveLinha][moveColuna] = 'R';
                    marcacoes(moveLinha, moveColuna);
                    ++rainhas;
                }

                // Sem casas disponíveis, concluído o processo.
                if(!casaDisponivel()){
                    concluido = true;
                }
            } // Fim do while interno
        } // Fim do while externo

        imprimeTabuleiro();

    } // Fim do método main
} // Fim da classe OitoRainhasFB





// Adaptado de: Deitel & Deitel. Java como programar. 10 ed.