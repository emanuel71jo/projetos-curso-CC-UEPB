
package laboratorio10;

import java.util.ArrayList;
import java.util.Scanner;
import laboratorio10.Exceção.*;
/**
 *
 * @author usuario
 */
public class Gerenciando {
    ArrayList<Cliente> cliente = new ArrayList<>();
    ArrayList<Produtos> produtos = new ArrayList<>();
    Scanner tc = new Scanner(System.in);
    
    public Gerenciando(){
        cliente.add(new ClienteCorporativo("JOAO", "GALANTE", "emanuel71jo@gmail.com", "123456"));
        cliente.add(new ClienteIndividual("EMANUEL", "GALANTE", "joaoemanuel71@outlook.com", "987654"));
        produtos.add(new Roupa("SHORT", 200, "JEANS", 150, 1000));
        produtos.add(new Perfume("CHEIROSO", 50, 105 , "BOTICARIO", 1001));
        produtos.add(new Eletronicos("Computador", 140, 2000, "ASUS", "DESKTOP", 1002));
    }
    
    public void cadastroCliente() throws AtualizarClienteExcecao, CadastroClienteExcecao{
        System.out.println("CADASTRO CLIENTE");
        System.out.println("<1> Cliente Corporativo");
        System.out.println("<2> Cliente Individual");
        if(tc.nextInt() == 1){
            System.out.println("CADASTRO CLIENTE CORPORATIVO");
            System.out.println("<1> Nome: ");
            tc.nextLine();
            String nome = tc.nextLine();
            System.out.println("<2> Endereço: ");
            String endereco = tc.nextLine();
            System.out.println("<3> Email: ");
            String email = tc.nextLine();
            System.out.println("<4> CNPJ: ");
            String cnpj = tc.nextLine();
            for(Cliente c: cliente){
                if(((ClienteCorporativo)c).getCNPJ().equals(cnpj)){
                    throw new CadastroClienteExcecao();
                }
            }
            Cliente corporativo = new ClienteCorporativo(nome,endereco,email,cnpj);
            cliente.add(corporativo);
            System.out.println("Cliente cadastrado com sucesso!!!");
        }else{
            System.out.println("CADASTRO CLIENTE INDIVIDUAL");
            System.out.println("<1> Nome: ");
            tc.nextLine();
            String nome = tc.nextLine();
            System.out.println("<2> Endereço: ");
            String endereco = tc.nextLine();
            System.out.println("<3> Email: ");
            String email = tc.nextLine();
            System.out.println("<4> CPF: ");
            String cpf = tc.nextLine();
            for(Cliente c: cliente){
                if(((ClienteIndividual)c).getCPF().equals(cpf)){
                    throw new CadastroClienteExcecao();
                }
            }
            Cliente individual = new ClienteIndividual(nome,endereco,email,cpf);
            cliente.add(individual);
            System.out.println("Cliente cadastrado com sucesso!!!");
        }
    }
    
    public Pagamento realizandoPagamento(double valor){
        System.out.println("");
        System.out.println("PAGAMENTO");
        System.out.println("Forma de pagamento:");
        System.out.println("<1> Boleto");
        System.out.println("<2> Cartao");
        int op = tc.nextInt();
        if(op == 1){
            System.out.println("Qual a taxa adicional? ");
            double taxa = tc.nextDouble();
            Pagamento pagamento = new PagamentoBoleto(valor,taxa);
            System.out.println("Boleto Emitido");
            return pagamento;
        }else{
            System.out.println("Quantas parcelas? ");
            int qtd = tc.nextInt();
            Pagamento pagamento = new PagamentoCartao(valor, qtd);
            System.out.println("Pagamento Efetuado");
            return pagamento;
        }
    }
    
    public void cadastroProduto() throws CadastroProdutoExcecao{
        System.out.println("CADASTRO PRODUTO");
        System.out.println("<1> Roupa");
        System.out.println("<2> Perfume");
        System.out.println("<3> Eletronico");
        int op = tc.nextInt();
        if(op == 1){
            System.out.println("CADASTRO ROUPA");
            System.out.println("<1> Descrição: ");
            tc.nextLine();
            String des = tc.nextLine();
            System.out.println("<2> Quantidade: ");
            int qtd = tc.nextInt();
            System.out.println("<3> Valor: ");
            double valor = tc.nextDouble();
            System.out.println("<4> Tipo: ");
            tc.nextLine();
            String tipo = tc.nextLine();
            System.out.println("<5> Codigo: ");
            int cod = tc.nextInt();
            for(Produtos p: produtos){
                if(p.getCodigo() == cod){
                    throw new CadastroProdutoExcecao();
                }
            }
            Produtos produto = new Roupa(des, qtd, tipo, valor,cod);
            produtos.add(produto);
            System.out.println("Produto cadastrado");
        }else if(op == 2){
            System.out.println("CADASTRO PERFUME");
            System.out.println("<1> Descrição: ");
            tc.nextLine();
            String des = tc.nextLine();
            System.out.println("<2> Marca: ");
            String marca = tc.nextLine();
            System.out.println("<3> Quantidade: ");
            int qtd = tc.nextInt();
            System.out.println("<4> Valor: ");
            double valor = tc.nextDouble();
            System.out.println("<5> Codigo: ");
            int cod = tc.nextInt();
            for(Produtos p: produtos){
                if(p.getCodigo() == cod){
                    throw new CadastroProdutoExcecao();
                }
            }
            Produtos produto = new Perfume(des, qtd, valor, marca,cod);
            produtos.add(produto);
            System.out.println("Produto cadastrado");
        }else{
            System.out.println("CADASTRO ELETRONICO");
            System.out.println("<1> Descrição: ");
            tc.nextLine();
            String des = tc.nextLine();
            System.out.println("<2> Quantidade: ");
            int qtd = tc.nextInt();
            System.out.println("<3> Valor: ");
            double valor = tc.nextDouble();
            System.out.println("<4> Tipo: ");
            tc.nextLine();
            String tipo = tc.nextLine();
            System.out.println("<5> Marca:");
            String marca = tc.nextLine();
            System.out.println("<6> Codigo: ");
            int cod = tc.nextInt();
            for(Produtos p: produtos){
                if(p.getCodigo() == cod){
                    throw new CadastroProdutoExcecao();
                }
            }
            Produtos produto = new Eletronicos(des, qtd, valor, marca, tipo,cod);
            produtos.add(produto);
            System.out.println("Produto cadastrado");
        }     
    }
    
    public void listarProdutos(){
        System.out.println("");
        System.out.println("LISTAR");
        System.out.println("<1> Listar Roupas");
        System.out.println("<2> Listar Perfume");
        System.out.println("<3> Listar Eletronico");
        System.out.println("<4> Listar tudo");
        switch(tc.nextInt()){
            case 1:{
                for(Produtos p: produtos){
                    if(p instanceof Roupa){
                        System.out.println("");
                        System.out.println("Descricao: " + p.getDescricao());
                        System.out.println("Valor: R$" + p.getValor());
                        System.out.println("Quantidade: " + p.getQuantidade());
                        System.out.println("Codigo: " + p.getCodigo());
                    }
                }
                break;
            }case 2:{
                for(Produtos p: produtos){
                    if(p instanceof Perfume){
                        System.out.println("");
                        System.out.println("Descricao: " + p.getDescricao());
                        System.out.println("Valor: R$" + p.getValor());
                        System.out.println("Quantidade: " + p.getQuantidade());
                        System.out.println("Codigo: " + p.getCodigo());
                    }
                }
                break;
            }case 3:{
                for(Produtos p: produtos){
                    if(p instanceof Eletronicos){
                        System.out.println("");
                        System.out.println("Descricao: " + p.getDescricao());
                        System.out.println("Valor: R$" + p.getValor());
                        System.out.println("Quantidade: " + p.getQuantidade());
                        System.out.println("Codigo: " + p.getCodigo());
                    }
                }
                break;
            }default:{
                for(Produtos p: produtos){   
                    System.out.println("");
                    System.out.println("Descricao: " + p.getDescricao());
                    System.out.println("Valor: R$" + p.getValor());
                    System.out.println("Quantidade: " + p.getQuantidade());
                    System.out.println("Codigo: " + p.getCodigo());
                }
            }
        }
    }
    
    public void listarCliente(){
        int i = 1;
        for(Cliente c: cliente){
            System.out.println("");
            System.out.println("Cliente " + i);
            System.out.println("Nome: " + c.getNome());
            System.out.println("Endereço: " + c.getEndereco());
            System.out.println("Email: " + c.getEmail());
            i++;
        }
    }
    
    
    public void menu() throws AtualizarClienteExcecao, CadastroClienteExcecao, CadastroProdutoExcecao, AtualizarProdutoExcecao, RemoverClienteExcecao, RemoverProdutoExcecao, QuantidadeProdutoExcecao{
        System.out.println("");
        System.out.println("MENU");
        System.out.println("<1> Cadastrar");
        System.out.println("<2> Listar");
        System.out.println("<3> Comprar");
        System.out.println("<4> Remover");
        System.out.println("<5> Atualizar");
        System.out.println("<6> Sair");
        switch(tc.nextInt()){
            case 1:{
                System.out.println("");
                System.out.println("CADASTRO");
                System.out.println("<1> Cadastro de Cliente");
                System.out.println("<2> Cadastro de Produto");
                int op = tc.nextInt();
                if(op == 1){
                    cadastroCliente();
                }else{
                    cadastroProduto();
                }
                menu();
            }
            case 2:{
                System.out.println("");
                System.out.println("LISTAR");
                System.out.println("<1> Listar Clientes");
                System.out.println("<2> Listar Produtos");
                int op = tc.nextInt();
                if(op == 1){
                    listarCliente();
                }else{
                    listarProdutos();
                }
                menu();
            }
            case 3:{
                System.out.println("");
                System.out.println("COMPRAR");
                if(verificarClienteCadastradoProduto()){
                    System.out.println("Cliente Encontrado");
                }else{
                    System.out.println("Cliente não encontrado. Cadastre agora");
                    cadastroCliente();
                }
             
                menu();           
            }case 4:{
                System.out.println("");
                System.out.println("REMOVER");
                System.out.println("<1> Remover Clientes");
                System.out.println("<2> Remover Produtos");
                int op = tc.nextInt();
                if(op == 1){
                    removerCliente();
                }else{
                    removerProduto();
                }
                menu();
            }case 5:{
                System.out.println("");
                System.out.println("ATUALIZAR");
                System.out.println("<1> Atualizar Clientes");
                System.out.println("<2> Atualizar Produtos");
                int op = tc.nextInt();
                if(op == 1){
                    atualizarCliente();
                }else{
                    atualizarProduto();
                }
                menu();
            }default:
                break;
        }
    }
    
    public boolean verificarClienteCadastradoProduto() throws AtualizarClienteExcecao, CadastroClienteExcecao, CadastroProdutoExcecao, AtualizarProdutoExcecao, RemoverClienteExcecao, RemoverProdutoExcecao, QuantidadeProdutoExcecao{
        System.out.println("Nome: ");
        tc.nextLine();
        String nome = tc.nextLine();
        for(Cliente c: cliente){
            if(nome.equals(c.getNome())){
                if(verificarProduto(c)){
                    return true;
                }else{
                    System.out.println("Produto não cadastrado");
                    menu();
                }
            }
        }
        return false;
    }
    
    public boolean verificarProduto(Cliente c) throws AtualizarClienteExcecao, CadastroClienteExcecao, CadastroProdutoExcecao, AtualizarProdutoExcecao, RemoverClienteExcecao, RemoverProdutoExcecao, QuantidadeProdutoExcecao{
        System.out.println("Digite o codigo: ");
        int cod = tc.nextInt();   
        for(Produtos p: produtos){
            if(cod == p.getCodigo()){
                System.out.println("Quantidade de itens: ");
                int qtd = tc.nextInt();
                if(qtd >= p.getQuantidade()){
                    throw new QuantidadeProdutoExcecao();
                }
                p.setQuantidade(p.getQuantidade() - qtd);
                Pagamento aux = realizandoPagamento(p.getValor());
                System.out.println("====== NOTA FISCAL =======");
                System.out.println("Nome: " + c.getNome());
                System.out.println("Endereço: " + c.getEndereco());
                System.out.println("Email: " + c.getEmail());
                System.out.println("===========================");
                if(p instanceof Roupa){
                    System.out.println("Produto: ROUPA");
                }else if(p instanceof Perfume){
                    System.out.println("Produto: PERFUME");
                }else{
                    System.out.println("Produto: ELETRONICO");
                }
                System.out.println("Codigo: " + p.getCodigo());
                System.out.println("Descrição: " + p.getDescricao());
                System.out.println("Quantidade: " + qtd);
                System.out.println("Valor: R$" + p.getValor());
                System.out.println("");
                if(aux instanceof PagamentoBoleto){
                    System.out.println("Total: R$" + (((PagamentoBoleto) aux).getTaxa() + p.getValor())*qtd);
                }else{
                    System.out.println("Quantidade de parcelas: " + ((PagamentoCartao) aux).getParcelas());
                    System.out.println("Valor das parcelas: R$" + p.getValor()/((PagamentoCartao) aux).getParcelas());
                }
                System.out.println("=======================");
                System.out.println("");
                return true;
            }
        }
        return false;
    }
    
    public void removerCliente() throws RemoverClienteExcecao{
        System.out.println("REMOVER CLIENTE");
        System.out.println("<1> Cliente Corporativo");
        System.out.println("<2> Cliente Individual");
        int op = tc.nextInt();
        if(op == 1){
            System.out.println("CNPF: ");
            tc.nextLine();
            String cnpj = tc.nextLine();
            for(Cliente c: cliente){
                if(cnpj.equals(((ClienteCorporativo) c).getCNPJ())){
                    cliente.remove(c);
                    return;
                }
            }
            throw new RemoverClienteExcecao();
        }else{
            System.out.println("CPF: ");
            tc.nextLine();
            String cpf = tc.nextLine();
            for(Cliente c: cliente){
                if(cpf.equals(((ClienteIndividual) c).getCPF())){
                    cliente.remove(c);
                    return;
                }
            }
            throw new RemoverClienteExcecao();
        }
    }
    
    public void atualizarCliente() throws AtualizarClienteExcecao{
        System.out.println("REMOVER CLIENTE");
        System.out.println("<1> Cliente Corporativo");
        System.out.println("<2> Cliente Individual");
        int op = tc.nextInt();
        if(op == 1){
            System.out.println("CNPF: ");
            String cnpj = tc.nextLine();
            for(Cliente c: cliente){
                if(cnpj.equals(((ClienteCorporativo)c).getCNPJ())){
                    System.out.println("EMAIL: ");
                    c.setEmail(tc.nextLine());
                    System.out.println("ENDEREÇO: ");
                    c.setEndereco(tc.nextLine());
                    return;
                }
            }
            throw new AtualizarClienteExcecao();
        }else{
            System.out.println("CPF: ");
            String cpf = tc.nextLine();
            for(Cliente c: cliente){
                if(cpf.equals(((ClienteIndividual)c).getCPF())){
                    System.out.println("EMAIL: ");
                    c.setEmail(tc.nextLine());
                    System.out.println("ENDEREÇO: ");
                    c.setEndereco(tc.nextLine());
                    return;
                }
            }
            throw new AtualizarClienteExcecao();
        }
    }
    
    public void removerProduto() throws RemoverProdutoExcecao{
        System.out.println("REMOVER PRODUTO");
        System.out.println("Código: ");
        int cod = tc.nextInt();
        for(Produtos p: produtos){
            if(p.getCodigo() == cod){
                produtos.remove(p);
                return;
            }
        }
        throw new RemoverProdutoExcecao();
    }
    
    
    public void atualizarProduto() throws AtualizarProdutoExcecao{
        System.out.println("ATUALIZAR PRODUTO");
        System.out.println("Código: ");
            int cod = tc.nextInt();
            for(Produtos p: produtos){
                if(p.getCodigo() == cod){
                    System.out.println("<1> Quantidade");
                    System.out.println("<2> Valor");
                    int op = tc.nextInt();
                    if(op == 1){
                        System.out.println("Quantidade a adicionar: ");
                        p.setQuantidade(p.getQuantidade() + tc.nextInt());
                    }else{
                        System.out.println("Valor novo: ");
                        p.setValor(tc.nextDouble());
                    }
                    return;
                }
            }
        throw new AtualizarProdutoExcecao();
    }
}
