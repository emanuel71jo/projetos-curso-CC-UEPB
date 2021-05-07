package models;

import java.util.Calendar;

public class FrequenciaCardiaca {
	private String firstName;
	private String lastName;
	private int day;
	private int month;
	private int year;
	
	public FrequenciaCardiaca(String firstName, String lastName, int day, int month, int year) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public float targetHeartFrequency() {
		return (float) (this.maxHeartFrequency() * 0.5);
	}
	
	public int maxHeartFrequency() {
		return 220 - this.getAge();
	}
	
	public int getAge() {
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		
		return year - this.year;
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
	
	
		
	
}
