
package laboratorio02.pkg1;

import java.util.Scanner;

public class Laboratorio021 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char teste = 'S';
        String ganhador;
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        Jogando jogar = new Jogando();
        do{
            jogador1.jogando(1);
            jogador2.jogando(2);
            ganhador = jogar.verificandoGanhador(jogador1, jogador2);
            System.out.println("Ganhador: " + ganhador);
            if(!"EMPATE".equals(ganhador)){
                System.out.println("Deseja jogar novamente? [S/N]");
                teste = teclado.next().charAt(0);
            }     
        }while(teste != 'n' && teste != 'N');
    }
}
