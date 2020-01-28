package classes;

public class Circulo extends FiguraGeometrica{
	private int raio;

	public Circulo(int raio) {
		this.raio = raio;
	}

	@Override
	public int area() throws Exception {
		
		if(this.raio <= 0)
			throw new Exception("Figura não formada com essa medida");
		
		int a = (int) (2 * 3.14 + this.raio);
		System.out.println("A área do Circulo é: " + a);
		return a;
	}
	
	@Override
	public int perimetro() throws Exception {
		
		if(this.raio <= 0)
			throw new Exception("Figura não formada com essa medida");
		
		int p = (int) (3.14 * this.raio);
		System.out.println("O perímetro do Circulo é: " + p);
		return p;
	}
	
	@Override
	public String toString() {
		return "O circulo criado tem raio de " + this.raio;
	}
	
	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}
	
	
}
