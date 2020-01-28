package classes;

public class TrianguloIsoscele extends Triangulo{
	
	private static TrianguloIsoscele INSTANCE;
	
	private TrianguloIsoscele(double altura, double base) {
		super(altura, altura, base);
	}

	//public static synchronized getINSTANCE(double lado, double base) {
	public static TrianguloIsoscele getINSTANCE(double lado, double base) {
		if(INSTANCE == null) {
			synchronized (TrianguloIsoscele.class) {
				if(INSTANCE == null)
					INSTANCE = new TrianguloIsoscele(lado, base);
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
