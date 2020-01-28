
package laboratorio02;

import java.util.Scanner;

public class Laboratorio02 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char teste;
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        Jogando jogar = new Jogando();
        do{
            jogador1.jogando(1);
            jogador2.jogando(2);
            System.out.println("Ganhador: " + jogar.verificandoGanhador(jogador1, jogador2));
            System.out.println("Deseja jogar novamente? [S/N]");
            teste = teclado.next().charAt(0);
        }while(teste != 'n' && teste != 'N');
    }
}