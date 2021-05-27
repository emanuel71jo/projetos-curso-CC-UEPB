package question01;

public class Question01 {
	public static void run() {
		System.out.println("Resposta da questão 1");
		try {
			throw new ExceptionB("Exception B");
		} catch (Exception e) {
			System.out.println("\tTestando a exceção B: " + e.getMessage());
		}
		
		try {
			throw new ExceptionC("Exception C");
		} catch (Exception e) {
			System.out.println("\tTestando a exceção C: " + e.getMessage());
		}
	}
}
