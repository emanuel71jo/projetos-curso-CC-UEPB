package classes;

import java.util.ArrayList;

public class Gerenciamento implements GerenciamentoIF {

	ArrayList<Filme> filmes = new ArrayList<Filme>();
	
	public void setFilme(Filme filme) {
		filmes.add(filme);
	}
	
	@Override
	public String filmografia(String nome) {
		String str = "";
		for (Filme filme : filmes) {
			for (Pessoa p : filme.getElenco()) {
				if(p.getNome().equals(nome)) {
					str += "Filme: " + filme.getNome();
					continue;
				}
			}
		}
		return str;
	}

	@Override
	public String caracteristicaFilme(String nome) {
		String str = "";
		for (Filme filme : filmes) {
			if(filme.equals(nome)) {
				for (Pessoa p : filme.getElenco()) {
					str += "Nome: " + p.getNome() + "  Funcão(ões): " + p.getFuncoes() + "\n";
				}
				break;
			}
		}
		return str;
	}

}
