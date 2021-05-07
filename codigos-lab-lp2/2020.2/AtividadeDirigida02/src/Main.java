import java.util.Scanner;

import questions.Question01;
import questions.Question02;
import questions.Question03;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int option;
		
		do {
			
			System.out.println("MENU");
			System.out.println("1 - Questão 01");
			System.out.println("2 - Questão 02");
			System.out.println("3 - Questão 03");
			System.out.println("4 - SAIR");
			option = input.nextInt();
			renderOption(option);
			
		}while(option != 4);
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
			
		}
	}

}
