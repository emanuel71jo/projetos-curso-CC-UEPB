
import org.junit.Test;
import laboratorio10.Exceção.*;

/**
 *
 * @author João Emanuel
 */
public class TestExcecoes {
    
   
    @Test(expected = AtualizarClienteExcecao.class)
    public void testAtualizarCliente() throws AtualizarClienteExcecao{
        throw new AtualizarClienteExcecao();
    }
    
    @Test(expected = AtualizarProdutoExcecao.class)
    public void testAtualizarProduto() throws AtualizarProdutoExcecao{
        throw new AtualizarProdutoExcecao();
    }
    
    @Test(expected = CadastroClienteExcecao.class)
    public void testCadastroCliente() throws CadastroClienteExcecao{
        throw new CadastroClienteExcecao();
    }
    
    @Test(expected = CadastroProdutoExcecao.class)
    public void testCadastroProduto() throws CadastroProdutoExcecao{
        throw new CadastroProdutoExcecao();
    }
    
    @Test(expected = QuantidadeProdutoExcecao.class)
    public void testQuantidadeProduto() throws QuantidadeProdutoExcecao{
        throw new QuantidadeProdutoExcecao();
    }
    
    @Test(expected = RemoverClienteExcecao.class)
    public void testRemoverCliente() throws RemoverClienteExcecao{
        throw new RemoverClienteExcecao();
    }
    
    @Test(expected = RemoverProdutoExcecao.class)
    public void testRemoverProduto() throws RemoverProdutoExcecao{
        throw new RemoverProdutoExcecao();
    }
}
