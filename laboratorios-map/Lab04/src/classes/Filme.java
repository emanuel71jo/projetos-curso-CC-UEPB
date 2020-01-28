package classes;

import java.util.ArrayList;

public class Filme {
	private String nome;
	private String trilhaSonora;
	private ArrayList<Pessoa> pessoas;
	
	public Filme(String nome, String trilhaSonora) {
		super();
		this.nome = nome;
		this.trilhaSonora = trilhaSonora;
		this.pessoas = new ArrayList<Pessoa>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTrilhaSonora() {
		return trilhaSonora;
	}

	public void setTrilhaSonora(String trilhaSonora) {
		this.trilhaSonora = trilhaSonora;
	}

	public ArrayList<Pessoa> getElenco() {
		return pessoas;
	}

	public Filme setElenco(String nome, Funcao fun) {
		this.pessoas.add(new Pessoa(nome, fun));
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object nome) {
		if(this.nome.equals(nome))
			return true;
		return false;
	}	
	
}
