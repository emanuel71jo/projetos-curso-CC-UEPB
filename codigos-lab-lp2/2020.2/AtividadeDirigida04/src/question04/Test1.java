package question04;

public class Test1 {
	public static String divide(int num1, int num2) {
		return String.format("%d dividido por %d é igual a %d", num1, num2, (num1 / num2));
	}
	
	public static void run() {
		System.out.println("Resposta da questão 4.1");
		try {
			System.out.println("\tO resultado da chamada divide(4, 2): " + divide(4, 2));
			System.out.println("\tO resultado da chamada divide(20, 5): " + divide(20, 5));
			divide(100, 0);
		} catch (Exception e) {
			System.out.println("\tO resultado da chamada divide(100, 0): " + e.toString());
		}
	}
}
