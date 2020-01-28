
package laboratorio09;

/**
 *
 * @author João Emanuel
 */
public class TrianguloRetangulo extends Triangulo{
    private double lado1, lado2, lado3;

    public TrianguloRetangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
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
        return this.lado1 + this.lado2 + this.lado3;
    }

    /**
     * Método para o calculo da área
     * @return area
     */
    @Override
    public double calcularArea() {
        return (this.lado1 * this.lado2) / 2;
    }

    /**
     * Método que escreve a figura que está sendo desenhada
     */
    @Override
    public void desenharFigura() {
        System.out.println("Desenhando um Triangulo Retangulo");
    }
    
    
}
