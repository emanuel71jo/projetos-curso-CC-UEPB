package roteiro1;

public class Produto {
	private String descricao, codProduto;
	private double precoProduto;
	
	public Produto(String descricao, String codProduto, double precoProduto) {
		this.descricao = descricao;
		this.codProduto = codProduto;
		this.precoProduto = precoProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}
	
	
	
}
