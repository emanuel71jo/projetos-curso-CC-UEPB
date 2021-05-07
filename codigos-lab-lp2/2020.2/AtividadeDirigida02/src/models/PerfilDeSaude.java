package models;

import java.util.Calendar;

public class PerfilDeSaude {
	private String firstName;
	private String lastName;
	private String sexo;
	private int day;
	private int month;
	private int year;
	private float height;
	private float weight;
	
	public PerfilDeSaude(String firstName, String lastName, String sexo, int day, int month, int year, float height,
			float weight) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sexo = sexo;
		this.day = day;
		this.month = month;
		this.year = year;
		this.height = height;
		this.weight = weight;
	}
	
	public void showTableIMC() {
		System.out.println("Magreza: quando o resultado é menor que 18,5 kg/m²");
		System.out.println("Normal: quando o resultado está entre 18,5 e 24,9 kg/m²");
		System.out.println("Sobrepeso: quando o resultado está entre 24,9 e 30 kg/m²");
		System.out.println("Obesidade: quando o resultado é maior que 30 kg/m²");
	}
	
	public float getIMC() {
		return (float) (this.weight / (Math.pow(this.height, 2)));
	}
	
	public int getAge() {
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		
		return year - this.year;
	}
	
	public float targetHeartFrequency() {
		return (float) (this.maxHeartFrequency() * 0.5);
	}
	
	public int maxHeartFrequency() {
		return 220 - this.getAge();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
	
}
