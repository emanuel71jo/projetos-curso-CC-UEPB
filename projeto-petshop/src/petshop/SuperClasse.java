
package petshop;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public abstract class SuperClasse implements Serializable{
    private int cod;

    public SuperClasse(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
