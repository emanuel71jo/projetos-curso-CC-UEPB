package questions;

import utils.DiarioDeNotas;

public class Question10 {
	public void render() {
		DiarioDeNotas diario1 = new DiarioDeNotas("Laboratório de Programação II", "Wellington");
		DiarioDeNotas diario2 = new DiarioDeNotas("Programação Web", "Demetrio");
		DiarioDeNotas diario3 = new DiarioDeNotas("Projeto de Interface Homem-Computador", "Eduardo");
		DiarioDeNotas diario4 = new DiarioDeNotas("Compiladores", "Kézia");
		DiarioDeNotas diario5 = new DiarioDeNotas("Computação de Alto Desempenho", "Paulo");
		
		diario1.showMessage();
		diario2.showMessage();
		diario3.showMessage();
		diario4.showMessage();
		diario5.showMessage();
	}
}
