package model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	private String cpf;
	private String nome;
	private boolean tipoPessoa;
	private List<Emprestimo> emprestimos;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String cpf) {
		this.cpf = cpf;
	}

	public Pessoa(String cpf, String nome, boolean tipoPessoa) {
		this.cpf = cpf;
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
		this.emprestimos = new ArrayList<Emprestimo>();
	}
	
	public Pessoa(String cpf, String nome, boolean tipoPessoa, List<Emprestimo> emprestimos) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
		this.emprestimos = emprestimos;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(boolean tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	
}
