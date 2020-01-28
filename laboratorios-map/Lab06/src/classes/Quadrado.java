package classes;

public class Quadrado implements FiguraGeometricaIF{
	private double larguraLado;
	
	public Quadrado(double lado) {
		this.larguraLado = lado;
	}
	
	public double getLarguraLado() {
		return larguraLado;
	}

	public void setLarguraLado(double larguraLado) {
		this.larguraLado = larguraLado;
	}

	@Override
	public double area() {
		return this.larguraLado * 2;
	}

	@Override
	public double perimetro() {
		return this.larguraLado * 4;
	}

}
