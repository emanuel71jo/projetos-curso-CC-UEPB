
package laboratorio02.pkg1;

import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.Matcher;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author João Emanuel
 */
public class JogandoTest {
    
    @Test
    public void testVerificandoGanhador(){
        Jogando jogando = new Jogando();
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        String res = "EMPATE";
        jogador1.jogando(2);
        jogador2.jogando(2);
        
        assertThat(jogando.verificandoGanhador(jogador1, jogador2),is(res));
        
    }

}
