
package laboratorio09;

/**
 *
 * @author João Emanuel
 */
public abstract class Triangulo implements Figuras{
    
    /**
     * Método que calcula o perimetro
     * @return perimetro
     */
    @Override
    public void desenharFigura() {
    }

    /**
     * Método para o calculo da área
     * @return area
     */
    @Override
    public double calcularArea() {
        return 0.0;
    }
    
    /**
     * Método que calcula o perimetro
     * @return perimetro
     */
    @Override
    public double calcularPerimetro() {
        return 0.0;
    }

    /**
     * Imprime todas as informações referente a este objeto
     */
    @Override
    public void informacaoFigura() {
    }
    
}
