package questions;

public class Question01 {
	private int x = 2;
	private int y = 3;
	
	public void render() {
		System.out.println("Supondo que x = 2 e y = 3, o que cada uma das instruções a seguir exibe?");
		System.out.println("a) System.out.printf(“x = %d%n”, x);");
		this.letterA();
		System.out.println("b) System.out.printf(“Valor de %d + %d é igual %d%n”, x, x, (x + x));");
		this.letterB();
		System.out.println("c) System.out.printf(“x =”);");
		this.letterC();
		System.out.println("d) System.out.printf(“%d = %d%n”, (x + y), (y + x));");
		this.letterD();
	}
	
	private void letterA() {
		System.out.println("Resposta: ");
		System.out.printf("x = %d%n", this.x);
	}
	
	private void letterB(){
		System.out.println("Resposta: ");
		System.out.printf("Valor de %d + %d é igual %d%n", this.x, this.x, (this.x + this.x));
	}
	
	private void letterC() {
		System.out.println("Resposta: ");
		System.out.printf("x =\n");
	}
	
	private void letterD() {
		System.out.println("Resposta: ");
		System.out.printf("%d = %d%n", (this.x + this.y), (this.y + this.x));
	}
}
