
package lab07;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Emanuel
 */
public class TestMedico {
    /**
     * Verificando o desconto e o tributo da classe Medico;
     */
    @Test
    public void testCalculaDescontoETributo(){
        Casa casa = new Casa(10000);
        Carro carro = new Carro(10000);
        Contribuinte medico = new Medico(null, 001, casa, carro, 1, 100);
        assertEquals(100, medico.calculaDescontos(), 0); // congressos = 100, return 100
        assertEquals(10, medico.calculaTributo(), 0); // atendimento = 1 , return 10
        
        
    }
}
