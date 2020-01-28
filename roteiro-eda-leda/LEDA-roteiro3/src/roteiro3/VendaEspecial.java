
package roteiro3;

public class VendaEspecial extends Vendas{
    
    public VendaEspecial(LinhaDeVendas[] linhaDeVendas, Cliente cliente, String cod) {
        super(linhaDeVendas, cliente, cod);
    }
    
    /**
     * retorna o total da venda com desconto
     * @return ss
     */
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
