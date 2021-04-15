import java.util.Scanner;

import questions.Question01;
import questions.Question02;
import questions.Question03;
import questions.Question04;
import questions.Question05;
import questions.Question06;
import questions.Question07;
import questions.Question08;
import questions.Question09;
import questions.Question10;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int option;
		
		do {
			
			System.out.println("MENU");
			System.out.println("1 - Questão 01");
			System.out.println("2 - Questão 02");
			System.out.println("3 - Questão 03");
			System.out.println("4 - Questão 04");
			System.out.println("5 - Questão 05");
			System.out.println("6 - Questão 06");
			System.out.println("7 - Questão 07");
			System.out.println("8 - Questão 08");
			System.out.println("9 - Questão 09");
			System.out.println("10 - Questão 10");
			System.out.println("11 - SAIR");
			option = input.nextInt();
			renderOption(option);
			
		}while(option != 11);
	}
	
	public static void renderOption(int option) {
		switch(option) {
			case 1: {
				Question01 question = new Question01();
				question.render();
				break;
			}
			case 2: {
				Question02 question = new Question02();
				question.render();
				break;
			}
			case 3: {
				Question03 question = new Question03();
				question.render();
				break;
			}
			case 4: {
				Question04 question = new Question04();
				question.render();
				break;
			}
			case 5: {
				Question05 question = new Question05();
				question.render();
				break;
			}
			case 6: {
				Question06 question = new Question06();
				question.render();
				break;
			}
			case 7: {
				Question07 question = new Question07();
				question.render();
				break;
			}
			case 8: {
				Question08 question = new Question08();
				question.render();
				break;
			}
			case 9: {
				Question09 question = new Question09();
				question.render();
				break;
			}
			case 10: {
				Question10 question = new Question10();
				question.render();
				break;
			}
		}
	}
}
