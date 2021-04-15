
package laboratorio09;

/**
 *
 * @author João Emanuel
 */
public class Retangulo implements Figuras{

    private double base, altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    /**
     * Método que escreve a figura que está sendo desenhada
     */
    @Override
    public void desenharFigura() {
        System.out.println("Desenhando um Retangulo");
    }

    /**
     * Método para o calculo da área
     * @return area
     */
    @Override
    public double calcularArea() {
        return this.altura * this.base;
    }

    /**
     * Método que calcula o perimetro
     * @return perimetro
     */
    @Override
    public double calcularPerimetro() {
        return (this.altura * 2) + (this.base * 2);
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
