package classes;

public class Triangulo implements ElementoConcretoIF {

	private double altura;
	private double base;
	
	public Triangulo(double a, double b) {
		this.altura = a;
		this.base = b;
	}
	
	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	public double getBase() {
		return base;
	}



	public void setBase(double base) {
		this.base = base;
	}



	@Override
	public void aceitaVisita(VisitorIF v) {
		System.out.println(v.visitaTriangulo(this));
	}

}
