
package laboratorio02.pkg1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Emanuel
 */
public class JogadorTest {
    
    @Test
    public void testJogando() {
        Jogador jogador1 = new Jogador();
        assertTrue(jogador1.jogando(2));
        

    }
}
