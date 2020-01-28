
package roteiro1;

public class Teste {
    public static void main(String args[]){
        
        Empresa empresa = new Empresa("1111", "UEPB", "BODOCONGO", "85 55555-5555");
        
        Cliente cliente1 = new Cliente("JOAO", "1111", "GALANTE", "58 55555-4444");
        Cliente cliente2 = new ClienteVIP("EMANUEL", "2222", "GALANTE", "58 25122-4444");
        empresa.inserirCliente(cliente1);
        empresa.inserirCliente(cliente2);
      

        Produto produto1 = new Produto("MOUSE", "1000", 15);
        Produto produto2 = new Produto("TECLADO", "1001", 50);
        empresa.inserirProduto(produto2);
        empresa.inserirProduto(produto1);
        
        ItemProduto item1[] = new ItemProduto[4];
        item1[0] = new ItemProduto("001", "AB", "25/12", produto1);
        item1[1] = new ItemProduto("010", "AB", "25/12", produto1);        
        item1[2] = new ItemProduto("011", "AB", "25/12", produto1);
        item1[3] = new ItemProduto("100", "AB", "25/12", produto1);
        
        ItemProduto item2[] = new ItemProduto[4];
        item2[0] = new ItemProduto("00100", "AC", "10/12", produto2);
        item2[1] = new ItemProduto("01000", "AC", "10/12", produto2);        
        item2[2] = new ItemProduto("01100", "AC", "10/12", produto2);
        item2[3] = new ItemProduto("10000", "AC", "10/12", produto2);
        
        LinhaDeVendas linhaDeVendas[] = new LinhaDeVendas[2];
        linhaDeVendas[0] = new LinhaDeVendas(item1);
        linhaDeVendas[1] = new LinhaDeVendas(item2);
        
        Vendas vendaNormal1 = new Vendas("22/02", linhaDeVendas, empresa, cliente1, "000001");
        Vendas vendaVIP1 =  new Vendas("23/02", linhaDeVendas, empresa, cliente2, "000010");
        Vendas vendaNormal2 = new VendaEspecial("12/10", linhaDeVendas, empresa, cliente1, "000011");
        Vendas vendaVIP2 =  new VendaEspecial("13/10", linhaDeVendas, empresa, cliente2, "000100");

    }
}
