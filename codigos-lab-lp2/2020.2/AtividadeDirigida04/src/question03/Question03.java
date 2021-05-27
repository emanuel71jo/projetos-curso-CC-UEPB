package question03;

public class Question03 {
	public static void run() {
		System.out.println("Resposta da questão 3");
		System.out.println("\tAo se utilizar uma interface, nós estamos criando tipo um set de métodos sem qualquer "
				+ "\nimplementação que deve ser herdado por outras classes já implementadas. A vantagem é que dessa forma "
				+ "\nconsegue-se prover um caminho para uma classe ser parte de duas classes: Uma herdada hierarquicamente "
				+ "\ne outra da Interface");
		System.out.println("\tAo se utilizar uma classe abstrata, nós estamos criando uma classe base que pode ter um ou mais "
				+ "\nmétodos completos, mas que pelo menos um ou mais destes métodos tem que ser criados sem corpo, pois é isso "
				+ "\nque caracteriza uma classe abstrata.");
		System.out.println("\tO significado de se utilizar uma Classe Abstrata é de prover uma base de definições de "
				+ "\ncomo um set de Classes Derivadas irão trabalhar e então permitir os programadores de preencher as "
				+ "\nimplementações nas Classes Derivadas.");
	}
}
