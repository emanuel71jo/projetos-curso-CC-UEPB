package classes;

public interface VisitorIF {
	public String visitaRetangulo(Retangulo r);
	public String visitaCirculo(Circulo c);
	public String visitaTriangulo(Triangulo t);
	public String visitaTrapezio(Trapezio tr);
}
