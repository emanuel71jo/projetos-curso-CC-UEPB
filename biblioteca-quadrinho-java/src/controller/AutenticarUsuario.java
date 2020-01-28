package controller;

import java.util.List;

import dao.UsuarioDao;
import model.Usuario;

public class AutenticarUsuario {
	
	private Usuario usuario;
	
	public Usuario autenticar(String login, String senha) throws Exception {
		UsuarioDao daoU = new UsuarioDao();
		List<Usuario> usuarios = daoU.getLista();
		Usuario aux = new Usuario(login, senha);
		
		boolean flag = false;
		for(Usuario u: usuarios) {
			if(u.equals(aux)) {
				this.usuario = u;
				flag = true;
				break;
			}
		}
		if(!flag)
			throw new Exception("FALHA NA AUTENTICACAO");
		
		return this.usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
