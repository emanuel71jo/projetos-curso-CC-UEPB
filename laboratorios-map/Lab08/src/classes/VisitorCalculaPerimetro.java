package classes;

public class VisitorCalculaPerimetro implements VisitorIF{

	@Override
	public String visitaRetangulo(Retangulo r) {
		return "Perimetro do Retangulo: " + ((r.getAltura() * 2) + (r.getLargura() * 2));
	}

	@Override
	public String visitaCirculo(Circulo c) {
		return "Perimetro do Circulo: " + (2 * 3.14 * c.getRaio());
	}

	@Override
	public String visitaTriangulo(Triangulo t) {
		return "Perimetro do Triangulo: " + ((t.getAltura() * 2) + t.getBase());
	}

	@Override
	public String visitaTrapezio(Trapezio tr) {
		return "Perimetro do Trapezio: " + ((tr.getAltura() * 2) + tr.getBaseInferior() + tr.getBaseSuperior());
	}

}
