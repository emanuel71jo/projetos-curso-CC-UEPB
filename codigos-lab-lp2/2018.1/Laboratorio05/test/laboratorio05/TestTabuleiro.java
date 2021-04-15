
package laboratorio05;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author João Emanuel
 */
public class TestTabuleiro {
    
    /**
     * O método testa se o tabuleiro foi formado com a forma correta. Não foi realizado nenhuma jogada ainda.
     */
    @Test
    public void testFormaTabuleiro(){
        Tabuleiro tabuleiro = new Tabuleiro();
        String tab = "   |   |  \n-----------\n   |   |  \n-----------\n   |   |  ";
        Assert.assertEquals(tab,tabuleiro.formaTabuleiro());
    }
    /**
     * O método testa se o estado do tabuleiro está funcionando da forma correnta. E os retornos são os esperados.
     */
    @Test
    public void testEstadoTabuleiro(){
        Tabuleiro tabuleiro = new Tabuleiro();
        Assert.assertTrue(tabuleiro.estadoTabuleiro(0, 0, 'X')); // É adicionado uma jogada ao tabuleiro
        Assert.assertFalse(tabuleiro.estadoTabuleiro(0, 0, 'O')); // É feito uma jogada em um local que já teve jogada
        Assert.assertTrue(tabuleiro.estadoTabuleiro(0, 1, 'X')); // É feita uma jogada em outro local.
    }
    /**
     * O método faz o teste se a saída do tabuleiro é a esperada apos ser realizado jogadas.
     */
    public void testFormaTabuleiroComJogada(){
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.estadoTabuleiro(0, 0, 'X'); // É adicionado uma jogada ao tabuleiro
        String tab = "X |  | \n--------\n  |  | \n--------\n  |  | "; // Valor esperado de retorno.
        Assert.assertEquals(tab,tabuleiro.formaTabuleiro()); // Testa se a jogada foi colocada no tabuleiro
        tabuleiro.estadoTabuleiro(0, 1, 'O'); // É adiconado outra jogada ao tabuleiro
        tab = "X |O | \n--------\n  |  | \n--------\n  |  | "; // Valor esperado de retorno.
        Assert.assertEquals(tab,tabuleiro.formaTabuleiro()); // Testa se as duas jogadas estão no tabuleiro.

    }
}