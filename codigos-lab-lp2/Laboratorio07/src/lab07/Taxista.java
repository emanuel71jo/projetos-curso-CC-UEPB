package lab07;

public class Taxista extends Contribuinte {

	private static final double TAXA = 0.5, DESCONTOKM = 0.01;

	private int numPassageiros;
	private double kmRodados;

	public Taxista(String nome, int numero, Casa casa, Carro carro, int numPassageiros, double kmRodados) {
		super(nome, numero, casa, carro);
		this.numPassageiros = numPassageiros;
		this.kmRodados = kmRodados;
	}

	@Override
	protected double calculaDescontos() {
		return this.kmRodados * DESCONTOKM;
	}

	@Override
	protected double calculaTributo() {
		return this.numPassageiros * TAXA;
	}

}
