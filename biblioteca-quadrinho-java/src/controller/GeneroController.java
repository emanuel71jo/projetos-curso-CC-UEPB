package controller;

import java.util.List;

import dao.GeneroDao;
import model.Genero;

public class GeneroController {
	
	GeneroDao daoG;
	
	public GeneroController() {
		this.daoG = new GeneroDao();
	}
	
	public void inserir(String nome) {
		Genero genero = new Genero(nome);
		daoG.adiciona(genero);
	}
	
	public void remover(int id) {
		Genero genero = new Genero(id);
		daoG.remove(genero);
	}
	
	public List<Genero> listar(){
		return daoG.getLista();
	}
	
	public void alterar(String nome, int id) {
		Genero genero = new Genero(id, nome);
		daoG.altera(genero);
	}
	
}
