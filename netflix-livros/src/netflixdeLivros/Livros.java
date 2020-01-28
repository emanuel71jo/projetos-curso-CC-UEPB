/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixdeLivros;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dijay, Jo√£o e Pedro.
 */
public class Livros implements Serializable{
 
	private String titulo, editora, idioma, assunto, descricao, edicao, ISBN;
    private int ano;
    public ArrayList<String> comentario = new ArrayList<String>();
    public ArrayList<String> justificativa = new ArrayList<String>();
    public ArrayList<String> autores = new ArrayList<String>();
 
    /***Construtor
     * 
     * @param autores Array List de autores do Livro.
     * @param comentario Array List de coment·rios feitos sobre o livro.
     * @param justificativa Array List de justificativas feitas por ter abandonado a leitura do livro.
     * @param titulo Titulo do livro.
     * @param editora editora do livro.
     * @param idioma Idioma do livro.
     * @param assunto Assunto do livro, de que se trata.
     * @param descricao Sinopse sobre o livro.
     * @param edicao Edicao do livro.
     * @param ISBN CÛdigo do livro.
     * @param ano Ano do livro.
     */
    public Livros(ArrayList<String> autores, ArrayList<String> comentario, ArrayList<String> justificativa, String titulo,
    		String editora, String idioma, String assunto, String descricao, String edicao, String ISBN, int ano) {
        
    	this.titulo = titulo;
        this.editora = editora;
        this.idioma = idioma;
        this.assunto = assunto;
        this.descricao = descricao;
        this.edicao = edicao;
        this.ISBN = ISBN;
        this.ano = ano;
        this.autores = autores;
        this.comentario = comentario;
        this.justificativa = justificativa;
        
    }
	
 
    /***
     * 
     * @return Array List de coment·rios feitos sobre o livro.
     */
    @SuppressWarnings("unused")
	private ArrayList<String> getComentario() {
		return comentario;
	}


    /***
     * 
     * @param comentario Array List de coment·rios feitos sobre o livro.
     */
	@SuppressWarnings("unused")
	private void setComentario(ArrayList<String> comentario) {
		this.comentario = comentario;
	}


	/***
	 * 
	 * @return Array List de justificativas feitas por ter abandonado o livro.
	 */
	@SuppressWarnings("unused")
	private ArrayList<String> getJustificativa() {
		return justificativa;
	}


	/***
	 * 
	 * @param justificativa Array List de justificativas feitas por ter abandonado o livro.
	 */
	@SuppressWarnings("unused")
	private void setJustificativa(ArrayList<String> justificativa) {
		this.justificativa = justificativa;
	}

	/***
	 * 
	 * @return Titulo do livro.
	 */
	public String getTitulo() {
        return titulo;
    }

	/***
	 * 
	 * @param titulo Titulo do livro.
	 */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /***
     * 
     * @return Editora do livro.
     */
    public String getEditora() {
        return editora;
    }

    /***
     * 
     * @param editora Editora do livro.
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /***
     * 
     * @return Idioma do livro.
     */
    public String getIdioma() {
        return idioma;
    }

    /***
     * 
     * @param idioma Idioma do livro.
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /***
     * 
     * @return Assunto do livro.
     */
    public String getAssunto() {
        return assunto;
    }

    /***
     * 
     * @param assunto Assunto do livro.
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    /***
     * 
     * @return Sinopse do livro.
     */
    public String getDescricao() {
        return descricao;
    }

    /***
     * 
     * @param descricao Sinopse do livro.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /***
     * 
     * @return Edicao do livro.
     */
    public String getEdicao() {
        return edicao;
    }

    /***
     * 
     * @param edicao Edicao do livro.
     */
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    /***
     * 
     * @return Codigo do livro.
     */
    public String getISBN() {
        return this.ISBN;
    }

    /***
     * 
     * @param ISBN Codigo do livro.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /***
     * 
     * @return Ano do livro.
     */
    public int getAno() {
        return ano;
    }

    /***
     * 
     * @param ano Ano do livro.
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /***
     * 
     * @return Array List dos autores do livro.
     */
    public ArrayList<String> getAutores() {
        return autores;
    }

    /***
     * 
     * @param autores Array List dos autores do livro.
     */
    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }    
  
    
}