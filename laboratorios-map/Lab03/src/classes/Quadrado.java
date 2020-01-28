package classes;

public class Quadrado extends FiguraGeometrica{
	private int largura;

	public Quadrado(int largura) {
		this.largura = largura;
	}

	@Override
	public int area() throws Exception {
		
		if(this.largura <= 0)
			throw new Exception("Figura não formada com essa medida");
		
		int a = this.largura * this.largura;
		System.out.println("A área do Quadrado é: " + a);
		return a;
	}
	
	@Override
	public int perimetro() throws Exception {
		
		if(this.largura <= 0)
			throw new Exception("Figura não formada com essa medida");
		
		int p = 4 * this.largura;
		System.out.println("O perímetro do Quadrado é: " + p);
		return p;
	}
	
	@Override
	public String toString() {
		return "O quadrado criado tem lados de " + this.largura;
	}
	
	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}
	
	
}
