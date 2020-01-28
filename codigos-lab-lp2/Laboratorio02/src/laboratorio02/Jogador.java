
package laboratorio02;

import java.util.Scanner;

public class Jogador {
    //Teclado
    Scanner teclado = new Scanner(System.in);
    //Atributos
    private int jogada;
    //Metodos
    public void jogando(int n){
        do{
            System.out.println("JOGADOR " + n);
            System.out.println("Pedra (1), Papel (2), Tesoura (3)?");
            this.jogada = teclado.nextInt();
            if(this.jogada < 1 || this.jogada > 3){
                System.out.println("Opcao inválida");
                System.out.println("Tente novamente");
            }
        }while(this.jogada < 1 || this.jogada > 3);
    }
    //Metodos especiais
    public int getJogada() {
        return jogada;
    }    
}
