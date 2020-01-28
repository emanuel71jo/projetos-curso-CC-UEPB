package lab07;

public class Contribuinte {

	private String nome;
	private int numero;
	private Casa casa;
	private Carro carro;

	/**
	 * Construtor da classe Contribuinte
	 * 
	 * @param nome   : Nome do contribuinte
	 * @param numero : numero do contribuinte
	 * @param casa   : Casa do contribuinte(pode ser null)
	 * @param carro  : Carro do contribuinte(pode ser null)
	 */
	public Contribuinte(String nome, int numero, Casa casa, Carro carro) {
		this.nome = nome;
		this.numero = numero;
		this.casa = casa;
		this.carro = carro;
	}

	/**
	 * getNome() : Nome do contribuinte
	 * 
	 * @return   : Uma string contendo o nome do contribuinte 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * getNumero() : Número do contribuinte
	 * 
	 * @return   : Um inteiro contendo o número do contribuinte 
	 */
	public int getNumero() {
		return numero;
	}
	
	/**
	 * calculaImposto() : Calcula o imposto do contribuinte
	 * 
	 * @return : Retorna o valor dos tributos menos os valores do desconto
	 */
	public double calculaImposto() {
		return this.calculaTributo() - this.calculaDescontos();
	}

	/**
	 * calculaRiqueza() : Calcula os bens do contribuinte
	 * 
	 * @return : Retorna a soma dos valores dos bens do contribuinte. Se não possuir
	 *         nenhum dos dois bens, retorna 0.
	 */
	protected double calculaRiqueza() {
		double valor = 0.0;

		if (this.hasCasa())
			valor += this.casa.getValor();

		if (this.hasCarro())
			valor += this.carro.getValor();

		return valor;
	}

	/**
	 * calculDescontos : Calcula o valor a ser descontado do imposto
	 * 
	 * @return : Retorna o valor de desconto baseado nas peculiaridades de cada profissão
	 */
	protected double calculaDescontos() {
		return 0;
	}
	
	/**
	 * calculDescontos : Calcula o valor a ser tributado
	 * 
	 * @return : Retorna o valor a ser tributo baseado nas peculiaridades de cada profissão
	 */
	protected double calculaTributo() {
		return 0;
	}

	/**
	 * hasCasa(): Verifica se o contribuinte possui um imóvel.
	 * 
	 * @return : Retorna false se o objeto casa for null. Se não retorna true
	 */
	public boolean hasCasa() {
		if (this.casa == null)
			return false;

		return true;
	}

	/**
	 * hasCarro(): Verifica se o contribuinte possui um automóvel.
	 * 
	 * @return : Retorna false se o objeto carro for null. Se não retorna true
	 */
	public boolean hasCarro() {
		if (this.carro == null)
			return false;

		return true;
	}

}
