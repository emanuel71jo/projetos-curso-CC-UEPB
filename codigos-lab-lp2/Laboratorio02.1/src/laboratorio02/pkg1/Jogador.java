
package laboratorio02.pkg1;

import java.util.Random;
import java.util.Scanner;

public class Jogador {
    //Teclado
    Scanner teclado = new Scanner(System.in);
    Random random =  new Random();
    //Atributos
    private int jogada;
    //Metodos
    public boolean jogando(int n){
        if(n == 2){
            this.jogada = 1 + random.nextInt(2);
            System.out.println("Pedra (1), Papel (2), Tesoura (3)?");
            System.out.println("--->" + this.jogada);
            return true;
        }else{
            do{
                System.out.println("JOGADOR " + n);
                System.out.println("Pedra (1), Papel (2), Tesoura (3)?");
                System.out.print("--->");
                this.jogada = teclado.nextInt();
                if(this.jogada < 1 || this.jogada > 3){
                    System.out.println("Opcao inválida");
                    System.out.println("Tente novamente");
                }
            }while(this.jogada < 1 || this.jogada > 3);
            return false;
        }
    }
    //Metodos especiais
    public int getJogada() {
        return jogada;
    }
}
