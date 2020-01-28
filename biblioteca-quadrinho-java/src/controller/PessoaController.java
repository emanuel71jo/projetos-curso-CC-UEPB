package controller;

import java.util.List;

import dao.PessoaDao;
import model.Pessoa;

public class PessoaController {
	
	PessoaDao daoP;
	
	public PessoaController() {
		this.daoP = new PessoaDao();
	}
	
	public void inserir(String cpf, String nome, boolean tipoP) {
		Pessoa pessoa = new Pessoa(cpf, nome, tipoP);
		daoP.adiciona(pessoa);
	}
	
	public void remover(String cpf) {
		Pessoa pessoa = new Pessoa(cpf);
		daoP.remove(pessoa);
	}
	
	public void alterar(String cpf, String nome, boolean tipoP) {
		Pessoa pessoa = new Pessoa(cpf, nome, tipoP);
		daoP.altera(pessoa);
	}
	
	public List<Pessoa> listar(){
		return daoP.getLista();
	}

}
