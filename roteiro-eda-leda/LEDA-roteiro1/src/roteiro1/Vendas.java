package roteiro1;

public class Vendas {
	private String dataVenda, codVenda ;
	public LinhaDeVendas[] linhaDeVendas;
	public Cliente cliente;
	public Empresa empresa;
	
	public Vendas(String dataVenda, LinhaDeVendas[] linhaDeVendas, Empresa empresa, Cliente cliente, String cod) {
		this.dataVenda = dataVenda;
		this.linhaDeVendas = linhaDeVendas;
		this.cliente = cliente;
		this.empresa = empresa;
                this.codVenda = cod;
	}

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
