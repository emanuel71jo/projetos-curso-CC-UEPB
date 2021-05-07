package questions;

import java.util.Scanner;

import models.FrequenciaCardiaca;

public class Question01 {
	static public void run() {
		Scanner input = new Scanner(System.in);
		
		String firstName;
		String lastName;
		int day;
		int month;
		int year;
		
		System.out.println("Primeiro nome:");
		firstName = input.next();
		System.out.println("Sobrenome");
		lastName = input.next();
		System.out.println("Dia de Nascimento");
		day = input.nextInt();
		System.out.println("Mês de Nascimento");
		month = input.nextInt();
		System.out.println("Ano de Nascimento");
		year = input.nextInt();
		
		FrequenciaCardiaca fc = new FrequenciaCardiaca(firstName, lastName, day, month, year);
		System.out.println("A idade de " + fc.getFirstName() + " é " + fc.getAge());
		System.out.println("Sua frenquência cardiaca máxima é: " + fc.maxHeartFrequency());
		System.out.println("Sua frequência cardiaca alvo é: " + fc.targetHeartFrequency());
	}	
}
