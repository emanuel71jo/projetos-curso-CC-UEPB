package controller;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import dao.EmprestimoDao;
import model.Emprestimo;
import model.Pessoa;
import model.Quadrinho;
import model.Usuario;

public class EmprestimoController {
	
	EmprestimoDao daoE;
	
	public EmprestimoController() {
		this.daoE = new EmprestimoDao();
	}
	
	public void inserir(String usuarioCpf, String pessoaCpf, int quadrinhoId) {
		
		Pessoa pessoa = new Pessoa(pessoaCpf);
		Usuario usuario = new Usuario(usuarioCpf);
		Quadrinho quadrinho = new Quadrinho(quadrinhoId);
		
		Emprestimo emprestimo = new Emprestimo(usuario, pessoa, quadrinho);
		
		daoE.adiciona(emprestimo);
	}
	
	public void remover(String horaE, int idQ) {
		Quadrinho quadrinho = new Quadrinho(idQ);
		Emprestimo emprestimo = new Emprestimo(horaE, quadrinho);
		
		daoE.remove(emprestimo);
		
	}
	
	public void alterar(String dataD, String horaE, int idQ) {
		Quadrinho quadrinho = new Quadrinho(idQ);
		Emprestimo emprestimo = new Emprestimo(dataD, horaE, quadrinho);
		daoE.altera(emprestimo);
	}

	public List<Emprestimo> listar(){
		return daoE.getLista();
	}
	
}
