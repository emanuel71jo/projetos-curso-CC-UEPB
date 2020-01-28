package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Genero;
import model.Quadrinho;

public class GeneroQuadrinhoDao {
	
	private Connection connection;
	
	public GeneroQuadrinhoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Genero genero, Quadrinho quadrinho) {
		String sql = "insert into generoquadrinho(quadrinho_id, genero_id) values(?,?)";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, quadrinho.getId());
			stmt.setInt(2, genero.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Genero> getGeneroQuadrinho(Quadrinho quadrinho){
		
		String sql = "select g.nome, g.id from (genero g inner join generoquadrinho gq on g.id = gq.genero_id)"
				+ " inner join quadrinho q on q.id = gq.quadrinho_id where q.id=?";
		
		try {
			List<Genero> generos = new ArrayList<Genero>();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, quadrinho.getId());
			
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
	
	public void remove(Genero genero, Quadrinho quadrinho) {
		
		String sql = "remove from generoquadrinho where quadrinho_id=? and genero_id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, quadrinho.getId());
			stmt.setInt(2, genero.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}


}
