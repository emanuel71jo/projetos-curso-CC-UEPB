package question04;

public class Test2 {
	public static void metodo3() throws RuntimeException {
		throw new RuntimeException("Houve uma RuntimeException no metodo3()");
	}
	
	public static void metodo2() throws RuntimeException {
		try {
			metodo3();
		} catch (RuntimeException e) {
			System.out.printf("\tA seguinte excessão ocorreu no metodo2()\n%s\n", e.toString());
			throw e;
		}
	}
	
	public static void metodo1() throws RuntimeException {
		try {
			metodo2();
		} catch (Exception e) {
			System.out.printf("\tA seguinte excessão ocorreu no metodo1()\n%s\n", e.toString());
			throw e;
		}
	}
	
	public static void run() {
		System.out.println("Resposta da questão 4.2");
		try {
			metodo1();
		} catch (Exception e) {
			System.out.printf("\tA seguinte excessão ocorreu no metodo run()\n%s\n", e.toString());
		}
	}
}
