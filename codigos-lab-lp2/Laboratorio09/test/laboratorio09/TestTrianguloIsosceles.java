
package laboratorio09;


import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Emanuel
 */
public class TestTrianguloIsosceles {
    /**
     * Testa o método que calcula a area do triangulo isosceles
     */
    @Test
    public void testCalculaArea(){
        Figuras triangulo = new TrianguloIsosceles(2,5);
        Assert.assertEquals(10, triangulo.calcularArea(), 0);
    }
    
    /**
     * Testa o método que calcula o perimetro do triangulo isosceles
     */
    @Test
    public void testCalculaPerimetro(){
        Figuras triangulo = new TrianguloIsosceles(2,5);
        Assert.assertEquals(12, triangulo.calcularPerimetro(), 0);
    }
}
