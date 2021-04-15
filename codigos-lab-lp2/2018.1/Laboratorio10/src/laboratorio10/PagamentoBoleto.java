
package laboratorio10;

/**
 *
 * @author usuario
 */
public class PagamentoBoleto extends Pagamento{
    private double taxa;

    public PagamentoBoleto(double valor, double taxa) {
        super(valor);
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
    
}
