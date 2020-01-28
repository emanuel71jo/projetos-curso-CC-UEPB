package roteiro1;

public class LinhaDeVendas {
	private  ItemProduto[] itemProduto;
	
	public LinhaDeVendas(ItemProduto[] itemProduto) {
		this.itemProduto = itemProduto;
	}

	public double getSubTotal() {
            double subTotal = 0;
            for(int i = 0; i < itemProduto.length; i++){
                subTotal += itemProduto[i].getPrecoProduto();
            }
            return subTotal;
	}
        
        public ItemProduto[] getItem(){
            return itemProduto;
        }
}
