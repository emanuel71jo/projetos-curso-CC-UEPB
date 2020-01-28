package roteiro1;

public class Empresa {
	private String CNPJ, nome, endereco, telefone;
        private Cliente clientes[];
        private Produto produtos[];

	public Empresa(String CNPJ, String nome, String endereco, String telefone) {
		CNPJ = CNPJ;
                clientes = new Cliente[10];
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
	
        public Produto localizaProduto(String codProduto){
            for(int i = 0; i < produtos.length; i++){
                if(produtos[i].getCodProduto() == codProduto){
                    return produtos[i];
                }
            }
            return null;
        }
        
        public Cliente localizaCliente(String cpfCliente){
            for(int i = 0; i < clientes.length; i++){
                if(clientes[i].getCPF() == cpfCliente){
                    return clientes[i];
                }
            }
            return null;
        }
        
        public void inserirCliente(Cliente c){
            for(int i = 0; i < clientes.length; i++){
                if(clientes[i] == null){
                    clientes[i] = c;
                    aumentarArrayClientes(i);
                    break;
                }
            }
        }
        public void inserirProduto(Produto p){
            for(int i = 0; i < produtos.length; i++){
                if(produtos[i] == null){
                    produtos[i] = p;
                    aumentarArrayProdutos(i);
                    break;
                }
            }
        }
        
	
        public void aumentarArrayClientes(int tam){
            if( tam >= (clientes.length * 0.8)){
                Cliente aux[] = new Cliente[(int) ((clientes.length * 0.1) + clientes.length)];
                for(int i = 0; i < clientes.length; i++){
                    aux[i] = clientes[i];
                }
                clientes = aux;
            }
        }
        public void aumentarArrayProdutos(int tam){
            if( tam >= (produtos.length * 0.8)){
                Produto aux[] = new Produto[(int) ((produtos.length * 0.1) + produtos.length)];
                for(int i = 0; i < produtos.length; i++){
                    aux[i] = produtos[i];
                }
                produtos = aux;
            }
        }
}
