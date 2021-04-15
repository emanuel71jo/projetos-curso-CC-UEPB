
package laboratorio10;

import laboratorio10.Exceção.*;



/**
 *
 * @author João Emanuel
 */
public class Laboratorio10 {

    public static void main(String[] args) throws AtualizarClienteExcecao, CadastroProdutoExcecao, CadastroClienteExcecao, AtualizarProdutoExcecao, RemoverClienteExcecao, RemoverProdutoExcecao{
        Gerenciando g = new Gerenciando();
        g.menu();
    } 
}
