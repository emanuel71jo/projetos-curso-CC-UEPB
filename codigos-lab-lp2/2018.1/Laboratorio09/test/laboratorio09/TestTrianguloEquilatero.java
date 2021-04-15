
package laboratorio09;

;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Emanuel
 */
public class TestTrianguloEquilatero {
    
    /**
     * Testa o método que calcula a area do triangulo equilatero
     */
    @Test
    public void testCalculaArea(){
        Figuras triangulo = new TrianguloEquilatero(8);
        Assert.assertEquals(3.4641016151377544, triangulo.calcularArea(), 0);
    }
    
    /**
     * Testa o método que calcula o perimetro do triangulo equilatero
     */
    @Test
    public void testCalculaPerimetro(){
        Figuras triangulo = new TrianguloEquilatero(8);
        Assert.assertEquals(24, triangulo.calcularPerimetro(), 0);
    }
}
