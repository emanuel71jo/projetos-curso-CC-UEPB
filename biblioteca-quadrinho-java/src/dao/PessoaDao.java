package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Emprestimo;
import model.Pessoa;

public class PessoaDao {
	
	private Connection connection;
	
	public PessoaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Pessoa pessoa) {
		String sql = "insert into pessoa(cpf, nome, tipoPessoa) values(?,?,?)";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, pessoa.getCpf());
			stmt.setString(2, pessoa.getNome());
			stmt.setBoolean(3, pessoa.isTipoPessoa());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Pessoa getPessoa(Emprestimo emprestimo) {
		try {
			Pessoa pessoa = new Pessoa();
			PreparedStatement stmt = connection.prepareStatement("select * from pessoa, emprestimo"
					+ " where cpf=? and horaEmprestimo=?");
			stmt.setString(1, emprestimo.getPessoa().getCpf());
			stmt.setString(2, emprestimo.getHoraEmprestimo());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setTipoPessoa(rs.getBoolean("tipoPessoa"));
			}
			
			rs.close();
			stmt.close();
			return pessoa;
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public List<Pessoa> getLista(){
		
		try {
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			PreparedStatement stmt = connection.prepareStatement("select * from pessoa where tipoPessoa is false");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setTipoPessoa(rs.getBoolean("tipoPessoa"));
				
				pessoas.add(pessoa);
			}
			
			rs.close();
			stmt.close();
			return pessoas;
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void altera(Pessoa pessoa) {
		String sql = "update pessoa set nome=?, tipoPessoa=? where cpf=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, pessoa.getNome());
			stmt.setBoolean(2, pessoa.isTipoPessoa());
			stmt.setString(3, pessoa.getCpf());
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void remove(Pessoa pessoa) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from pessoa where cpf=?");
			
			stmt.setString(1, pessoa.getCpf());
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	

}
