package classes;

import classes.Produto;

public class LinhaDeVendas implements Comparable<LinhaDeVendas>{
    private final Produto produto;
    private final int quantidadeProduto;

    public LinhaDeVendas(Produto produto, int quantidade) {
        this.quantidadeProduto = quantidade;
        this.produto = produto;
    }       

    /**
     * retorna o preco total dessa linha de venda, soma do
     * @return d
     */
    public double getSubTotal() {
        return this.produto.getPrecoProduto() * quantidadeProduto;
    }

    public int getQuantidadeProduto(){
        return this.quantidadeProduto;
    }


    @Override
    public int compareTo(LinhaDeVendas o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
