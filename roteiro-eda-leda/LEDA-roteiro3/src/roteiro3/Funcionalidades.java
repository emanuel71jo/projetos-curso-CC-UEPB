
package roteiro3;

public interface Funcionalidades {
    
    public void inserirCliente(Cliente cliente);
    public void inserirProduto(Produto produto);
    public void inserirVenda(Vendas venda);
    public Cliente recuperarClienteNome(String nome);
    public Produto localizarProduto(String descricao);
    public Cliente[] insertionSortCliente();
    public Produto[] insertionSortProduto();
    public Vendas[] insertionSortVendas();
    public Cliente[] bubbleSortCliente();
    public Produto[] bubbleSortProduto();
    public Vendas[] bubbleSortVendas();
    public Cliente[] bubbleSortDinamicoCliente();
    public Produto[] bubbleSortDinamicoProduto();
    public Vendas[] bubbleSortDinamicoVendas();
    public Cliente[] selectionSortCliente();
    public Produto[] selectionSortProduto();
    public Vendas[] selectionSortVendas();
    public Cliente buscaBinariaCliente(String nome);
    public Produto buscaBinariaProduto(String descricao);
    public void inserirOrdenadoCliente(Cliente cliente);
    public void inserirOrdenadoProduto(Produto produto);
    public void removerOrdenadoCliente(Cliente cliente);
    public void removerOrdenadoProduto(Produto produto);
}
