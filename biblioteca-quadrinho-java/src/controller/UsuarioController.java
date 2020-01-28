package controller;

import java.util.List;

import dao.UsuarioDao;
import model.Usuario;

public class UsuarioController {
	
	UsuarioDao daoU;
	
	public UsuarioController() {
		this.daoU = new UsuarioDao();
	}
	
	public void inserir(String cpf, String nome, boolean tipoP, String login, String senha, boolean permissao) {
		Usuario usuario = new Usuario(cpf, nome, tipoP, login, senha, permissao);
		daoU.adiciona(usuario);
	}
	
	public void remover(String cpf) {
		Usuario usuario = new Usuario(cpf);
		daoU.remove(usuario);
	}
	
	public void alterar(String cpf, String nome, boolean tipoP, String login, String senha, boolean permissao) {
		Usuario usuario = new Usuario(cpf, nome, tipoP, login, senha, permissao);
		daoU.altera(usuario);
	}
	
	public List<Usuario> listar(){
		return daoU.getLista();
	}

}
