package testes;


import classes.Cliente;
import classes.LinhaDeVendas;
import classes.Vendas;
import classes.Produto;
import org.junit.*;
import static org.junit.Assert.*;
import roteiro4.*;

public class TesteOrdenar {   
    static Cliente c1 = new Cliente("JOAO"), c2 = new Cliente("EMANUEL");
    static Cliente c3 = new Cliente("SILVA"), c4 = new Cliente("LINS");
    
    static LinhaDeVendas[] linhaDeVenda1 = {new LinhaDeVendas(new Produto("MOUSE","1000", 200), 1),
        new LinhaDeVendas(new Produto("PC DESKTOP", "1003", 1800), 1), 
        new LinhaDeVendas(new Produto("TECLADO", "1001", 100), 1)}; //2100
    
    static LinhaDeVendas[] linhaDeVenda2 = {new LinhaDeVendas(new Produto("TECLADO", "1001", 100), 1), 
        new LinhaDeVendas(new Produto("MOUSE","1000", 200), 1)}; //300
    
    static LinhaDeVendas[] linhaDeVenda3 = {new LinhaDeVendas(new Produto("MOUSE","1000", 200), 1),
        new LinhaDeVendas(new Produto("NOTEBOOK","1002", 2000), 1),
        new LinhaDeVendas(new Produto("TECLADO", "1001", 100), 1)}; //2300
    
    static LinhaDeVendas[] linhaDeVenda4 = {new LinhaDeVendas(new Produto("MOUSE","1000", 200), 1),
        new LinhaDeVendas(new Produto("PC DESKTOP", "1003", 1800), 1),
        new LinhaDeVendas(new Produto("NOTEBOOK","1002", 2000), 1)}; //4000
    
    static Vendas venda1, venda2, venda3, venda4;
    
    @Before
    public void setUp(){
        venda1 = new Vendas(linhaDeVenda1, c1, "0000"); //2100
        venda2 = new Vendas(linhaDeVenda2, c2, "0001"); //300
        venda3 = new Vendas(linhaDeVenda3, c3, "0002"); //2300
        venda4 = new Vendas(linhaDeVenda4, c4, "0003"); //4000
        
    }
    /**
     * O array de entrada não está sendo ordenado corretamente
     */
    @Test
    public void testOrdenarClienteBugLinha20(){
        Cliente[] entrada = {c1, c2, c3, c4};
        Cliente[] saida = {c2, c1, c4, c3};
        Ordenar.ordenarClientes(entrada);
        assertArrayEquals(saida, entrada);
    }
    
    /**
     * Erro ArrayIndexOfBoundsException
     */
    @Test
    public void testOrdenarClienteCorretoLinha20(){
        Cliente[] entrada = {c1, c2, c3, c4};
        Cliente[] saida = {c2, c1, c4, c3};      
        Ordenar.ordenarCorrecaoBugLinha20Clientes(entrada);
        assertArrayEquals(saida, entrada);
    }
    
    /**
     * Bug corrigido, array de entrada está sendo ordenado corretamente
     */
    @Test
    public void testOrdenarClienteCorretoLinha41(){
        Cliente[] entrada = {c1, c2, c3, c4};
        Cliente[] saida = {c2, c1, c4, c3};
        Ordenar.ordenarCorrecaoBugLinha41Clientes(entrada);
        assertArrayEquals(saida, entrada);
    }
    
    /**
     * O array de entrada não está sendo ordenado corretamente
     */
    @Test
    public void testOrdenarVendasBugLinha79(){
        Vendas[] entrada = {venda1, venda2, venda3, venda4};
        Vendas[] saida = {venda2, venda1, venda3, venda4};
        Ordenar.ordenarVendas(entrada);
        assertArrayEquals(saida, entrada);
    }
    
    /**
     * Bug na linha 79 corrigido, novo bug na linha 102
     * Erro ArrayIndexOfBoundsException
     */
    @Test
    public void testOrdenarVendasBugLinha102(){
        Vendas[] entrada = {venda1, venda2, venda3, venda4};
        Vendas[] saida = {venda2, venda1, venda3, venda4};
        Ordenar.ordenarVendasCorrecaoBugLinha79(entrada);
        assertArrayEquals(saida, entrada);
    }
    /**
     * Bug na linha 102 corrigido, metodo ordenando corretamente
     */
    @Test
    public void testOrdenarVendasCorreto(){
        Vendas[] entrada = {venda1, venda2, venda3, venda4};
        Vendas[] saida = {venda2, venda1, venda3, venda4};
        Ordenar.ordenarVendasCorrecaoBugLinha102(entrada);
        assertArrayEquals(saida, entrada);
    }
    
    /**
     * Teste do pior caso para ordenar as vendas
     */
    @Test
    public void testPiorCasoVendas(){
        Vendas[] entrada = {venda4, venda3, venda1, venda2};
        Vendas[] saida = {venda2, venda1, venda3, venda4};
        Ordenar.ordenarVendasCorrecaoBugLinha102(entrada);
        assertArrayEquals(saida, entrada);
    }
    
    /**
     * Teste caso médio para ordenar as vendas
     */
    @Test
    public void testMedioCasoVendas(){
        Vendas[] entrada = {venda3, venda1, venda2, venda4};
        Vendas[] saida = {venda2, venda1, venda3, venda4};
        Ordenar.ordenarVendasCorrecaoBugLinha102(entrada);
        assertArrayEquals(saida, entrada);
    }
    /**
     * Teste melhor caso para ordenar as vendas
     */
    @Test
    public void testMelhorCasoVendas(){
        Vendas[] entrada = {venda2, venda1, venda3, venda4};
        Vendas[] saida = {venda2, venda1, venda3, venda4};
        Ordenar.ordenarVendasCorrecaoBugLinha102(entrada);
        assertArrayEquals(saida, entrada);
    }
    /**
     * Teste vendas iguais para ordenar as vendas
     */
    @Test
    public void testIguaisVendas(){
        Vendas[] entrada = {venda2, venda2, venda2, venda2};
        Vendas[] saida = {venda2, venda2, venda2, venda2};
        Ordenar.ordenarVendasCorrecaoBugLinha102(entrada);
        assertArrayEquals(saida, entrada);
    }
    /**
     * Teste vendas iguais para ordenar as vendas
     */
    @Test
    public void testVendasRepetidas(){
        Vendas[] entrada = {venda2, venda4, venda2, venda4};
        Vendas[] saida = {venda2, venda2, venda4, venda4};
        Ordenar.ordenarVendasCorrecaoBugLinha102(entrada);
        assertArrayEquals(saida, entrada);
    }
    /**
     * Teste vazio para ordenar as vendas
     */
    @Test
    public void testVazioVendas(){
        Vendas[] entrada = {};
        Vendas[] saida = {};
        Ordenar.ordenarVendasCorrecaoBugLinha102(entrada);
        assertArrayEquals(saida, entrada);
    }
    
    /**
     * Teste pior caso de ordenação Clientes
     */
    @Test
    public void testPiorCasoCliente(){
        Cliente[] entrada = {c3, c4, c1, c2};
        Cliente[] saida = {c2, c1, c4, c3};
        Ordenar.ordenarCorrecaoBugLinha41Clientes(entrada);
        assertArrayEquals(saida, entrada);
    }
    
    /**
     * Teste medio caso de ordenação Clientes
     */
    @Test
    public void testMedioCasoCliente(){
        Cliente[] entrada = {c3, c1, c4, c2};
        Cliente[] saida = {c2, c1, c4, c3};
        Ordenar.ordenarCorrecaoBugLinha41Clientes(entrada);
        assertArrayEquals(saida, entrada);
    }
    /**
     * Teste melhor caso de ordenação Clientes
     */
    @Test
    public void testMelhorCasoCliente(){
        Cliente[] entrada = {c2, c1, c4, c3};
        Cliente[] saida = {c2, c1, c4, c3};
        Ordenar.ordenarCorrecaoBugLinha41Clientes(entrada);
        assertArrayEquals(saida, entrada);
    }
    
    /**
     * Teste cliente repetidos
     */
    @Test
    public void testClienteRepetidos(){
        Cliente[] entrada = {c2, c3, c2, c3};
        Cliente[] saida = {c2, c2, c3, c3};
        Ordenar.ordenarCorrecaoBugLinha41Clientes(entrada);
        assertArrayEquals(saida, entrada);
    }
    
    /**
     * Teste todos cliente iguais
     */
    public void testClienteIguais(){
        Cliente[] entrada = {c1, c1, c1, c1};
        Cliente[] saida = {c1, c1, c1, c1};
        Ordenar.ordenarCorrecaoBugLinha41Clientes(entrada);
        assertArrayEquals(saida, entrada);
    }
    /**
     * Teste todos cliente vazio
     */
    public void testClienteVazio(){
        Cliente[] entrada = {};
        Cliente[] saida = {};
        Ordenar.ordenarCorrecaoBugLinha41Clientes(entrada);
        assertArrayEquals(saida, entrada);
    }
    
}
