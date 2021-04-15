
package laboratorio09;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Emanuel
 */
public class TestQuadrado {
    
       
    /**
     * Testa o método que calcula a area do quadrado de lados 4
     */
    @Test
    public void testCalculaArea(){
        Figuras quadrado = new Quadrado(4);
        Assert.assertEquals(8, quadrado.calcularArea(), 0);
    }
    
    /**
     * Testa o método que calcula o perimetro do quadrado de lados 4
     */
    @Test
    public void testCalculaPerimetro(){
        Figuras quadrado = new Quadrado(4);
        Assert.assertEquals(16, quadrado.calcularPerimetro(), 0);
    }
}
