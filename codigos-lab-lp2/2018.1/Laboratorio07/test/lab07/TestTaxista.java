
package lab07;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestTaxista {
    /**
     * Testando os metodos desconto e tributo da classe Taxista
     */
    @Test
    public void testCalculaDescontoETributo(){
        Casa casa = new Casa(10000);
        Carro carro = new Carro(10000);
        Contribuinte taxista = new Taxista(null, 10, casa, carro, 4, 500);
        assertEquals(5, taxista.calculaDescontos(), 0); // kmrodado = 500 * desconto = 0.01
        assertEquals(2, taxista.calculaTributo(), 0); // passageiros = 5 * taxa = 0.5
    
    }
}
