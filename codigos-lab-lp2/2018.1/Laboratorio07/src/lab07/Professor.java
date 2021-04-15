package lab07;

public class Professor extends Contribuinte {

	private static final double SALARIOMIN = 700.0;

	private double salario, material;

	public Professor(String nome, int numero, Casa casa, Carro carro, double salario, double material) {
		super(nome, numero, casa, carro);
		this.salario = salario;
		this.material = material;
	}

	@Override
	protected double calculaDescontos() {
		return this.material / 2;
	}

	@Override
	protected double calculaTributo() {
		if (this.salario <= SALARIOMIN)
			return this.salario * 0.05;

		else if (this.salario <= SALARIOMIN * 5)
			return this.salario * 0.10;

		else
			return this.salario * 0.20;
	}

}
