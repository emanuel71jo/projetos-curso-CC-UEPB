
package petshop;

import java.util.ArrayList;

/**
 *
 * @author João Emanuel
 */
public interface Funcionalidades {
    public void cadastrar(SuperClasse sc);
    public void remover(SuperClasse sc);
    public void cadastrar(ArrayList<SuperClasse> sc);
    public ArrayList<SuperClasse> listar();
}
