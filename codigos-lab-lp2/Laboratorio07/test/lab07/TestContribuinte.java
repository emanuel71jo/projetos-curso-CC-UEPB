
package lab07;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestContribuinte {
    /**
     * Testando os metodos da classe Contribuinte.
     */
    @Test
    public void testRiquezaImpostoDescontoTributo(){
        Casa casa = new Casa(1000);
        Carro carro = new Carro(1000);
        Contribuinte contribuinte = new Contribuinte(null, 0, casa, carro);
        assertNull(contribuinte.getNome()); // Verifica o nome do contribuinte
        assertEquals(0, contribuinte.getNumero(), 0); // verificando o numero
        assertEquals(0, contribuinte.calculaTributo(), 0); // calculo do tributo
        assertEquals(0, contribuinte.calculaDescontos(), 0); // calculo do desconto
        assertEquals(0, contribuinte.calculaImposto(), 0); // calculo do imposto
        assertEquals(2000, contribuinte.calculaRiqueza(), 0); // calculo da riqueza
    }
}
