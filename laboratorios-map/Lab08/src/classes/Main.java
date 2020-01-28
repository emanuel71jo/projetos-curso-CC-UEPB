package classes;

public class Main {
	public static void main(String[] args) {
		//Figura geometricas
		Circulo circulo = new Circulo(15);
		Retangulo retangulo = new Retangulo(15, 10);
		Trapezio trapezio = new Trapezio(15, 20, 10);
		Triangulo triangulo = new Triangulo(20, 10);
		
		//Visitor para calcular a area
		VisitorIF visitaCA = new VisitorCalculaArea();
		
		//Area das figura geometricas
		circulo.aceitaVisita(visitaCA);
		retangulo.aceitaVisita(visitaCA);
		trapezio.aceitaVisita(visitaCA);
		triangulo.aceitaVisita(visitaCA);
		System.out.println();

		//Visitor para calcular a Perimetro
		visitaCA = new VisitorCalculaPerimetro();
		
		//Perimetro das figura geometricas
		circulo.aceitaVisita(visitaCA);
		retangulo.aceitaVisita(visitaCA);
		trapezio.aceitaVisita(visitaCA);
		triangulo.aceitaVisita(visitaCA);
		System.out.println();
		
		//Visitor para desenhar figuras
		visitaCA = new VisitorDesenhar();
		
		//Desenho das figura geometricas
		circulo.aceitaVisita(visitaCA);
		retangulo.aceitaVisita(visitaCA);
		trapezio.aceitaVisita(visitaCA);
		triangulo.aceitaVisita(visitaCA);
		System.out.println();
		
		//Visitor para maximar as medidas
		visitaCA = new VisitorMaximizar();
		
		//Perimetro das figura geometricas
		circulo.aceitaVisita(visitaCA);
		retangulo.aceitaVisita(visitaCA);
		trapezio.aceitaVisita(visitaCA);
		triangulo.aceitaVisita(visitaCA);
		
	}
}
