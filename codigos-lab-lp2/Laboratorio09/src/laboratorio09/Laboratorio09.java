
package laboratorio09;

/**
 *
 * @author João Emanuel
 */
public class Laboratorio09 {

    public static void main(String[] args) {
        Figuras[] figuras = new Figuras[6];
        figuras[0] = new Circulo(2);
        figuras[1] = new Quadrado(3);
        figuras[2] = new Retangulo(2,5);
        figuras[3] = new TrianguloEquilatero(8);
        figuras[4] = new TrianguloIsosceles(4,7);
        figuras[5] = new TrianguloRetangulo(4,9,5);
        
        figuras[0].informacaoFigura();
        figuras[1].informacaoFigura();
        figuras[2].informacaoFigura();
        figuras[3].informacaoFigura();
        figuras[4].informacaoFigura();
        figuras[5].informacaoFigura();
    }
}
