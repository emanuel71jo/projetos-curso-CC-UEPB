package classes;

public class Circulo implements ElementoConcretoIF{

	private double raio;
	
	public Circulo(double r) {
		this.raio = r;
	}
	
	
	
	public double getRaio() {
		return raio;
	}



	public void setRaio(double raio) {
		this.raio = raio;
	}



	@Override
	public void aceitaVisita(VisitorIF v) {
		System.out.println(v.visitaCirculo(this));
	}

}
