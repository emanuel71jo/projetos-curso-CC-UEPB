package questions;

public class Question02 {
	
	private int a = 2;
	private int x = 5;
	
	public void render() {
		System.out.println("Dado que y = ax3 + 7, quais das seguintes alternativas são instruções Java corretas para essa equação?");
		System.out.println("a) y = a * x * x * x + 7;");
		System.out.println("b) y = a * x * x * (x + 7);");
		System.out.println("c) y = (a * x) * x * (x + 7);");
		System.out.println("d) y = (a * x) * x * x + 7;");
		System.out.println("e) y = a * (x * x * x) + 7;");
		System.out.println("f) y = a * x * (x * x + 7);");
		System.out.println("Resposta: Supondo que a = 2, x = 5, temos: ");
		System.out.println("a) y = " + (this.a * this.x * this.x * this.x + 7));
		System.out.println("b) y = " + (this.a * this.x * this.x * (this.x + 7)));
		System.out.println("c) y = " + ((this.a * this.x) * this.x * (this.x + 7)));
		System.out.println("d) y = " + ((this.a * this.x) * this.x * this.x + 7));
		System.out.println("e) y = " + (this.a * (this.x * this.x * this.x) + 7));
		System.out.println("f) y = " + (this.a * this.x * (this.x * this.x + 7)));
		System.out.println("Resultado esperado da equação: y = " + (this.a * Math.pow(this.x, 3) + 7));
		System.out.println("Conclusão: De acordo com os resultados obtidos, concluimos que os itens A, D e E apresentam o resultado esperado da equação");
	}
}
