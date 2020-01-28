package classes;

public class VisitorMaximizar implements VisitorIF{

	@Override
	public String visitaRetangulo(Retangulo r) {
		r.setAltura(r.getAltura() * 2);
		r.setLargura(r.getLargura() * 2);
		return "Maximizado as medidas do Retangulo";
	}

	@Override
	public String visitaCirculo(Circulo c) {
		c.setRaio(c.getRaio() * 2);
		return "Maximizado as medidas do Circulo";
	}

	@Override
	public String visitaTriangulo(Triangulo t) {
		t.setAltura(t.getAltura() * 2);
		t.setBase(t.getBase() * 2);
		return "Maximizado as medidas do Triangulo";
	}

	@Override
	public String visitaTrapezio(Trapezio tr) {
		tr.setAltura(tr.getAltura() * 2);
		tr.setBaseInferior(tr.getBaseInferior() * 2);
		tr.setBaseSuperior(tr.getBaseSuperior() * 2);
		return "Maximizado as medidas do Trapezio";
	}

}
