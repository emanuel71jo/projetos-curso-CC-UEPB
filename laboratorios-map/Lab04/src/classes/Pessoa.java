package classes;

import java.util.ArrayList;

public class Pessoa {
	ArrayList<Funcao> funcoes = new ArrayList<Funcao>();
	private String nome;
	
	public Pessoa(String nome, Funcao fun) {
		this.nome = nome;
		this.funcoes.add(fun);
	}

	public String getFuncoes() {
		String str = "";
		for (Funcao funcao : funcoes) {
			str += funcao + " | ";
		}
		return str;
	}

	public void setFuncoes(Funcao funcoes) {
		this.funcoes.add(funcoes);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this.nome.equals(obj))
			return true;
		return false;
	}
	
	
	

}
