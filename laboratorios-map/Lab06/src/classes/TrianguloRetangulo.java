package classes;

public class TrianguloRetangulo extends Triangulo{
	
	private static TrianguloRetangulo INSTANCE;
	
	private TrianguloRetangulo(double catetoOposto, double catetoAdjacente, double hipotenusa) {
		super(catetoAdjacente, catetoOposto, hipotenusa);
	}
	
	//public static synchronized getINSTANCE(double co, double ca, double hi) {
	public static TrianguloRetangulo getINSTANCE(double co,double ca,double hi) {
		if(INSTANCE == null) {
			synchronized (TrianguloRetangulo.class) {
				if(INSTANCE == null)
					INSTANCE = new TrianguloRetangulo(co, ca, hi);
			}
		}
		return INSTANCE;
	}

	@Override
	public double area() {
		return (this.getBase() * this.getLadoDireito()) / 2;
	}

	@Override
	public double perimetro() {
		return this.getBase() + this.getLadoDireito() + this.getLadoEsquerdo();
	}
}
