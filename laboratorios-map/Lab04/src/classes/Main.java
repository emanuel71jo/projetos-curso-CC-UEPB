package classes;

public class Main {

	public static void main(String[] args) {
		Funcao funcao = null;
		Gerenciamento gere = new Gerenciamento();
		Filme filme = new Filme("MAP", "AULA")
				.setElenco("JOAO", funcao.DIRETOR)
				.setElenco("PEDRO", funcao.CINEGRAFISTA);
		
		gere.setFilme(filme);
		
		System.out.println(gere.caracteristicaFilme("MAP"));
		System.out.println(gere.filmografia("JOAO"));
		
	}
}
