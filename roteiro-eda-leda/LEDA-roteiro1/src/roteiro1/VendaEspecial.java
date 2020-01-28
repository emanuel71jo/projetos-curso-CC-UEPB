
package roteiro1;

public class VendaEspecial extends Vendas{
    
    public VendaEspecial(String dataVenda, LinhaDeVendas[] linhaDeVendas, Empresa empresa, Cliente cliente, String cod) {
        super(dataVenda, linhaDeVendas, empresa, cliente, cod);
    }
    
    @Override
    public double getTotalVenda() {
            double totalVenda = 0;
            for(int i = 0; i < super.linhaDeVendas.length; i++){
                totalVenda += super.linhaDeVendas[i].getSubTotal();
            }
            if(cliente.desconto()){
                if(totalVenda > 200){
                    totalVenda *= 0.8;
                }
                totalVenda *= 0.9;
            }
            
            return totalVenda * 0.9;
	}
    
}
