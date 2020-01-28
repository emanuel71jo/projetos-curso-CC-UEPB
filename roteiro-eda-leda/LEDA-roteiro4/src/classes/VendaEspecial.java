
package classes;

public class VendaEspecial extends Vendas{
    
    public VendaEspecial(LinhaDeVendas[] linhaDeVendas, Cliente cliente, String cod) {
        super(linhaDeVendas, cliente, cod);
    }
    
    /**
     * retorna o total da venda com desconto
     * @return ss
     */
    @Override
    public double calcularTotal() {
        double totalVenda = 0;
        for (LinhaDeVendas venda : super.linhaDeVendas) {
            totalVenda += venda.getSubTotal();
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
