package question02;

public class Empregado {
	private String firstName;
	private String lastName;
	private String ocupation;
	
	public Empregado(String firstName, String lastName, String ocupation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ocupation = ocupation;
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
	public String getOcupation() {
		return ocupation;
	}
	public void setOcupation(String ocupation) {
		this.ocupation = ocupation;
	}
	@Override
	public String toString() {
		return "Empregado [firstName=" + firstName + ", lastName=" + lastName + ", ocupation=" + ocupation + "]";
	}
}
