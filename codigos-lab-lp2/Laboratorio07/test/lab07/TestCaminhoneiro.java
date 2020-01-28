
package lab07;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author João Emanuel
 */
public class TestCaminhoneiro {
    
    /**
     * Teste se o desconto será de 10 se o carro tiver 1000Km rodados.
     * Teste se o tributo é 9490 se tonelada > 10 ou 490 se tonelada <= 10.
     */
    @Test
    public void testCalculaDescontoETributo(){
        Casa casa = new Casa(10000);
        Carro carro = new Carro(10000);
        Contribuinte caminhoneiro = new Caminhoneiro(null, 0001, casa, carro, 100, 1000);
        Assert.assertEquals(10, caminhoneiro.calculaDescontos(), 0); //Testa metodo calculaDesconto();
        Assert.assertEquals(9490, caminhoneiro.calculaImposto(), 0); //Testa o metodo calculaTributo(); Se tonelada > 10
        caminhoneiro = new Caminhoneiro(null, 0001, casa, carro, 10, 1000);
        Assert.assertEquals(490, caminhoneiro.calculaImposto(), 0); //Testa o metodo calculaTributo(); Se tonelada <= 10
    }
    
}
