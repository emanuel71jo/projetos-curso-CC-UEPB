package classes;

public class Trapezio implements ElementoConcretoIF{
	
	private double baseSuperior;
	private double baseInferior;
	private double altura;
	
	public Trapezio(double bs, double bi, double a) {
		this.altura = a;
		this.baseInferior = bi;
		this.baseSuperior = bs;
	}
	
	public double getBaseSuperior() {
		return baseSuperior;
	}



	public void setBaseSuperior(double baseSuperior) {
		this.baseSuperior = baseSuperior;
	}



	public double getBaseInferior() {
		return baseInferior;
	}



	public void setBaseInferior(double baseInferior) {
		this.baseInferior = baseInferior;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	@Override
	public void aceitaVisita(VisitorIF v) {
		System.out.println(v.visitaTrapezio(this));	
	}

}
