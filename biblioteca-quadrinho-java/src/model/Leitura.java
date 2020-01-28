package model;

import java.sql.Timestamp;

public class Leitura {
	
	private String dataLeitura;
	private String avaliacao;
	private Usuario usuario;
	private Quadrinho quadrinho;
	
	
	
	public Leitura(String dataLeitura, Usuario usuario, Quadrinho quadrinho) {
		super();
		this.dataLeitura = dataLeitura;
		this.usuario = usuario;
		this.quadrinho = quadrinho;
	}
	public Leitura(Usuario usuario, Quadrinho quadrinho) {
		super();
		this.usuario = usuario;
		this.quadrinho = quadrinho;
	}
	public Leitura(String dataLeitura, Usuario usuario) {
		super();
		this.dataLeitura = dataLeitura;
		this.usuario = usuario;
	}
	public Leitura(String dataLeitura, Quadrinho quadrinho) {
		super();
		this.dataLeitura = dataLeitura;
		this.quadrinho = quadrinho;
	}
	public Leitura() {
		super();
	}
	
	public Leitura(String dataLeitura, String avaliacao, Usuario usuario, Quadrinho quadrinho) {
		this.dataLeitura = dataLeitura;
		this.avaliacao = avaliacao;
		this.usuario = usuario;
		this.quadrinho = quadrinho;
	}
	
	public String getDataLeitura() {
		return dataLeitura;
	}
	public void setDataLeitura(String dataLeitura) {
		this.dataLeitura = dataLeitura;
	}
	public String getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Quadrinho getQuadrinho() {
		return quadrinho;
	}
	public void setQuadrinho(Quadrinho quadrinho) {
		this.quadrinho = quadrinho;
	}
	
	
}
