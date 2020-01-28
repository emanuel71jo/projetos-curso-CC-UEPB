package model;

import java.util.ArrayList;
import java.util.List;

public class Colecao {
	private int id;
	private String nome;
	private String editora;
	private List<Quadrinho> quadrinhos;
	
	public Colecao(int id, String nome, String editora) {
		super();
		this.id = id;
		this.nome = nome;
		this.editora = editora;
	}
	public Colecao(String nome, String editora) {
		this.nome = nome;
		this.editora = editora;
		this.quadrinhos = new ArrayList<Quadrinho>();
	}
	public Colecao(int id, String nome, String editora, List<Quadrinho> quadrinhos) {
		super();
		this.id = id;
		this.nome = nome;
		this.editora = editora;
		this.quadrinhos = quadrinhos;
	}
	public Colecao() {
	}
	
	public Colecao(int id) {
		this.id = id;
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
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public List<Quadrinho> getQuadrinhos() {
		return quadrinhos;
	}
	public void setQuadrinhos(List<Quadrinho> quadrinhos) {
		this.quadrinhos = quadrinhos;
	}
	
	

}
