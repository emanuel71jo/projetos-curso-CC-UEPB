package roteiro2;

public class LinhaDeVendas {
	private  ItemProduto[] itemProduto;
	
	public LinhaDeVendas(ItemProduto[] itemProduto) {
		this.itemProduto = itemProduto;
	}

        /**
         * retorna o preco total dessa linha de venda, soma do
         * @return d
         */
	public double getSubTotal() {
            double subTotal = 0;
            calculaSubTotal(subTotal);
            return subTotal;
	}
        
        public int qtdItens(){
            return itemProduto.length;
        }
        
        public ItemProduto[] getItem(){
            return itemProduto;
        }
        
        /**
         * calcula o subtotal
         * @param subTotal d
         */
        private void calculaSubTotal(double subTotal) {
            for(int i = 0; i < itemProduto.length; i++){
                subTotal += itemProduto[i].getPrecoProduto();
            }    
        }
}
