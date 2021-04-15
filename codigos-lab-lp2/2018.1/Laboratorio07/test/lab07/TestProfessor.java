
package lab07;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestProfessor {
    /**
     * Testando os metodos desconto e tributo da classe Professor;
     */
    @Test
    public void testCalculaDescontoETributo(){
        Casa casa = new Casa(10000);
        Carro carro = new Carro(10000);
        Contribuinte professor = new Professor(null, 100, casa, carro, 700, 200);
        assertEquals(100, professor.calculaDescontos(), 0); // material / 2
        assertEquals(35, professor.calculaTributo(), 0); //salario <= 700 minimo.
        professor = new Professor(null, 100, casa, carro, 3490, 200);
        assertEquals(349, professor.calculaTributo(), 0); //salario <= 3500 minimo * 5
        professor = new Professor(null, 100, casa, carro, 5000, 200);
        assertEquals(1000, professor.calculaTributo(), 0); // salario > 3500
        
        
        
    }
}
