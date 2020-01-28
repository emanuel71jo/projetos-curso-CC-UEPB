package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Genero;

public class GeneroDao {
	
	private Connection connection;
	
	public GeneroDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Genero genero) {
		String sql = "insert into genero(nome) values(?)";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, genero.getNome());			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Genero> getLista(){
		
		try {
			List<Genero> generos = new ArrayList<Genero>();
			PreparedStatement stmt = connection.prepareStatement("select * from genero");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Genero genero = new Genero();
				genero.setId(rs.getInt("id"));
				genero.setNome(rs.getString("nome"));
				
				generos.add(genero);
			}
			
			rs.close();
			stmt.close();
			return generos;
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void altera(Genero genero) {
		String sql = "update genero set nome=? where id=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, genero.getNome());
			stmt.setInt(2, genero.getId());
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void remove(Genero genero) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from genero where id=?");
			
			stmt.setInt(1, genero.getId());
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

}
