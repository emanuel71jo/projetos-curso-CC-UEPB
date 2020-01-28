package roteiro2;

public class Empresa {
    private String CNPJ, nome, endereco, telefone;
    public Cliente clientes[] = new Cliente[10];
    public Produto produtos[] = new Produto[10];
    public Vendas vendas[] = new Vendas[10];
    static int posLivreVendas = 0, posLivreProdutos = 0, posLivreClientes = 0;

    public Empresa(String CNPJ, String nome, String endereco, String telefone) {
            this.CNPJ = CNPJ;
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
    }

    public Cliente[] getClientes(){
        return this.clientes;
    }

    public Produto[] getProdutos(){
        return this.produtos;
    }

    public String getCNPJ() {
            return CNPJ;
    }

    public void setCNPJ(String cNPJ) {
            CNPJ = cNPJ;
    }

    public String getNome() {
            return nome;
    }

    public void setNome(String nome) {
            this.nome = nome;
    }

    public String getEndereco() {
            return endereco;
    }

    public void setEndereco(String endereco) {
            this.endereco = endereco;
    }

    public String getTelefone() {
            return telefone;
    }

    public void setTelefone(String telefone) {
            this.telefone = telefone;
    }
    
    /**
     * retorna produto a partir do cod dele
     * @param codProduto c
     * @return s
     */
    public Produto localizaProduto(String codProduto){
        for(int i = 0; i < produtos.length; i++){
            if(produtos[i].getCodProduto() == codProduto){
                return produtos[i];
            }
        }
        return null;
    }
    
    /**
     * retorna o cliente a partir do cpf dele
     * @param cpfCliente c
     * @return s
     */

    public Cliente localizaCliente(String cpfCliente){
        for(int i = 0; i < clientes.length; i++){
            if(clientes[i].getCPF() == cpfCliente){
                return clientes[i];
            }
        }
        return null;
    }

    /**
     * insere o cliente na ultima posicao livre do array e depois verificar 
     * se e necessario aumentar o mesmo
     * @param c s
     */
    public void inserirCliente(Cliente c){
        clientes[posLivreClientes++] = c;
        aumentarArrayClientes();
    }
    
    /**
     * insere um produto na ultima posicao do array
     * e depois verifica se e necessario aumentar o array
     * @param p s
     */
    
    public void inserirProduto(Produto p){
        produtos[posLivreProdutos++] = p;
        aumentarArrayProdutos();
    }
    
    /**
     * insere uma venda ao array e verifica se e necessario
     * o aumento do array
     * @param v s
     */
    public void inserirVendas(Vendas v){
        vendas[posLivreVendas++] = v;
        aumentarArrayVendas();
    }

    /**
     * aumenta o array de clientes se ele estiver com 80% 
     * de espaco ocupado
     */
    public void aumentarArrayClientes(){
        if( posLivreClientes >= (clientes.length * 0.8)){
            Cliente aux[] = new Cliente[(int) ((clientes.length * 0.1) + clientes.length)];
            for(int i = 0; i < clientes.length; i++){
                aux[i] = clientes[i];
            }
            clientes = aux;
        }
    }
    
    /**
     * aumenta o array de produtos se ele tiver
     * com 80% de espaco ocupado
     */
    public void aumentarArrayProdutos(){
        if( posLivreProdutos >= (produtos.length * 0.8)){
            Produto aux[] = new Produto[(int) ((produtos.length * 0.1) + produtos.length)];
            for(int i = 0; i < produtos.length; i++){
                aux[i] = produtos[i];
            }
            produtos = aux;
        }
    }
    
    /**
     * aumenta o array de vendas se ele
     * tiver com 80% de espaco ocupado
     */
    public void aumentarArrayVendas(){
        if( posLivreVendas >= (vendas.length * 0.8)){
            Vendas aux[] = new Vendas[(int) ((vendas.length * 0.1) + vendas.length)];
            for(int i = 0; i < vendas.length; i++){
                aux[i] = vendas[i];
            }
            vendas = aux;
        }
    }

    /**
     * ordena o array de clientes apartir
     * do algoritmo de insertion sort
     */
    public void ordenarArrayClientes(){
        Cliente c;
        for(int i = 1; i < posLivreClientes; i++){
            c = clientes[i];
            int j = i - 1;
            while( j >= 0 && -1 < (clientes[j].getNome().compareTo(c.getNome()))){
                clientes[j+1] = clientes[j];
                clientes[j--] = c;
            }
            clientes[j+1] = c;
        }
    }
    
    /**
     * ordena o array de produtos apartir do algoritmo de
     * insertion sort
     */
    public void ordenarArrayProdutos(){
        for(int i = 1; i < posLivreProdutos; i++){
            Produto p = produtos[i];
            int j = i - 1;
            while( j >= 0 && -1 < (p.getCodProduto().compareTo(produtos[j].getCodProduto()))){
                produtos[j+1] = produtos[j];
                produtos[j--] = p;
            }
            produtos[j+1] = p;
        }
    }
    
    /**
     * ordena o array de vendas com insertion sort
     */
    public void ordenarArrayVendas(){
        for(int i = 1; i < posLivreVendas; i++){
            Vendas v = vendas[i];
            int j = i - 1;
            while( j >= 0 && v.getTotalVenda() < vendas[i].getTotalVenda()){
                vendas[j+1] = vendas[j];
                vendas[j--] = v;
            }
            vendas[j+1] = v;
        }
    }
    
    /**
     * pesquisa linear simples no array de clientes
     * @param nome s
     * @return  c
     */
    public Cliente pesquisaLinearCliente(String nome){
        for(Cliente c: clientes){
            if(c.getNome().equals(nome)){
                return c;
            }
        }
        return null;
    }
    
    /**
     * pesquisa simples no array de produtos
     * @param desc s
     * @return  c
     */
    public Produto pesquisaLinearProduto(String desc){
        for(Produto p: produtos){
            if(p.getDescricao().equals(desc)){
                return p;
            }
        }
        return null;
    }

    /**
     * busca binaria no array de clientes
     * @param nome s
     * @return c
     */
    public Cliente buscaBinariaCliente(String nome){
        ordenarArrayClientes();
        int min = 0, max = posLivreClientes, meio = 0;
        
        while(min <= max){
            meio = (min + max)/2;
            if(clientes[meio].getNome().equals(nome)){
                return clientes[meio];
            }
            if( -1 < clientes[meio].getNome().compareTo(nome)){
                max = meio - 1;
            }else{
                min = meio + 1;
            }
        }
        return null;
    }
    
    /**
     * busca binaria no array de produtos
     * @param cod s
     * @return c
     */
    public Produto buscaBinariaProduto(String cod){
        ordenarArrayProdutos();
        int min = 0, max = posLivreProdutos, meio = 0;
        
        while(min <= max){
            meio = (min + max)/2;
            if(produtos[meio].getCodProduto().equals(cod)){
                return produtos[meio];
            }
            if( -1 < produtos[meio].getCodProduto().compareTo(cod)){
                max = meio - 1;
            }else{
                min = meio + 1;
            }
        }
        return null;
    }
    
    /**
     * insercao ordenada no array de clientes
     * @param c  s
     */
    public void inserirOrdenadoCliente(Cliente c){
        ordenarArrayClientes();
        int pos = 0;
        
        for(int i = 0; i < posLivreClientes; i++){
            if(clientes[i].getNome().compareTo(c.getNome()) > -1){
                pos = i;
                deslocarArrayCliente(pos);
                break;
            }
        }
        clientes[pos] = c;        
    }

    /**
     * desloca o array a partir da posicao dada
     * @param pos  s
     */
    private void deslocarArrayCliente(int pos) {
        for(int i = posLivreClientes++; i > pos; i--){
            clientes[i] = clientes[i - 1];
        }
        aumentarArrayClientes();
    }
    
    /**
     * insere um produto ordenado no array
     * @param p  s
     */
    public void inserirOrdenadoProdutos(Produto p){
        ordenarArrayProdutos();
        int pos = 0;
        
        for(int i = 0; i < posLivreProdutos; i++){
            if(produtos[i].getCodProduto().compareTo(p.getCodProduto()) > -1){
                pos = i;
                deslocarArrayProdutos(pos);
                break;
            }
        }
        produtos[pos] = p;        
    }

    /**
     * descola o array a partir da posicao
     * @param pos  s
     */
    private void deslocarArrayProdutos(int pos) {
        for(int i = posLivreProdutos++; i > pos; i--){
            produtos[i] = produtos[i - 1];
        }
        aumentarArrayProdutos();
    }
    
    /**
     * excluindo um cliente do array
     * @param c s
     */
    public void removerOrdenadoCliente(Cliente c){
        ordenarArrayClientes();
        for(int i = 0; i < posLivreClientes; i++){
            if(c.getNome().equals(clientes[i].getNome())){
                clientes[i] = null;
                reordenarArrayClientes(i);
                break;
            }
        }  
    }

    /**
     * reoorganizando o array, ja que apos a remorcao ficou um buraco
     * @param i 
     */
    private void reordenarArrayClientes(int i) {
        for(int j = i; i < posLivreClientes--; i++){
            clientes[j] = clientes[j+1];
        }
    }
    /**
     * excluindo um produto do array
     * @param p sss
     */
    public void removerOrdenadoProdutos(Produto p){
        ordenarArrayProdutos();
        for(int i = 0; i < posLivreProdutos; i++){
            if(p.getCodProduto().equals(produtos[i].getCodProduto())){
                produtos[i] = null;
                reordenarArrayProdutos(i);
                break;
            }
        }  
    }

    /**
     * reoorganizando o array, ja que apos a remorcao ficou um buraco
     * @param i 
     */
    private void reordenarArrayProdutos(int i) {
        for(int j = i; i < posLivreProdutos--; i++){
            produtos[j] = produtos[j+1];
        }
    }


    
}
