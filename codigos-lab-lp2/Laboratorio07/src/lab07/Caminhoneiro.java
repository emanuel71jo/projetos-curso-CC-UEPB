package lab07;

public class Caminhoneiro extends Contribuinte {

	private static final double TAXA = 500, DESCONTOKM = 0.01;
	private double toneladas, kmRodados;

	public Caminhoneiro(String nome, int numero, Casa casa, Carro carro, double toneladas, double kmRodados) {
		super(nome, numero, casa, carro);
		this.toneladas = toneladas;
		this.kmRodados = kmRodados;
	}

	@Override
	protected double calculaDescontos() {
		return this.kmRodados * DESCONTOKM;
	}

	@Override
	protected double calculaTributo() {
		if (this.toneladas <= 10)
			return TAXA;
		else
			return (this.toneladas - 10) * 100 + TAXA;
	}
}
