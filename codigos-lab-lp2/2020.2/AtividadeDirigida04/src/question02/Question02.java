package question02;

public class Question02 {
	public static void run() {
		System.out.println("Resposta da questão 2");
		Empregado gerente = new Gerente("Joao", "Emanuel", "Programador");
		System.out.println("\tA) public class Gerente extends Empregado{}");
		System.out.println("\tB) " + gerente.toString());
		System.out.println("\tC) Empregado gerente = new Gerente(\\\"Joao\\\", \\\"Emanuel\\\", \\\"Programador\\\");");
	}
}
