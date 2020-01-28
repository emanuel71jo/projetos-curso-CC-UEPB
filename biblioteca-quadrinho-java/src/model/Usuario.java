package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa{
	
	private String login;
	private String senha;
	private boolean permissao;
	private List<Leitura> leituras;
	
	public Usuario() {
		
	}
	
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public Usuario(String cpf) {
		super(cpf);
	}

	public Usuario(String cpf, String nome, boolean tipoPessoa, String login, String senha, boolean permissao) {
		super(cpf, nome, tipoPessoa);
		this.login = login;
		this.senha = senha;
		this.permissao = permissao;
		this.leituras = new ArrayList<Leitura>();
	}

	public Usuario(String cpf, String nome, boolean tipoPessoa, String login, String senha, boolean permissao,
			List<Leitura> leitura) {
		super(cpf, nome, tipoPessoa);
		this.login = login;
		this.senha = senha;
		this.permissao = permissao;
		this.leituras = leitura;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isPermissao() {
		return permissao;
	}
	public void setPermissao(boolean permissao) {
		this.permissao = permissao;
	}

	public List<Leitura> getLeituras() {
		return leituras;
	}

	public void setLeituras(List<Leitura> leituras) {
		this.leituras = leituras;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	
	
}
