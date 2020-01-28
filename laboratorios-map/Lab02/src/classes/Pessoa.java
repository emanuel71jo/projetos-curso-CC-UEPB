package classes;

import java.util.ArrayList;

public abstract class Pessoa {
	private String nome;
	private int matricula;
	
	public Pessoa(String nome, int mat) {
		super();
		this.nome = nome;
		this.matricula = mat;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
