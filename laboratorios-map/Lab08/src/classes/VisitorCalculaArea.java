package classes;

public class VisitorCalculaArea implements VisitorIF{

	@Override
	public String visitaRetangulo(Retangulo r) {
		return "Area do Retangulo: " + r.getAltura() * r.getLargura();
	}

	@Override
	public String visitaCirculo(Circulo c) {
		return "Area do Circulo: " + 3.14 * c.getRaio() * c.getRaio();
	}

	@Override
	public String visitaTriangulo(Triangulo t) {
		return "Area do Triangulo: " + (t.getAltura() * t.getBase()) / 2;
	}

	@Override
	public String visitaTrapezio(Trapezio tr) {
		return "Area do Trapezio: " + ((tr.getBaseInferior() + tr.getBaseSuperior()) * tr.getAltura()) / 2;
	}

}
