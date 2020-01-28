package model;

import java.util.ArrayList;
import java.util.List;

public class Genero {

	private int id;
	private String nome;
	private List<Quadrinho> quadrinhos;
	
	public Genero() {
	}

	public Genero(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Genero(int id) {
		super();
		this.id = id;
	}

	public Genero(String nome) {
		this.nome = nome;
		this.quadrinhos = new ArrayList<Quadrinho>();
	}
	
	public Genero(int id, String nome, List<Quadrinho> quadrinhos) {
		this.id = id;
		this.nome = nome;
		this.quadrinhos = quadrinhos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Quadrinho> getQuadrinhos() {
		return quadrinhos;
	}

	public void setQuadrinhos(List<Quadrinho> quadrinhos) {
		this.quadrinhos = quadrinhos;
	}
	
	
	
}
