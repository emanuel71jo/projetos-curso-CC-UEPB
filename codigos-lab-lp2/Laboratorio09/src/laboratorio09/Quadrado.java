
package laboratorio09;

/**
 *
 * @author João Emanuel
 */
public class Quadrado implements Figuras{
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    /**
     * Método que escreve a figura que está sendo desenhada
     */
    @Override
    public void desenharFigura() {
        System.out.println("Desenhando um Quadrado");
    }

    /**
     * Método para o calculo da área
     * @return area
     */
    @Override
    public double calcularArea() {
        return this.lado * 2;
    }

    /**
     * Método que calcula o perimetro
     * @return perimetro
     */
    @Override
    public double calcularPerimetro() {
        return this.lado * 4;
    }

    /**
     * Imprime todas as informações referente a este objeto
     */
    @Override
    public void informacaoFigura() {
        System.out.println("");
        this.desenharFigura();
        System.out.println("Area: " + this.calcularArea());
        System.out.println("Perimetro: " + this.calcularPerimetro());
        System.out.println("");
    }
    
    
}
