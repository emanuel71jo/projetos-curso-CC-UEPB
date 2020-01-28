package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Emprestimo {

	private String horaEmprestimo;
	private String dataDevolucao;
	private Usuario usuario;
	private Pessoa pessoa;
	private Quadrinho quadrinho;

    public Emprestimo(Usuario usuario, Pessoa pessoa) {
        this.usuario = usuario;
        this.pessoa = pessoa;
    }

    public Emprestimo( Usuario usuario, Pessoa pessoa, String horaEmprestimo) {
        this.horaEmprestimo = horaEmprestimo;
        this.usuario = usuario;
        this.pessoa = pessoa;
    }
	
	
	
	public Emprestimo(String dataDevolucao, String horaEmprestimo, Quadrinho quadrinho) {
		super();
		this.horaEmprestimo = horaEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.quadrinho = quadrinho;
	}


	public Emprestimo(String dataDevolucao) {
		super();
		this.dataDevolucao = dataDevolucao;
	}


	public Emprestimo(String horaEmprestimo, Quadrinho quadrinho) {
		super();
		this.horaEmprestimo = horaEmprestimo;
		this.quadrinho = quadrinho;
	}


	public Emprestimo(String horaEmprestimo, Usuario usuario) {
		super();
		this.horaEmprestimo = horaEmprestimo;
		this.usuario = usuario;
	}


	public Emprestimo(String horaEmprestimo, Pessoa pessoa) {
		super();
		this.horaEmprestimo = horaEmprestimo;
		this.pessoa = pessoa;
	}


	public Emprestimo(Usuario usuario) {
		super();
		this.usuario = usuario;
	}


	public Emprestimo(Quadrinho quadrinho) {
		super();
		this.quadrinho = quadrinho;
	}


	public Emprestimo(Pessoa pessoa) {
		super();
		this.pessoa = pessoa;
	}


	public Emprestimo(Usuario usuario, Pessoa pessoa, Quadrinho quadrinho) {
		this.usuario = usuario;
		this.pessoa = pessoa;
		this.quadrinho = quadrinho;
	}
	

	public Emprestimo() {
	}


	public Emprestimo(String horaEmprestimo, Usuario usuario, Pessoa pessoa, Quadrinho quadrinho) {
		this.horaEmprestimo = horaEmprestimo;
		this.usuario = usuario;
		this.pessoa = pessoa;
		this.quadrinho = quadrinho;
	}
		
	public Emprestimo(String horaEmprestimo, String dataDevolucao, Usuario usuario, Pessoa pessoa,
			Quadrinho quadrinho) {
		this.horaEmprestimo = horaEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.usuario = usuario;
		this.pessoa = pessoa;
		this.quadrinho = quadrinho;
	}

	public String getHoraEmprestimo() {
		return horaEmprestimo;
	}
	public void setHoraEmprestimo(String horaEmprestimo) {
		this.horaEmprestimo = horaEmprestimo;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Quadrinho getQuadrinho() {
		return quadrinho;
	}

	public void setQuadrinho(Quadrinho quadrinho) {
		this.quadrinho = quadrinho;
	}
	
	
	
}
