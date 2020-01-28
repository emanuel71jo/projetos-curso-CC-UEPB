package classes;

import java.util.Arrays;
import roteiro4.Empresa;
import roteiro4.MeuArray;


public class Vendas implements Comparable<Vendas>{
    private final String codVenda;
    public LinhaDeVendas[] linhaDeVendas;
    public Cliente cliente;
    public Empresa empresa;

    public Vendas(LinhaDeVendas[] linhaDeVendas, Cliente cliente, String cod) {
        this.linhaDeVendas = linhaDeVendas;  
        empresa = new Empresa();
        this.cliente = cliente;
        this.codVenda = cod;
        this.cliente.inserir(this);
        this.empresa.inserirVenda(this);
    }

    /**
     * retorna o total da venda com desconto se possivel
     * @return s
     */
    public double calcularTotal() {
        double totalVenda = 0;
        for(int i = 0; i < this.linhaDeVendas.length; i++){
            totalVenda += this.linhaDeVendas[i].getSubTotal();
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
        return this.linhaDeVendas;
    }

    public String codVenda(){
        return this.codVenda;
    }

    @Override
    public int compareTo(Vendas o) {
        if(this.calcularTotal() < o.calcularTotal()){
            return 1;
        }else if(this.calcularTotal() == o.calcularTotal()){
            return 0;
        }
        return -1;
    }
}
