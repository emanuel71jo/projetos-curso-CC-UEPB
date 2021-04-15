
package laboratorio09;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Emanuel
 */
public class TestCirculo {
    
    /**
     * Testa o método que calcula a area do circulo de raio 4
     */
    @Test
    public void testCalculaArea(){
        Figuras circulo = new Circulo(4);
        Assert.assertEquals(50.24, circulo.calcularArea(), 0);
    }
    
    /**
     * Testa o método que calcula o perimetro do circulo de raio 4
     */
    @Test
    public void testCalculaPerimetro(){
        Figuras circulo = new Circulo(4);
        Assert.assertEquals(25.12, circulo.calcularPerimetro(), 0);
    }

}
