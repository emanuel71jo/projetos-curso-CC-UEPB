package classes;

public class Retangulo extends FiguraGeometrica{
	
	private int largura;
	private int altura;
	
	public Retangulo(int largura, int altura) {
		super();
		this.largura = largura;
		this.altura = altura;
	}
	
	@Override
	public int area() throws Exception {
		
		if(this.altura <= 0 || this.largura <= 0)
			throw new Exception("Figura não formada com esses valores");
		
		int a = this.largura * this.altura;
		System.out.println("A area do Retangulo é: " + a);
		return a;
	}
	
	@Override
	public int perimetro() throws Exception {
		
		if(this.altura <= 0 || this.largura <= 0)
			throw new Exception("Figura não formada com esses valores");
		
		int p = (2 * this.altura) + (2 * this.largura);
		System.out.println("O perímetro do Retangulo é: " + p);
		return p;
	}
	
	@Override
	public String toString() {
		return "O retângulo criado tem altura de tamanho:" + this.altura
				+ " e largura de tamanho: " + this.largura;
	}
	
	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
	
}
