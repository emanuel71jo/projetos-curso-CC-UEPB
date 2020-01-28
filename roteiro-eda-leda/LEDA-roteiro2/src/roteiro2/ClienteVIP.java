package roteiro2;

public class ClienteVIP extends Cliente{
    
    public ClienteVIP(String nome, String CPF, String endereco, String telefone) {
        super(nome, CPF, endereco, telefone);
    }
    
    /**
     * cliente tem direito ao desconto
     * @return true
     */
    @Override
    public boolean desconto(){
        return true;
    }
}
