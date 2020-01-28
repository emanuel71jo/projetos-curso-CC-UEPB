package roteiro4;

import interfaces.Funcionalidades;
import classes.Vendas;
import classes.Cliente;
import classes.Produto;

public class Empresa implements Funcionalidades{
    private final String CNPJ, nome, endereco, telefone;
    private final MeuArray<Cliente> arrayCliente = new MeuArray();
    private final MeuArray<Produto> arrayProdutos = new MeuArray();
    private final MeuArray<Vendas> arrayVendas = new MeuArray();   

    public Empresa(String CNPJ, String nome, String endereco, String telefone) {
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public Empresa(){    
        this.CNPJ = null;
        this.nome = null;
        this.endereco = null;
        this.telefone = null;
    }

    /**
     * Insere na ultima posicao um cliente
     * @param cliente cliente a ser inserido
     */
    @Override
    public void inserirCliente(Cliente cliente) {
        this.arrayCliente.inserir(cliente);
    }
    
    /**
     * Insere na ultima posicao um produto
     * @param produto produto a ser inserido
     */
    @Override
    public void inserirProduto(Produto produto) {
        this.arrayProdutos.inserir(produto);
    }
    
    /**
     * Insere na ultima posicao uma venda
     * @param venda venda a ser inserida
     */
    @Override
    public void inserirVenda(Vendas venda) {
        this.arrayVendas.inserir(venda);
    }

    /**
     * Recupera um cliente pelo nome
     * @param nome nome do cliente a ser buscado
     * @return cliente
     */
    @Override
    public Cliente recuperarClienteNome(String nome) {
        return this.arrayCliente.localizar(nome);
    }

    /**
     * Localiza um produto pela descricao
     * @param cod codigo do produto procurado
     * @return produto
     */
    @Override
    public Produto localizarProduto(String cod) {
        return this.arrayProdutos.localizar(cod);
    }

    /**
     * Ordena o array de clientes pelo insertionSort()
     * @return array ordenado
     */
    @Override
    public Cliente[] insertionSortCliente() {
        return this.arrayCliente.insertionSort();
    }

    /**
     * Ordena o array de produtos pelo insertionSort()
     * @return array ordenado
     */
    @Override
    public Produto[] insertionSortProduto() {
        return this.arrayProdutos.insertionSort();
    }

    /**
     * Ordena o array de vendas pelo insertionSort()
     * @return array ordenado
     */
    @Override
    public Vendas[] insertionSortVendas() {
        return this.arrayVendas.insertionSort();
    }

    /**
     * Ordena o array de cliente pelo bubbleSort()
     * @return array ordenado
     */
    @Override
    public Cliente[] bubbleSortCliente() {
        return this.arrayCliente.bubbleSort();
    }

    /**
     * Ordena o array de produtos pelo bubbleSort()
     * @return array ordenado
     */
    @Override
    public Produto[] bubbleSortProduto() {
        return this.arrayProdutos.bubbleSort();
    }

    /**
     * Ordena o array de vendas pelo bubbleSort()
     * @return array ordenado
     */
    @Override
    public Vendas[] bubbleSortVendas() {
        return this.arrayVendas.bubbleSort();
    }

    /**
     * Ordena o array de clientes pelo bubbleSortDinamico()
     * @return array ordenado
     */
    @Override
    public Cliente[] bubbleSortDinamicoCliente() {
        return this.arrayCliente.bubbleSortDinamico();
    }

    /**
     * Ordena o array de produtos pelo bubbleSortDinamico()
     * @return array ordenado
     */
    @Override
    public Produto[] bubbleSortDinamicoProduto() {
        return this.arrayProdutos.bubbleSortDinamico();
    }

    /**
     * Ordena o array de vendas pelo bubbleSortDinamico()
     * @return array ordenado
     */
    @Override
    public Vendas[] bubbleSortDinamicoVendas() {
        return this.arrayVendas.bubbleSortDinamico();
    }

    /**
     * Ordena o array de clientes pelo selectionSort()
     * @return array ordenado
     */
    @Override
    public Cliente[] selectionSortCliente() {
        return this.arrayCliente.selectionSort();
    }

    /**
     * Ordena o array de produtos pelo selectionSort()
     * @return array ordenado
     */
    @Override
    public Produto[] selectionSortProduto() {
        return this.arrayProdutos.selectionSort();
    }

    /**
     * Ordena o array de vendas pelo selectionSort()
     * @return array ordenado
     */
    @Override
    public Vendas[] selectionSortVendas() {
        return this.arrayVendas.selectionSort();
    }

    /**
     * Faz uma busca pelo algoritmo de buscaBinaria
     * @param nome cliente a ser buscado
     * @return cliente
     */
    @Override
    public Cliente buscaBinariaCliente(String nome) {
        return this.arrayCliente.buscaBinaria(new Cliente(nome));
    }

    /**
     * Faz uma busca pelo algoritmo de buscaBinaria
     * @param descricao descricao do produto a ser buscado
     * @return produto
     */
    @Override
    public Produto buscaBinariaProduto(String descricao) {
        return this.arrayProdutos.buscaBinaria(new Produto(descricao));
    }

    /**
     * Insere um cliente no array de forma ordenada pelo nome
     * @param cliente cliente a ser inserido
     */
    @Override
    public void inserirOrdenadoCliente(Cliente cliente) {
        this.arrayCliente.inserirOrdenado(cliente);
    }

    /**
     * Insere um produto no array de forma ordenada pela descricao
     * @param produto produto a ser inserido
     */
    @Override
    public void inserirOrdenadoProduto(Produto produto) {
        this.arrayProdutos.inserirOrdenado(produto);
    }

    /**
     * Remove um cliente do array e depois ordena o mesmo
     * @param cliente cliente a ser removido
     */
    @Override
    public void removerOrdenadoCliente(Cliente cliente) {
        this.arrayCliente.removeOrdenado(cliente);
    }

    /**
     * Remove um produto do array e depois ordena o mesmo
     * @param produto produto a ser removido
     */
    @Override
    public void removerOrdenadoProduto(Produto produto) {
        this.arrayProdutos.removeOrdenado(produto);
    }

    @Override
    public Vendas[] getVendas() {
        return this.arrayVendas.recuperaArray();
    }

    @Override
    public Cliente[] getClientes() {
        return this.arrayCliente.recuperaArray();
    }

    @Override
    public Produto[] getProdutos() {
        return this.arrayProdutos.recuperaArray();
    }
}
