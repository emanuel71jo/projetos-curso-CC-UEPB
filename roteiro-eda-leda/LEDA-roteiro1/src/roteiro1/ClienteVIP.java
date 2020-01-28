package roteiro1;

public class ClienteVIP extends Cliente{
    
    public ClienteVIP(String nome, String CPF, String endereco, String telefone) {
        super(nome, CPF, endereco, telefone);
    }
    
    @Override
    public boolean desconto(){
        return true;
    }
}
