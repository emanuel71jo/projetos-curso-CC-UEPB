package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Emprestimo;
import model.Pessoa;
import model.Quadrinho;
import model.Usuario;

public class EmprestimoDao {
	
private Connection connection;
	
	public EmprestimoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Emprestimo emprestimo) {
		String sql = "insert into emprestimo(quadrinho_id, usuario_cpf, pessoa_cpf) values(?,?,?)";
		
		try {
              
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, emprestimo.getQuadrinho().getId());
			stmt.setString(2, emprestimo.getUsuario().getCpf());
			stmt.setString(3, emprestimo.getPessoa().getCpf());


			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Emprestimo> getLista(){

		try {
                        String sql = "select p.nome as Pessoa, pe.nome as Usuario, q.titulo as Quadrinho,"
                                + " e.horaEmprestimo, e.dataDevolucao, p.cpf, e.usuario_cpf, q.id "
                                + " from (emprestimo e inner join pessoa p on e.pessoa_cpf = p.cpf),"
                                + " (emprestimo em inner join usuario u on em.usuario_cpf = u.usuario_cpf)"
                                + " inner join pessoa pe on pe.cpf = u.usuario_cpf, quadrinho q"
                                + " where em.horaEmprestimo = e.horaEmprestimo and e.quadrinho_id = em.quadrinho_id"
                                + " and q.id = e.quadrinho_id";
			List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Emprestimo emprestimo = new Emprestimo();
				
				emprestimo.setHoraEmprestimo(rs.getString("horaEmprestimo"));
				emprestimo.setDataDevolucao(rs.getString("dataDevolucao"));
                                
                                Pessoa pessoa = new Pessoa();
                                pessoa.setNome(rs.getString("Pessoa"));
                                pessoa.setCpf(rs.getString("cpf"));
                                emprestimo.setPessoa(pessoa);
                                
                                Usuario usuario = new Usuario();
                                usuario.setCpf(rs.getString("usuario_cpf"));
                                usuario.setNome(rs.getString("Usuario"));
                                emprestimo.setUsuario(usuario);
                                
                                Quadrinho quadrinho = new Quadrinho();
                                quadrinho.setTitulo(rs.getString("Quadrinho"));
                                quadrinho.setId(rs.getInt("id"));
                                emprestimo.setQuadrinho(quadrinho);
                                
				emprestimos.add(emprestimo);
			}
			
			rs.close();
			stmt.close();
			return emprestimos;
		}catch (SQLException e) {
                    throw new RuntimeException(e);
                }
	}
	
	public void altera(Emprestimo emprestimo) {
		String sql = "update emprestimo set dataDevolucao=? where horaEmprestimo=? and quadrinho_id=?";
	
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, emprestimo.getDataDevolucao());
			stmt.setString(2, emprestimo.getHoraEmprestimo());
			stmt.setInt(3, emprestimo.getQuadrinho().getId());

			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void remove(Emprestimo emprestimo) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where horaEmprestimo=? and quadrinho_id=?");
			
			stmt.setString(1, emprestimo.getHoraEmprestimo());
			stmt.setInt(2, emprestimo.getQuadrinho().getId());
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	
	

}
