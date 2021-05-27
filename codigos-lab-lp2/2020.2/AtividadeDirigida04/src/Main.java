import java.util.Scanner;

import question01.Question01;
import question02.Question02;
import question03.Question03;
import question04.Test1;
import question04.Test2;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int option;
		
		do {
			System.out.println("MENU");
			System.out.println("1 - Questão 01");
			System.out.println("2 - Questão 02");
			System.out.println("3 - Questão 03");
			System.out.println("4 - Questão 4.1");
			System.out.println("5 - Questão 4.2");
			System.out.println("6 - SAIR");
			option = input.nextInt();
			renderOption(option);
		}while(option != 6);
		
		input.close();
	}
	
	public static void renderOption(int option) {
		switch(option) {
			case 1: {
				Question01.run();
				break;
			}
			case 2: {
				Question02.run();
				break;
			}
			case 3: {
				Question03.run();
				break;
			}
			case 4: {
				Test1.run();
				break;
			}
			case 5: {
				Test2.run();
				break;
			}
		}
	}
}
