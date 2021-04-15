
package laboratorio06;

/**
 *
 * @author João Emanuel
 */

public class Tabuleiro {
    private final char[][] tabuleiro = new char[3][3];
    
    /**
     * Construtor que inicializa o tabuleiro com o espaço vazio.
     */
    public Tabuleiro(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.tabuleiro[i][j] = ' ';
            }
        }
    }
    
    /**
     * Cria o tabuleiro
     * @return o formato do tabuleiro 
     */
    public String formaTabuleiro(){
        String quebra = "-----------";
        String tab1 = " " + this.tabuleiro[0][0] + " | " + this.tabuleiro[0][1] + " | " + this.tabuleiro[0][2];
        String tab2 = " " + this.tabuleiro[1][0] + " | " + this.tabuleiro[1][1] + " | " + this.tabuleiro[1][2];
        String tab3 = " " + this.tabuleiro[2][0] + " | " + this.tabuleiro[2][1] + " | " + this.tabuleiro[2][2];
        return tab1 + "\n" + quebra + "\n" + tab2 + "\n" + quebra + "\n" + tab3;
    }
    
    /**
     * Atualiza o estado do tabuleiro
     * @param x coordenada da linha
     * @param y coordenada da coluna
     * @param jogada char da jogada 'X' ou 'O'
     * @return se foi bem sucedida a atualização do tabuleiro
     */
    public boolean estadoTabuleiro(int x, int y, char jogada){
        if(this.tabuleiro[x][y] == ' '){
            this.tabuleiro[x][y] = jogada;
            return true;
        }
        return false;
    }
    
    /**
     * Verificando se o tabuleiro está completo
     * @return true se não está cheio e false se está completo.
     */
    public boolean checaSeTabuleiroCheio(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(this.tabuleiro[i][j] == ' '){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Verificar se já tem um vencedor.
     * @param caracter 'X' ou 'O'
     * @return false se tem ganhador e true se não tem.
     */
    public boolean verificandoSeGanhou(char caracter){
        if((this.tabuleiro[0][0] & this.tabuleiro[0][1] & this.tabuleiro[0][2]) == caracter){
            return false;
        }else if ((this.tabuleiro[1][0] & this.tabuleiro[1][1] & this.tabuleiro[1][2]) == caracter){
            return false;
        }else if ((this.tabuleiro[2][0] & this.tabuleiro[2][1] & this.tabuleiro[2][2]) == caracter){
            return false;
        }else if ((this.tabuleiro[0][0] & this.tabuleiro[1][0] & this.tabuleiro[2][0]) == caracter){
            return false;
        }else if ((this.tabuleiro[0][1] & this.tabuleiro[1][1] & this.tabuleiro[2][1]) == caracter){
            return false;
        }else if ((this.tabuleiro[0][2] & this.tabuleiro[1][2] & this.tabuleiro[2][2]) == caracter){
            return false;
        }else if ((this.tabuleiro[0][0] & this.tabuleiro[1][1] & this.tabuleiro[2][2]) == caracter){
            return false;
        }else if ((this.tabuleiro[0][2] & this.tabuleiro[1][1] & this.tabuleiro[2][0]) == caracter){
            return false;
        }
        return true;
    }
    
    /**
     * 
     * @return tabuleiro 
     */
    public char[][] getTabuleiro() {
        return tabuleiro;
    }
    
    
}
