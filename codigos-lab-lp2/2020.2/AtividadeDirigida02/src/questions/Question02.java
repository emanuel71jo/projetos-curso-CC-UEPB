package questions;

import java.util.Scanner;

import models.PerfilDeSaude;

public class Question02 {
	static public void run() {
		Scanner input = new Scanner(System.in);
		
		String firstName;
		String lastName;
		int day;
		int month;
		int year;
		String sexo;
		float height;
		float weight;
		
		
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
		System.out.println("Sexo: M ou F");
		sexo = input.next();
		System.out.println("Altura: ");
		height = input.nextFloat();
		System.out.println("Peso: ");
		weight = input.nextFloat();
		
		PerfilDeSaude ps = new PerfilDeSaude(firstName, lastName, sexo, day, month, year, height, weight);
		
		System.out.println("Nome: " + ps.getFirstName() + " " + ps.getLastName());
		System.out.println("Nascimento: " + ps.getDay() + "/" + ps.getMonth() + "/" + ps.getYear());
		System.out.println("Anos: " + ps.getAge() + " anos");
		System.out.println("Sexo: " + ps.getSexo());
		System.out.println("Altura: " + ps.getHeight());
		System.out.println("Peso: " + ps.getWeight());
		System.out.println("Sua frenquência cardiaca máxima é: " + ps.maxHeartFrequency());
		System.out.println("Sua frequência cardiaca alvo é: " + ps.targetHeartFrequency());
		System.out.println("IMC: " + ps.getIMC());
		ps.showTableIMC();
		
	}
}
