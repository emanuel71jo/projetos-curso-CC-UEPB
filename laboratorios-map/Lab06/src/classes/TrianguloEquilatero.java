package classes;

public class TrianguloEquilatero extends Triangulo {
	
	private static TrianguloEquilatero INSTANCE;
	
	private TrianguloEquilatero(double larguraLado) {
		super(larguraLado, larguraLado, larguraLado);
	}
	
	//public static synchronized getINSTANCE( double base) {
	public static TrianguloEquilatero getINSTANCE(double larguraLado) {
		if(INSTANCE == null) {
			synchronized (TrianguloEquilatero.class) {
				if(INSTANCE == null)
					INSTANCE = new TrianguloEquilatero(larguraLado);
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
