
package laboratorio10;

/**
 *
 * @author usuario
 */
public class PagamentoCartao extends Pagamento{
    private double parcelas;

    public PagamentoCartao(double valor, double parcelas) {
        super(valor);
        this.parcelas = parcelas;
    }

    public double getParcelas() {
        return parcelas;
    }

    public void setParcelas(double parcelas) {
        this.parcelas = parcelas;
    }
    
}
