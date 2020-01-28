package roteiro2;

public class ItemProduto {
	private String codItem, lote, dataChegada;
	public Produto produto;

	public ItemProduto(String codItem, String lote, String dataChegada, Produto produto) {
		this.codItem = codItem;
		this.lote = lote;
		this.dataChegada = dataChegada;
		this.produto = produto;
	}

	public String getCodItem() {
		return codItem;
	}

	public void setCodItem(String codItem) {
		this.codItem = codItem;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(String dataChegada) {
		this.dataChegada = dataChegada;
	}
        
        public double getPrecoProduto(){
            return produto.getPrecoProduto();
        }
	
	
}
