package roteiro3;


public class Vendas implements Comparable<Vendas>{
    private String codVenda ;
    public LinhaDeVendas[] linhaDeVendas;
    public Cliente cliente;
    public Empresa empresa;

    public Vendas(LinhaDeVendas[] linhaDeVendas, Cliente cliente, String cod) {
            this.linhaDeVendas = linhaDeVendas;
            this.cliente = cliente;
            this.codVenda = cod;
            cliente.inserir(this);
            empresa.inserirVenda(this);
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

    public String codVenda(){
        return this.codVenda;
    }

    @Override
    public int compareTo(Vendas o) {
        if(this.getTotalVenda() < o.getTotalVenda()){
            return 1;
        }else if(this.getTotalVenda() == o.getTotalVenda()){
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Vendas{" + "codVenda=" + codVenda + ", linhaDeVendas=" + linhaDeVendas + ", cliente=" + cliente + ", empresa=" + empresa + '}';
    }
    
}
