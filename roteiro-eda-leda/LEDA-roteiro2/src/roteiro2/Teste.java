
package roteiro2;

import static roteiro2.Empresa.*;

public class Teste {
    public static void main(String args[]){
        
        Empresa empresa = new Empresa("1111", "UEPB", "BODOCONGO", "85 55555-5555");
        
        Cliente cliente[] = new Cliente[4];
        cliente[0] = new Cliente("JOAO", "1111", "GALANTE", "58 55555-4444");
        cliente[1] = new ClienteVIP("EMANUEL", "2222", "GALANTE", "58 25122-4444");
        cliente[2] = new Cliente("SILVA", "11131", "GALANTE", "58 55555-4444");
        cliente[3] = new ClienteVIP("LINS", "22622", "GALANTE", "58 25122-4444");
        empresa.inserirCliente(cliente[0]);
        empresa.inserirCliente(cliente[1]);
        empresa.inserirCliente(cliente[2]);
        empresa.inserirOrdenadoCliente(cliente[3]);
        mostrarClientes(empresa.clientes);

        System.out.println("CPF: " + empresa.buscaBinariaCliente("EMANUEL").getCPF());
        
        

        

    }

    private static void mostrarClientes(Cliente[] cliente) {
        for(int i = 0; i < posLivreClientes; i++){
            System.out.println("Nome: " + cliente[i].getNome());
        }
    }
}
