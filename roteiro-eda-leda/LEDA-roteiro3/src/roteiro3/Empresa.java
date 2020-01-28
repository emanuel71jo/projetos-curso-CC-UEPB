package roteiro3;

public class Empresa implements Funcionalidades{
    private String CNPJ, nome, endereco, telefone;
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
    public void inserirCliente(Cliente cliente) {
        this.arrayCliente.inserir(cliente);
    }
    
    /**
     * Insere na ultima posicao um produto
     * @param produto produto a ser inserido
     */
    public void inserirProduto(Produto produto) {
        this.arrayProdutos.inserir(produto);
    }
    
    /**
     * Insere na ultima posicao uma venda
     * @param venda venda a ser inserida
     */
    public void inserirVenda(Vendas venda) {
        this.arrayVendas.inserir(venda);
    }

    /**
     * Recupera um cliente pelo nome
     * @param nome nome do cliente a ser buscado
     * @return cliente
     */
    public Cliente recuperarClienteNome(String nome) {
        return this.arrayCliente.localizar(nome);
    }

    /**
     * Localiza um produto pela descricao
     * @param descricao descricao do produto procurado
     * @return produto
     */
    public Produto localizarProduto(String descricao) {
        return this.arrayProdutos.localizar(descricao);
    }

    /**
     * Ordena o array de clientes pelo insertionSort()
     * @return array ordenado
     */
    public Cliente[] insertionSortCliente() {
        return this.arrayCliente.insertionSort();
    }

    /**
     * Ordena o array de produtos pelo insertionSort()
     * @return array ordenado
     */
    public Produto[] insertionSortProduto() {
        return this.arrayProdutos.insertionSort();
    }

    /**
     * Ordena o array de vendas pelo insertionSort()
     * @return array ordenado
     */
    public Vendas[] insertionSortVendas() {
        return this.arrayVendas.insertionSort();
    }

    /**
     * Ordena o array de cliente pelo bubbleSort()
     * @return array ordenado
     */
    public Cliente[] bubbleSortCliente() {
        return this.arrayCliente.bubbleSort();
    }

    /**
     * Ordena o array de produtos pelo bubbleSort()
     * @return array ordenado
     */
    public Produto[] bubbleSortProduto() {
        return this.arrayProdutos.bubbleSort();
    }

    /**
     * Ordena o array de vendas pelo bubbleSort()
     * @return array ordenado
     */
    public Vendas[] bubbleSortVendas() {
        return this.arrayVendas.bubbleSort();
    }

    /**
     * Ordena o array de clientes pelo bubbleSortDinamico()
     * @return array ordenado
     */
    public Cliente[] bubbleSortDinamicoCliente() {
        return this.arrayCliente.bubbleSortDinamico();
    }

    /**
     * Ordena o array de produtos pelo bubbleSortDinamico()
     * @return array ordenado
     */
    public Produto[] bubbleSortDinamicoProduto() {
        return this.arrayProdutos.bubbleSortDinamico();
    }

    /**
     * Ordena o array de vendas pelo bubbleSortDinamico()
     * @return array ordenado
     */
    public Vendas[] bubbleSortDinamicoVendas() {
        return this.arrayVendas.bubbleSortDinamico();
    }

    /**
     * Ordena o array de clientes pelo selectionSort()
     * @return array ordenado
     */
    public Cliente[] selectionSortCliente() {
        return this.arrayCliente.selectionSort();
    }

    /**
     * Ordena o array de produtos pelo selectionSort()
     * @return array ordenado
     */
    public Produto[] selectionSortProduto() {
        return this.arrayProdutos.selectionSort();
    }

    /**
     * Ordena o array de vendas pelo selectionSort()
     * @return array ordenado
     */
    public Vendas[] selectionSortVendas() {
        return this.arrayVendas.selectionSort();
    }

    /**
     * Faz uma busca pelo algoritmo de buscaBinaria
     * @param nome cliente a ser buscado
     * @return cliente
     */
    public Cliente buscaBinariaCliente(String nome) {
        return this.arrayCliente.buscaBinaria(new Cliente(nome, null, null, null));
    }

    /**
     * Faz uma busca pelo algoritmo de buscaBinaria
     * @param descricao descricao do produto a ser buscado
     * @return produto
     */
    public Produto buscaBinariaProduto(String descricao) {
        return this.arrayProdutos.buscaBinaria(new Produto(descricao, null, 0));
    }

    /**
     * Insere um cliente no array de forma ordenada pelo nome
     * @param cliente cliente a ser inserido
     */
    public void inserirOrdenadoCliente(Cliente cliente) {
        this.arrayCliente.inserirOrdenado(cliente);
    }

    /**
     * Insere um produto no array de forma ordenada pela descricao
     * @param produto produto a ser inserido
     */
    public void inserirOrdenadoProduto(Produto produto) {
        this.arrayProdutos.inserirOrdenado(produto);
    }

    /**
     * Remove um cliente do array e depois ordena o mesmo
     * @param cliente cliente a ser removido
     */
    public void removerOrdenadoCliente(Cliente cliente) {
        this.arrayCliente.removeOrdenado(cliente);
    }

    /**
     * Remove um produto do array e depois ordena o mesmo
     * @param produto produto a ser removido
     */
    public void removerOrdenadoProduto(Produto produto) {
        this.arrayProdutos.removeOrdenado(produto);
    }
}
