package classes;

public class Main {

	public static void main(String[] args) {
		
		Fabrica fabrica = new Fabrica();
		
		//Verificando se existe quadrados.
		System.out.println(fabrica.getAreaQuadrados());
		System.out.println(fabrica.getPerimetroQuadrados());
		
		//Adicionando 3 quadrados. Pode ser quantos quiser.
		fabrica.addQuadrado(10);
		fabrica.addQuadrado(50);
		fabrica.addQuadrado(100);
		
		//Pegando a area e o perimetro de todos os quadrados.
		System.out.println(fabrica.getQtdQuadrado());
		System.out.println(fabrica.getAreaQuadrados());
		System.out.println(fabrica.getPerimetroQuadrados());
		
		
		//Verificando que as instancias de circulo e triangulos estão nulas.
		System.out.println(fabrica.getInfoCirculo());
		System.out.println(fabrica.getInfoTrianguloEquilatero());
		System.out.println(fabrica.getInfoTrianguloIsosceles());
		System.out.println(fabrica.getInfoTrianguloRetangulo() + "\n");
		
		//Setando o raio 5 para o circulo. primeira instancia;
		fabrica.setCirculo(5);
		//Verificando a Area e o Perimetro do Circulo
		System.out.println(fabrica.getInfoCirculo());
		//Se settar outro valor continua sendo a instancia do outro circulo.
		fabrica.setCirculo(10);
		//Conferindo se foi instanciado novamente o circulo
		System.out.println(fabrica.getInfoCirculo());
		//Settar outro raio para a mesma instancia do circulo
		fabrica.setRaioCirculo(10);
		//Nova info de circulo, mas com mesma instancia
		System.out.println(fabrica.getInfoCirculo());
		

		
		

	}

}
