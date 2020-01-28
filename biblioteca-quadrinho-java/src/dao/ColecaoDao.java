package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Colecao;
import model.Quadrinho;

public class ColecaoDao {
	
	private Connection connection;
	
	public ColecaoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Colecao colecao) {
		String sql = "insert into colecao(nome, editora) values(?,?)";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, colecao.getNome());
			stmt.setString(2, colecao.getEditora());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Colecao getColecao(Quadrinho quadrinho) {
		try {
			Colecao colecao = new Colecao();
			PreparedStatement stmt = connection.prepareStatement("select * from colecao c where c.id=?");
			stmt.setInt(1, quadrinho.getColecao().getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				colecao.setId(rs.getInt("id"));
				colecao.setEditora(rs.getString("editora"));
				colecao.setNome(rs.getString("nome"));				
			}
			
			rs.close();
			stmt.close();
			return colecao;
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public List<Colecao> getLista(){
		
		try {
			List<Colecao> colecoes = new ArrayList<Colecao>();
			PreparedStatement stmt = connection.prepareStatement("select * from colecao");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Colecao colecao = new Colecao();
				colecao.setId(rs.getInt("id"));
				colecao.setNome(rs.getString("nome"));
				colecao.setEditora(rs.getString("editora"));
				
				colecoes.add(colecao);
			}
			
			rs.close();
			stmt.close();
			return colecoes;
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void altera(Colecao colecao) {
		String sql = "update colecao set nome=?, editora=? where id=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, colecao.getNome());
			stmt.setString(2, colecao.getEditora());
			stmt.setInt(3, colecao.getId());
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void remove(Colecao colecao) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from colecao where id=?");
			
			stmt.setInt(1, colecao.getId());
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

}
