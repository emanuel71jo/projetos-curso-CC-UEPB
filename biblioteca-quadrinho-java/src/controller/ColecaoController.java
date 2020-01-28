package controller;

import java.util.List;

import dao.ColecaoDao;
import model.Colecao;

public class ColecaoController {
	
	ColecaoDao daoC;
	
	public ColecaoController() {
		this.daoC = new ColecaoDao();
	}
	
	public void inserir(String nome, String editora) {
		Colecao colecao = new Colecao(nome, editora);
		daoC.adiciona(colecao);
	}
	
	public void remover(int id) {
		Colecao colecao = new Colecao(id);
		daoC.remove(colecao);
	}
	
	public void alterar(int id, String nome, String editora) {
		Colecao colecao = new Colecao(id, nome, editora);
		daoC.altera(colecao);
	}
	
	public List<Colecao> listar(){
		return daoC.getLista();
	}
	

}
