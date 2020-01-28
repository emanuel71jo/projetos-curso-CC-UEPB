package classes;

import java.util.ArrayList;

public class Fabrica implements FabricaIF{
	private Triangulo trianguloEquilatero;
	private Triangulo trianguloIsosceles;
	private Triangulo trianguloRetangulo;
	private Circulo circulo;
	private ArrayList<Quadrado> quadrados;
	
	public Fabrica() {
		this.quadrados = new ArrayList<Quadrado>();
	}
	
	@Override
	public String getAreaQuadrados() {
		if(this.quadrados.size() == 0)
			return "vazio\n";
		
		String str = "";
		for(Quadrado q: this.quadrados)
			str += "Area: " + q.area() + "\n";
		return str;
	}
	
	@Override
	public String getPerimetroQuadrados() {
		if(this.quadrados.size() == 0)
			return "vazio\n";
		
		String str = "";
		for(Quadrado q: this.quadrados)
			str += "Perimetro: " + q.perimetro() + "\n";
		return str;
	}
	
	@Override
	public int getQtdQuadrado() {
		return this.quadrados.size();
	}
	
	@Override
	public void addQuadrado(double diametroQuadrado) {
		this.quadrados.add(new Quadrado(diametroQuadrado));
	}

	@Override
	public void setTriangulo(double altura, double base) {
		this.trianguloIsosceles = TrianguloIsoscele.getINSTANCE(altura, base);
	}

	@Override
	public void setTriangulo(double larguraLado) {
		this.trianguloEquilatero = TrianguloEquilatero.getINSTANCE(larguraLado);
	}

	@Override
	public void setTriangulo(double catetoOposto, double catetoAdjascente, double hipotenusa) {
		this.trianguloRetangulo = TrianguloRetangulo.getINSTANCE(catetoOposto, catetoAdjascente, hipotenusa);
	}

	@Override
	public void setCirculo(double raio) {
		this.circulo = Circulo.getINSTANCE(raio);
	}

	@Override
	public String getInfoTrianguloEquilatero() {
		if(this.trianguloEquilatero == null)
			return null;
		return "Triangulo Equilatero\n" + "Area: " + this.trianguloEquilatero.area() + "\nPerimetro: " + this.trianguloEquilatero.perimetro();
	}

	@Override
	public String getInfoTrianguloIsosceles() {
		if(this.trianguloIsosceles == null)
			return null;
		return "Triangulo Isosceles\n" + "Area: " + this.trianguloIsosceles.area() + "\nPerimetro: " + this.trianguloIsosceles.perimetro();
	}
	
	@Override
	public String getInfoTrianguloRetangulo() {
		if(this.trianguloRetangulo == null)
			return null;
		return "Triangulo Retangulo\n" + "Area: " + this.trianguloRetangulo.area() + "\nPerimetro: " + this.trianguloRetangulo.perimetro();
	}

	@Override
	public String getInfoCirculo() {
		if(this.circulo == null)
			return null;
		return "Circulo\n" + "Area: " + this.circulo.area() + "\nPerimetro: " + this.circulo.perimetro();
	}
	
	@Override
	public void setRaioCirculo(double raio) {
		if(this.circulo == null)
			this.setCirculo(raio);
		this.circulo.setRaio(raio);
	}
	
}
