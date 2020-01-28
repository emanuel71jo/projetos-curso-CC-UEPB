
package laboratorio02;

public class Jogando {
    //Atributos
    private float res;
    // n = numero de elementos
    private final int n = 3;
    //Metodos
    public String verificandoGanhador(Jogador jogador1, Jogador jogador2){
        this.res = Math.abs((this.n + jogador1.getJogada() - jogador2.getJogada())% this.n);
        if(this.res == 0){
            return "EMPATE";
        }else if(this.res > this.n/2){
            return "JOGADOR 2";
        }else{
            return "JOGADOR 1";
        }
    }
}