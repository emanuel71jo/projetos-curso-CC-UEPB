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
public class Leitor implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private Pacote pacote;
    ArrayList<Livros> livros;
    ArrayList<Livros> livrosLidos = new ArrayList<Livros>();
    ArrayList<Livros> livrosLendo = new ArrayList<Livros>();
    ArrayList<Livros> livrosAbandonados = new ArrayList<Livros>();
    
    private String cpf, email, nome, dataNascimento, senha;
    private int qtdLivrosLios;
    
    /***Construtor de Leitor
     * 
     * @param pacote Tipo de assinatura que o usu·rio solicitou.
     * @param cpf CPF do usu·rio.
     * @param email Email do usu·rio.
     * @param nome Nome do usu‡rio.
     * @param dataNascimento Data de Nascimento do usu·rio.
     * @param senha Senha da conta do usu·rio.
     */
	public Leitor(Pacote pacote, String cpf, String email, String nome, String dataNascimento, String senha) {
    	this.pacote = pacote;
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.qtdLivrosLios = 0;
        this.livros = new ArrayList<Livros>();
    }
	
	/***
	 * 
	 * @return Retorna a quantidade de livros lidos.
	 */
	public int getQtdLivrosLios() {
		return qtdLivrosLios;
	}
	
	/***
	 * 
	 * @param qtdLivrosLios Quantidade de livros lidos.
	 */
	public void setQtdLivrosLios(int qtdLivrosLios) {
		this.qtdLivrosLios = qtdLivrosLios;
	}
	
	/***
	 * 
	 * @return Retorna senha do perfil do usu·rio.
	 */
    public String getSenha() {
		return senha;
	}

    /***
     * 
     * @param senha Senha do perfil do usu·rio.
     */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/***
	 * 
	 * @return Pacote do conta do usu·rio.
	 */
    public Pacote getPacote() {
        return pacote;
    }

    /***
     * 
     * @param pacote Pacote da conta do usu·rio.
     */
    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    /***
     * 
     * @return Array de Livros do usu·rio.
     */
    public ArrayList<Livros> getLivros() {
        return livros;
    }

    /***
     * 
     * @param livros Livros da conta do usu·rio.
     */
    public void setLivros(Livros livros) {
        this.livros.add(livros);
    }

    /***
     * 
     * @return CPF do usu·rio.
     */
    public String getCpf() {
        return cpf;
    }

    /***
     * 
     * @param cpf CPF do usu·rio.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /***
     * 
     * @return Email do usu·rio.
     */
    public String getEmail() {
        return email;
    }

    /***
     * 
     * @param email Email do usu·rio.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /***
     * 
     * @return Nome do usu·rio.
     */
    public String getNome() {
        return nome;
    }

    /***
     * 
     * @param nome Nome do usu·rio.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /***
     * 
     * @return Data de Nascimento do usu·rio.
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /***
     * 
     * @param dataNascimento Data de Nascimento do usu·rio.
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    
}