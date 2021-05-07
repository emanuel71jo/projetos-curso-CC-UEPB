package questions;

public class Question03 {
	static private double ONE_BILLION_AND_HALF = 1.5 * Math.pow(10, 9);
	static private double TWO_BILLIONS = 2 * Math.pow(10, 9);
	
	static public void run() {
		System.out.println("Levara " + getCountYears(ONE_BILLION_AND_HALF) + " para atingir 1,5 billhoes de usuários");
		System.out.println("Levara " + getCountYears(TWO_BILLIONS) + " para atingir 2 billhoes de usuários");
	}
	
	static private double getCountYears(double p) {
		return (double) (p * Math.pow((1 + 0.04), 9));
	}
}
