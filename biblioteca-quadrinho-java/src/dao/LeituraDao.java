package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Leitura;
import model.Quadrinho;
import model.Usuario;

public class LeituraDao {
	
	Connection connection;

	public LeituraDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Leitura leitura) {
		String sql = "insert into leitura(quadrinho_id, usuario_cpf) values(?,?)";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, leitura.getQuadrinho().getId());
			stmt.setString(2, leitura.getUsuario().getCpf());

			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Leitura> getLista(){
		try {
			List<Leitura> leituras = new ArrayList<Leitura>();
			PreparedStatement stmt = connection.prepareStatement("select p.nome, q.titulo, "
                                + "l.dataLeitura, l.avaliacao, l.usuario_cpf, l.quadrinho_id "
                                + "from (usuario u inner join pessoa p on u.usuario_cpf = p.cpf) "
                                + "inner join leitura l on l.usuario_cpf = u.usuario_cpf, quadrinho q "
                                + "where q.id = l.quadrinho_id");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Leitura leitura = new Leitura();
				leitura.setAvaliacao(rs.getString("avaliacao"));
				leitura.setDataLeitura(rs.getString("dataLeitura"));
				
                                Quadrinho quadrinho = new Quadrinho();
                                quadrinho.setId(rs.getInt("quadrinho_id"));
                                quadrinho.setTitulo(rs.getString("titulo"));
                                leitura.setQuadrinho(quadrinho);
                                
                                Usuario usuario = new Usuario();
                                usuario.setCpf(rs.getString("usuario_cpf"));
                                usuario.setNome(rs.getString("nome"));
                                leitura.setUsuario(usuario);
				
				leituras.add(leitura);
			}
			
			rs.close();
			stmt.close();
			return leituras;
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void altera(Leitura leitura) {
		String sql = "update leitura set avaliacao=? "
				+ "where quadrinho_id=? and usuario_cpf=? and dataLeitura=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, leitura.getAvaliacao());
			stmt.setInt(2, leitura.getQuadrinho().getId());
			stmt.setString(3, leitura.getUsuario().getCpf());
			stmt.setString(4, leitura.getDataLeitura());
			
			
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void remove(Leitura leitura) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from leitura"
					+ " where dataLeitura=? and quadrinho_id=? and usuario_cpf=?");
			
			stmt.setString(1, leitura.getDataLeitura());
			stmt.setInt(2, leitura.getQuadrinho().getId());
			stmt.setString(3, leitura.getUsuario().getCpf());
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	
	
}
