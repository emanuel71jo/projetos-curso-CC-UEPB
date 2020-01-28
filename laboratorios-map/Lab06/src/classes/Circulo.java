package classes;

public class Circulo implements FiguraGeometricaIF{
	private double raio;
	private static Circulo INSTANCE;
	
	private Circulo(double raio) {
		this.raio = raio;
	}
	
	//public static synchronized getINSTANCE(double r) {
	public static Circulo getINSTANCE(double r) {
		if(INSTANCE == null) {
			synchronized (Circulo.class) {
				if(INSTANCE == null)
					INSTANCE = new Circulo(r);
			}
		}
		return INSTANCE;
	}
	
	
	
	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	@Override
	public double area() {
		return 3.14 * this.raio * this.raio;
	}

	@Override
	public double perimetro() {
		return 2 * 3.14 * this.raio;
	}

}
