
package laboratorio09;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Emanuel
 */
public class TestTrianguloRetangulo {
    
    /**
     * Testa o método que calcula a area do triangulo retangulo
     */
    @Test
    public void testCalculaArea(){
        Figuras triangulo = new TrianguloRetangulo(2,3,4);
        Assert.assertEquals(3, triangulo.calcularArea(), 0);
    }
    
    /**
     * Testa o método que calcula o perimetro do triangulo retangulo
     */
    @Test
    public void testCalculaPerimetro(){
        Figuras triangulo = new TrianguloRetangulo(2,3,4);
        Assert.assertEquals(9, triangulo.calcularPerimetro(), 0);
    }
}
