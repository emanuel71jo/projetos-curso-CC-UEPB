package questions;

public class Question03 {
	private int one = 1;
	private int two = 2;
	private int three = 3;
	private int four = 4;
	
	public void render() {
		System.out.println("Escreva um aplicativo que exiba os números 1 a 4 na mesma linha, com cada par de adjacentes separados por um espaço. Use as seguintes técnicas:");
		System.out.println("a) Faça com uma única instrução System.out.println.");
		System.out.println("b) Utilize quatro instruções System.out.print.");
		System.out.println("c) Utilize uma única instrução System.out.printf.");
		System.out.println("Resposta:");
		System.out.println("a) " + this.one + " " + this.two + " " + this.three + " " + this.four);
		System.out.print("b)");
		System.out.print(" " + this.one);
		System.out.print(" " + this.two);
		System.out.print(" " + this.three);
		System.out.print(" " + this.four + "\n");
		System.out.printf("c) %d %d %d %d\n", this.one, this.two, this.three, this.four);
		
	}
}
