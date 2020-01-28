
package laboratorio09;

/**
 *
 * @author João Emanuel
 */
public class TrianguloEquilatero extends Triangulo{
    private double lado;

    public TrianguloEquilatero(double lado) {
        this.lado = lado;
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
        return lado * 3;
    }

    /**
     * Método para o calculo da área
     * @return area
     */
    @Override
    public double calcularArea() {
        return (Math.sqrt(3) / 4) * this.lado;
    }

    /**
     * Método que escreve a figura que está sendo desenhada
     */
    @Override
    public void desenharFigura() {
        System.out.println("Desenhando um Triangulo Equilatero");
    }

    
}
