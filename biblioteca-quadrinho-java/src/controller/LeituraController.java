package controller;

import java.sql.Timestamp;
import java.util.List;

import dao.LeituraDao;
import model.Leitura;
import model.Quadrinho;
import model.Usuario;

public class LeituraController {
	
	LeituraDao daoL;
	
	public LeituraController() {
		this.daoL = new LeituraDao();
	}
	
	public void inserir(int idQ, String cpfU) {
		Usuario usuario = new Usuario();
                usuario.setCpf(cpfU);
		Quadrinho quadrinho = new Quadrinho();
                quadrinho.setId(idQ);
		Leitura leitura = new Leitura(usuario, quadrinho);
		
		daoL.adiciona(leitura);
		
	}
	
	public void remover(String dataL, String cpfU, int idQ) {
		Usuario usuario = new Usuario();
                usuario.setCpf(cpfU);
		Quadrinho quadrinho = new Quadrinho();
                quadrinho.setId(idQ);
		Leitura leitura = new Leitura(dataL, usuario, quadrinho);
		
		daoL.remove(leitura);
	}
	
	public void alterar(String avaliacao, String dataL, String cpfU, int idQ) {
		Usuario usuario = new Usuario();
                usuario.setCpf(cpfU);
		Quadrinho quadrinho = new Quadrinho();
                quadrinho.setId(idQ);
		Leitura leitura = new Leitura(dataL, avaliacao, usuario, quadrinho);
		
		daoL.altera(leitura);
	}
	
	public List<Leitura> listar(){
		return daoL.getLista();
	}

}
