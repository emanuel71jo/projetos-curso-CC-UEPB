
package laboratorio09;

/**
 *
 * @author João Emanuel
 */
public class TrianguloIsosceles extends Triangulo{
    private double base, altura;

    public TrianguloIsosceles(double base, double altura) {
        this.base = base;
        this.altura = altura;
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

    /**
     * Método que calcula o perimetro
     * @return perimetro
     */
    @Override
    public double calcularPerimetro() {
        return (this.altura * 2) + this.base;
    }

    /**
     * Método para o calculo da área
     * @return area
     */
    @Override
    public double calcularArea() {
        return this.base * this.altura;
    }

    /**
     * Método que escreve a figura que está sendo desenhada
     */
    @Override
    public void desenharFigura() {
        System.out.println("Desenhando um Triangulo Isosceles");
    }
    
    
}
