package lab07;

public class Medico extends Contribuinte {

	private static final double TAXA = 10.0;

	private int atendimentos;
	private double congressos;

	public Medico(String nome, int numero, Casa casa, Carro carro, int atendimentos, double congressos) {
		super(nome, numero, casa, carro);
		this.atendimentos = atendimentos;
		this.congressos = congressos;

	}

	@Override
	protected double calculaDescontos() {
		return this.congressos;

	}

	@Override
	protected double calculaTributo() {
		return this.atendimentos * TAXA;

	}
}
