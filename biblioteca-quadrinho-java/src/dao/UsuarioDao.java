package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Emprestimo;
import model.Leitura;
import model.Pessoa;
import model.Usuario;

public class UsuarioDao {
	
	private Connection connection;
	
	public UsuarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Usuario usuario) {
		String sql = "insert into usuario(usuario_cpf, login, senha, permissao) values(?,?,?,?)";
		PessoaDao dao = new PessoaDao();
		dao.adiciona(new Pessoa(usuario.getCpf(), usuario.getNome(), usuario.isTipoPessoa()));
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getCpf());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			stmt.setBoolean(4, usuario.isPermissao());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario getUsuario(Emprestimo emprestimo) {
		try {

			Usuario usuario = new Usuario();
			PreparedStatement stmt = connection.prepareStatement("select * from usuario u, pessoa p, emprestimo e"
					+ " where p.cpf=? and e.horaEmprestimo=? and e.usuario_cpf=?");
			stmt.setString(1, emprestimo.getPessoa().getCpf());
			stmt.setString(2, emprestimo.getHoraEmprestimo());
			stmt.setString(3, emprestimo.getUsuario().getCpf());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				usuario.setCpf(rs.getString("cpf"));
				usuario.setNome(rs.getString("nome"));
				usuario.setTipoPessoa(rs.getBoolean("tipoPessoa"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPermissao(rs.getBoolean("permissao"));
			}
			
			rs.close();
			stmt.close();
			return usuario;
		}catch (SQLException e) {
                    throw new RuntimeException(e);
                }
	}
	
	public Usuario getUsuario(Leitura leitura) {
		try {

			Usuario usuario = new Usuario();
			PreparedStatement stmt = connection.prepareStatement("select * from usuario u, pessoa p, leitura l "
					+ " where u.usuario_cpf=? and l.dataLeitura=? and p.cpf=?");
			stmt.setString(1, leitura.getUsuario().getCpf());
			stmt.setString(2, leitura.getDataLeitura());
			stmt.setString(3, leitura.getUsuario().getCpf());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				usuario.setCpf(rs.getString("cpf"));
				usuario.setNome(rs.getString("nome"));
				usuario.setTipoPessoa(rs.getBoolean("tipoPessoa"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPermissao(rs.getBoolean("permissao"));
			}
			
			rs.close();
			stmt.close();
			return usuario;
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public List<Usuario> getLista(){
		
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = connection.prepareStatement("select * from usuario u inner join pessoa p on u.usuario_cpf = p.cpf");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setCpf(rs.getString("cpf"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPermissao(rs.getBoolean("permissao"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTipoPessoa(rs.getBoolean("tipoPessoa"));
				
				usuarios.add(usuario);
			}
			
			rs.close();
			stmt.close();
			return usuarios;
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void altera(Usuario usuario) {
		String sql = "update usuario set login=?, senha=?, permissao=? where usuario_cpf=?";
		PessoaDao dao = new PessoaDao();
		dao.altera(new Pessoa(usuario.getCpf(), usuario.getNome(), usuario.isTipoPessoa()));
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setBoolean(3, usuario.isPermissao());
			stmt.setString(4, usuario.getCpf());

			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void remove(Usuario usuario) {
		
		PessoaDao dao = new PessoaDao();
		dao.remove(new Pessoa(usuario.getCpf(), usuario.getNome(), usuario.isTipoPessoa()));
		
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from usuario where usuario_cpf=?");
			
			stmt.setString(1, usuario.getCpf());
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}


}
