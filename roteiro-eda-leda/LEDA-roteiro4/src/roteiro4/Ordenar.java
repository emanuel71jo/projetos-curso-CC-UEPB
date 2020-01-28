
package roteiro4;

import classes.Vendas;
import classes.Cliente;

public class Ordenar {
    /**
     * Bug na linha 20, pois só entra no while se o cliente já estiver ordenado,
     * se o cliente[i] vinher depois do aux ele não vai ordenar.
     * @param clientes 
     */
    public static void ordenarClientes(Cliente[] clientes) {
        int i;
        Cliente aux;
        for (int j = 1; j < clientes.length; j++) {
            if (clientes[j] != null) {
                aux = clientes[j];
                i = j - 1;
                while (i >= 0 && clientes[i].getNome().compareToIgnoreCase(aux.getNome()) < 0){
                    clientes[i + 1] = clientes[i--];
                    i--;
                }
                clientes[i + 1] = aux;
            }
        }
    } 
    /**
     * Bug na linha 42, pois o i está sendo decrementado 2 vezes
     * gerando uma exceção
     * @param clientes 
     */
    public static void ordenarCorrecaoBugLinha20Clientes(Cliente[] clientes) {
        int i;
        Cliente aux;
        for (int j = 1; j < clientes.length; j++) {
            if (clientes[j] != null) {
                aux = clientes[j];
                i = j - 1;
                while (i >= 0 && clientes[i].getNome().compareToIgnoreCase(aux.getNome()) > 0){
                    clientes[i + 1] = clientes[i--];
                    i--;
                }
                clientes[i + 1] = aux;
            }
        }
    }
    /**
     * Bug da linha 41 corrigido, ordenação está correta
     * @param clientes 
     */
    public static void ordenarCorrecaoBugLinha41Clientes(Cliente[] clientes) {
        int i;
        Cliente aux;
        for (int j = 1; j < clientes.length; j++) {
            if (clientes[j] != null) {
                aux = clientes[j];
                i = j - 1;
                while (i >= 0 && clientes[i].getNome().compareToIgnoreCase(aux.getNome()) > 0){
                    clientes[i + 1] = clientes[i];
                    i--;
                }
                clientes[i + 1] = aux;
            }
        }
    }
    /**
     * Bug na linha 79, pois só entra no while se a venda já estiver ordenado,
     * se venda[i] vinher depois do aux ele não vai ordenar.
     * @param vendas 
     */
    public static void ordenarVendas(Vendas[] vendas) {
        int i;
        Vendas aux;
        for (int j = 1; j < vendas.length; j++) {
            if (vendas[j] != null) {
                aux = vendas[j];
                i = j - 1;
                while (i >= 0 && vendas[i].calcularTotal() < aux.calcularTotal()) {
                    vendas[i + 1] = vendas[i--];
                    i--;
                }
                vendas[i + 1] = aux;
            }
        }
    }
    /**
     * Bug da linha 79 corrigido
     * novo Bug na linha 102, pois o i está sendo decrementado 2 vezes
     * gerando uma exceção
     * @param vendas 
     */
    public static void ordenarVendasCorrecaoBugLinha79(Vendas[] vendas) {
        int i;
        Vendas aux;
        for (int j = 1; j < vendas.length; j++) {
            if (vendas[j] != null) {
                aux = vendas[j];
                i = j - 1;
                while (i >= 0 && vendas[i].calcularTotal() > aux.calcularTotal()) {
                    vendas[i + 1] = vendas[i--];
                    i--;
                }
                vendas[i + 1] = aux;
            }
        }
    }
    /**
     * Bug da linha 102 corrigido
     * metodo de ordenação corrigido
     * @param vendas 
     */
    public static void ordenarVendasCorrecaoBugLinha102(Vendas[] vendas) {
        int i;
        Vendas aux;
        for (int j = 1; j < vendas.length; j++) {
            if (vendas[j] != null) {
                aux = vendas[j];
                i = j - 1;
                while (i >= 0 && vendas[i].calcularTotal() > aux.calcularTotal()) {
                    vendas[i + 1] = vendas[i--];
                }
                vendas[i + 1] = aux;
            }
        }
    }
    
}
