package classes;

public abstract class Triangulo implements FiguraGeometricaIF{
	private double ladoDireito;
	private double ladoEsquerdo;
	private double base;
	protected Triangulo(double l1, double l2, double l3) {
		this.ladoDireito = l1;
		this.ladoEsquerdo = l2;
		this.base = l3;
	}
	public double getLadoDireito() {
		return ladoDireito;
	}
	public void setLadoDireito(double ladoDireito) {
		this.ladoDireito = ladoDireito;
	}
	public double getLadoEsquerdo() {
		return ladoEsquerdo;
	}
	public void setLadoEsquerdo(double ladoEsquerdo) {
		this.ladoEsquerdo = ladoEsquerdo;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	
}
