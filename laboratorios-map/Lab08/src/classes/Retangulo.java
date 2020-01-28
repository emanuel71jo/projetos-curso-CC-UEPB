package classes;

public class Retangulo implements ElementoConcretoIF{

	private double altura;
	private double largura;
	
	public Retangulo(double a, double l) {
		this.altura = a;
		this.largura = l;
	}
	
	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	public double getLargura() {
		return largura;
	}



	public void setLargura(double largura) {
		this.largura = largura;
	}



	@Override
	public void aceitaVisita(VisitorIF v) {
		System.out.println(v.visitaRetangulo(this));
	}

}
