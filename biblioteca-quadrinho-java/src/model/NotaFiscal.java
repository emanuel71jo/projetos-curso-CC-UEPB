package model;

public class NotaFiscal {
	private double valor;
	private String dataCompra;
	private Quadrinho quadrinho;
	
	
	
	public NotaFiscal() {
	}

	public NotaFiscal(double valor, String dataCompra, Quadrinho quadrinho) {
		this.valor = valor;
		this.dataCompra = dataCompra;
		this.quadrinho = quadrinho;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Quadrinho getQuadrinho() {
		return quadrinho;
	}

	public void setQuadrinho(Quadrinho quadrinho) {
		this.quadrinho = quadrinho;
	}
	
}
