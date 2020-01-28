package classes;

public interface FabricaIF {
	public void addQuadrado(double diametroQuadrado);
	public int getQtdQuadrado();
	public String getAreaQuadrados();
	public String getPerimetroQuadrados();
	public void setTriangulo(double altura, double base);
	public void setTriangulo(double larguraLado);
	public void setTriangulo(double catetoOposto, double catetoAdjascente, double hipotenusa);
	public void setCirculo(double raio);
	public void setRaioCirculo(double raio);
	public String getInfoTrianguloEquilatero();
	public String getInfoTrianguloIsosceles();
	public String getInfoTrianguloRetangulo();
	public String getInfoCirculo();
}
