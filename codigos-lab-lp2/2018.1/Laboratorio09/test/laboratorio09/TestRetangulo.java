
package laboratorio09;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Emanuel
 */
public class TestRetangulo {
    
    /**
     * Testa o método que calcula a area do retangulo de base 4 e altura 2
     */
    @Test
    public void testCalculaArea(){
        Figuras retangulo = new Retangulo(4,2);
        Assert.assertEquals(8, retangulo.calcularArea(), 0);
    }
    
    /**
     * Testa o método que calcula o perimetro do retangulo de base 4 e altura 2
     */
    @Test
    public void testCalculaPerimetro(){
        Figuras retangulo = new Retangulo(4,2);
        Assert.assertEquals(12, retangulo.calcularPerimetro(), 0);
    }
}
