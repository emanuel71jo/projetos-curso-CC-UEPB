package model;

import java.util.List;

public class Quadrinho {
	
	private int id;
	private String urlCapa;
	private boolean status;
	private String autor;
	private int qtdPaginas;
	private String subtitulo;
	private String sinopse;
	private String titulo;
	private List<Genero> generos;
	private NotaFiscal notaFiscal;
	private Colecao colecao;
	
	
	
	public Quadrinho(Colecao colecao) {
		this.colecao = colecao;
	}
	public Quadrinho(String urlCapa, String autor, int qtdPaginas, String subtitulo, String sinopse,
			String titulo, Colecao colecao) {
		this.urlCapa = urlCapa;
		this.autor = autor;
		this.qtdPaginas = qtdPaginas;
		this.subtitulo = subtitulo;
		this.sinopse = sinopse;
		this.titulo = titulo;
		this.colecao = colecao;
	}
	public Quadrinho(int id) {
		this.id = id;
	}
	public Quadrinho() {
	}
	
	public Quadrinho(String urlCapa, String autor, int qtdPaginas, String subtitulo, String sinopse,
			String titulo, Colecao colecao, List<Genero> generos) {
		this.urlCapa = urlCapa;
		this.autor = autor;
		this.qtdPaginas = qtdPaginas;
		this.subtitulo = subtitulo;
		this.sinopse = sinopse;
		this.titulo = titulo;
		this.generos = generos;
		this.colecao = colecao;
	}
	public Quadrinho(String urlCapa, String autor, int qtdPaginas, String subtitulo, String sinopse,
			String titulo, NotaFiscal notaFiscal, Colecao colecao, List<Genero> generos) {
		this.urlCapa = urlCapa;
		this.autor = autor;
		this.qtdPaginas = qtdPaginas;
		this.subtitulo = subtitulo;
		this.sinopse = sinopse;
		this.titulo = titulo;
		this.generos = generos;
		this.notaFiscal = notaFiscal;
		this.colecao = colecao;
	}
	public Quadrinho(int id, String urlCapa, boolean status, String autor, int qtdPaginas, String subtitulo,
			String sinopse, String titulo, List<Genero> generos, NotaFiscal notaFiscal, Colecao colecao) {
		this.id = id;
		this.urlCapa = urlCapa;
		this.status = status;
		this.autor = autor;
		this.qtdPaginas = qtdPaginas;
		this.subtitulo = subtitulo;
		this.sinopse = sinopse;
		this.titulo = titulo;
		this.generos = generos;
		this.notaFiscal = notaFiscal;
		this.colecao = colecao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrlCapa() {
		return urlCapa;
	}
	public void setUrlCapa(String urlCapa) {
		this.urlCapa = urlCapa;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getQtdPaginas() {
		return qtdPaginas;
	}
	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public Colecao getColecao() {
		return colecao;
	}
	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}
	
	
	

}
