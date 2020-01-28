package roteiro2;

public class Cliente {
	private String nome, CPF, endereco, telefone;
        private Vendas[] vendas = new Vendas[10];
        public static int posLivre = 0;

	public Cliente(String nome, String CPF, String endereco, String telefone) {
		this.nome = nome;
		this.CPF = CPF;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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
         * cliente nao tem direito ao desconto
         * @return false
         */
        public boolean desconto(){
            return false;
        }
	
        /**
         * insere uma nova venda ao cliente
         * @param v venda
         */
        public void inserirVenda(Vendas v){
            vendas[posLivre++] = v;
        }
	
        /**
         * retorna todas as vendas
         * @return vendas
         */
        public Vendas[] recuperaVendas(){
            return vendas;
        }
               
}
