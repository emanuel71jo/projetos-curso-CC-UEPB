package roteiro2;

public class Vendas {
	private String dataVenda, codVenda ;
	public LinhaDeVendas[] linhaDeVendas;
	public Cliente cliente;
	
	public Vendas(String dataVenda, LinhaDeVendas[] linhaDeVendas, Cliente cliente, String cod) {
		this.dataVenda = dataVenda;
		this.linhaDeVendas = linhaDeVendas;
		this.cliente = cliente;
                this.codVenda = cod;
                cliente.inserirVenda(this);
	}

        /**
         * retorna o total da venda com desconto se possivel
         * @return s
         */
	public double getTotalVenda() {
            double totalVenda = 0;
            for(int i = 0; i < linhaDeVendas.length; i++){
                totalVenda += linhaDeVendas[i].getSubTotal();
            }
            if(cliente.desconto()){
                if(totalVenda > 200){
                    totalVenda *= 0.8;
                }
                totalVenda *= 0.9;
            }
            
            return totalVenda;
	}
        
        public LinhaDeVendas[] pedidosCliente(){
            return linhaDeVendas;
        }

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
                
        public String codVenda(){
            return this.codVenda;
        }
}
