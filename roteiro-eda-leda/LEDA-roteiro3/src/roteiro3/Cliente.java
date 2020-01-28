package roteiro3;

public class Cliente implements Comparable<Cliente>{
    
    private String nome, CPF, endereco, telefone;
    private final MeuArray<Vendas> vendas;
    public static int posLivre = 0;
    

    public Cliente(String nome, String CPF, String endereco, String telefone) {
            this.nome = nome;
            this.CPF = CPF;
            this.endereco = endereco;
            this.telefone = telefone;
            this.vendas = new MeuArray();
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
     * Insere uma nova venda ao array de vendas do cliente
     * @param element venda a ser inserida
     */
    public void inserir(Vendas element){
        vendas.inserir(element);
    }   

    @Override
    public int compareTo(Cliente o) {
        return this.getNome().compareTo(o.getNome());
    }
    public int compareTo(String o) {
        return this.getNome().compareTo(o);
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", CPF=" + CPF + ", endereco=" + endereco + ", telefone=" + telefone + ", vendas=" + vendas + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }
  
    
    
}
