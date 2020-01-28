package classes;

public class Main {

	public static void main(String[] args) throws Exception {
		
		FiguraGeometrica retangulo = new Retangulo(10, 5);
		FiguraGeometrica quadrado = new Quadrado(7);
		FiguraGeometrica circulo = new Circulo(25);
		
		retangulo.perimetro();
		quadrado.perimetro();
		circulo.perimetro();
		
		retangulo.area();
		quadrado.area();
		circulo.area();
		
		System.out.println(retangulo.toString());
		System.out.println(quadrado.toString());
		System.out.println(circulo.toString());
		
	}

}
