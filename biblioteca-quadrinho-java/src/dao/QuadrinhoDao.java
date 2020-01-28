package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Colecao;
import model.Emprestimo;
import model.Leitura;
import model.NotaFiscal;
import model.Quadrinho;

public class QuadrinhoDao {
	
        private Connection connection;
	
	public QuadrinhoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Quadrinho quadrinho, NotaFiscal notaFiscal) throws ParseException {
		String sql;
                
                if(quadrinho.getColecao().getId() != -1){
                    sql = "insert into quadrinho(valor, capa, autor, qtdPaginas, "
				+ "subtitulo, dataCompra, sinopse, titulo, colecao_id) values(?,?,?,?,?,?,?,?,?)";
                }else{
                    sql = "insert into quadrinho(valor, capa, autor, qtdPaginas, "
				+ "subtitulo, dataCompra, sinopse, titulo) values(?,?,?,?,?,?,?,?)";
                }
//		GeneroQuadrinhoDao gqdao = new GeneroQuadrinhoDao();
//		for(Genero genero: quadrinho.getGeneros())
//			gqdao.adiciona(genero, quadrinho);
		
		
		
                String data = notaFiscal.getDataCompra();
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date dataNova = new java.sql.Date(fmt.parse(data).getTime());
                
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, notaFiscal.getValor());
			stmt.setString(2, quadrinho.getUrlCapa());
			stmt.setString(3, quadrinho.getAutor());
			stmt.setInt(4, quadrinho.getQtdPaginas());
			stmt.setString(5,  quadrinho.getSubtitulo());
			stmt.setDate(6, dataNova);
			stmt.setString(7, quadrinho.getSinopse());
			stmt.setString(8, quadrinho.getTitulo());
			if(quadrinho.getColecao().getId() != -1){
//                            ColecaoDao cdao = new ColecaoDao();
//                            cdao.adiciona(quadrinho.getColecao());
                            stmt.setInt(9, quadrinho.getColecao().getId());
                        }

			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Quadrinho getQuadrinho(Leitura leitura) {
		try {
			Quadrinho quadrinho = new Quadrinho();
			PreparedStatement stmt = connection.prepareStatement("select * from quadrinho q, leitura l "
					+ "where q.id=? and l.dataLeitura=? and l.quadrinho_id=?");
			
			stmt.setInt(1, leitura.getQuadrinho().getId());
			stmt.setString(2, leitura.getDataLeitura());
			stmt.setInt(3, leitura.getQuadrinho().getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				NotaFiscal notaFiscal = new NotaFiscal();
				
//				GeneroQuadrinhoDao dao = new GeneroQuadrinhoDao();
//				quadrinho.setGeneros(dao.getGeneroQuadrinho(quadrinho));
//				
				quadrinho.setId(rs.getInt("id"));
				notaFiscal.setValor(rs.getDouble("valor"));
				quadrinho.setUrlCapa(rs.getString("capa"));
				quadrinho.setStatus(rs.getBoolean("status"));
				quadrinho.setAutor(rs.getString("autor"));
				quadrinho.setQtdPaginas(rs.getInt("qtdPaginas"));
				quadrinho.setSubtitulo(rs.getString("subtitulo"));
				notaFiscal.setDataCompra(rs.getString("dataCompra"));
				quadrinho.setSinopse(rs.getString("sinopse"));
				quadrinho.setTitulo(rs.getString("titulo"));
				
				Quadrinho aux = new Quadrinho();
				aux.setColecao(new Colecao(rs.getInt("colecao_id")));
				
				quadrinho.setNotaFiscal(notaFiscal);
				
				ColecaoDao cdao = new ColecaoDao();
				quadrinho.setColecao(cdao.getColecao(aux));

			}
			
			rs.close();
			stmt.close();
			return quadrinho;
		}catch (SQLException e) {
                    throw new RuntimeException(e);
                }
	}
	
	public Quadrinho getQuadrinho(Emprestimo emprestimo) {
		try {
			Quadrinho quadrinho = new Quadrinho();
			PreparedStatement stmt = connection.prepareStatement("select * from quadrinho q, emprestimo e "
					+ "where q.id=? and e.horaEmprestimo=? and e.quadrinho_id=?");
			
			stmt.setInt(1, emprestimo.getQuadrinho().getId());
			stmt.setString(2, emprestimo.getHoraEmprestimo());
			stmt.setInt(3, emprestimo.getQuadrinho().getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				NotaFiscal notaFiscal = new NotaFiscal();
				
//				GeneroQuadrinhoDao dao = new GeneroQuadrinhoDao();
//				quadrinho.setGeneros(dao.getGeneroQuadrinho(quadrinho));
				
				quadrinho.setId(rs.getInt("id"));
				notaFiscal.setValor(rs.getDouble("valor"));
				quadrinho.setUrlCapa(rs.getString("capa"));
				quadrinho.setStatus(rs.getBoolean("status"));
				quadrinho.setAutor(rs.getString("autor"));
				quadrinho.setQtdPaginas(rs.getInt("qtdPaginas"));
				quadrinho.setSubtitulo(rs.getString("subtitulo"));
				notaFiscal.setDataCompra(rs.getString("dataCompra"));
				quadrinho.setSinopse(rs.getString("sinopse"));
				quadrinho.setTitulo(rs.getString("titulo"));
				
				Quadrinho aux = new Quadrinho();
				aux.setColecao(new Colecao(rs.getInt("colecao_id")));
				
				quadrinho.setNotaFiscal(notaFiscal);
				
				ColecaoDao cdao = new ColecaoDao();
				quadrinho.setColecao(cdao.getColecao(aux));

			}
			
			rs.close();
			stmt.close();
			return quadrinho;
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
        
        public List<NotaFiscal> getGastos(){
            List<NotaFiscal> gastos = new ArrayList<NotaFiscal>();
            try{
                PreparedStatement stmt = connection.prepareStatement("select * from c2");
			
		ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    NotaFiscal notaFiscal = new NotaFiscal();
                    notaFiscal.setValor(rs.getDouble("VALOR"));
                    notaFiscal.setDataCompra(rs.getString("DATA"));
                    
                    gastos.add(notaFiscal);
                }
                rs.close();
		stmt.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            return gastos;
        }
	
	public List<Quadrinho> getLista(){
		
		try {
			List<Quadrinho> quadrinhos = new ArrayList<Quadrinho>();
			PreparedStatement stmt = connection.prepareStatement("select * from quadrinho");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Quadrinho quadrinho = new Quadrinho();
				NotaFiscal notaFiscal = new NotaFiscal();
				
				GeneroQuadrinhoDao dao = new GeneroQuadrinhoDao();
				quadrinho.setGeneros(dao.getGeneroQuadrinho(quadrinho));
				
				quadrinho.setId(rs.getInt("id"));
				notaFiscal.setValor(rs.getDouble("valor"));
				quadrinho.setUrlCapa(rs.getString("capa"));
				quadrinho.setStatus(rs.getBoolean("status"));
				quadrinho.setAutor(rs.getString("autor"));
				quadrinho.setQtdPaginas(rs.getInt("qtdPaginas"));
				quadrinho.setSubtitulo(rs.getString("subtitulo"));
				notaFiscal.setDataCompra(rs.getString("dataCompra"));
				quadrinho.setSinopse(rs.getString("sinopse"));
				quadrinho.setTitulo(rs.getString("titulo"));
				
				Quadrinho aux = new Quadrinho();
				aux.setColecao(new Colecao(rs.getInt("colecao_id")));
				
				quadrinho.setNotaFiscal(notaFiscal);
				
				ColecaoDao cdao = new ColecaoDao();
                                                                
				quadrinho.setColecao(cdao.getColecao(aux));
				
				quadrinhos.add(quadrinho);
			}
			
			rs.close();
			stmt.close();
			return quadrinhos;
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void altera(Quadrinho quadrinho, NotaFiscal notaFiscal) throws ParseException {
                String sql;
                if(quadrinho.getColecao().getId() != -1){
                    sql = "update quadrinho set valor=?, capa=?, autor=?, qtdPaginas=?, subtitulo=?,"
                        + " dataCompra=?, sinopse=?, titulo=?, colecao_id=? where titulo=?";
                }
                else{
                    sql = "update quadrinho set valor=?, capa=?, autor=?, qtdPaginas=?, subtitulo=?,"
                        + " dataCompra=?, sinopse=?, titulo=? where titulo=?";                  
                }
            
		
		try{
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    
                    String data = notaFiscal.getDataCompra();
                    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date dataNova = new java.sql.Date(fmt.parse(data).getTime());

                    stmt.setDouble(1, notaFiscal.getValor());
                    stmt.setString(2, quadrinho.getUrlCapa());
                    stmt.setString(3, quadrinho.getAutor());
                    stmt.setInt(4, quadrinho.getQtdPaginas());
                    stmt.setString(5,  quadrinho.getSubtitulo());
                    stmt.setDate(6, dataNova);
                    stmt.setString(7, quadrinho.getSinopse());
                    stmt.setString(8, quadrinho.getTitulo());
                    if(quadrinho.getColecao().getId() != -1){
                        stmt.setInt(9, quadrinho.getColecao().getId());
                        stmt.setString(10, quadrinho.getTitulo());
                    }else{
                        stmt.setString(9, quadrinho.getTitulo());
                    }
                    stmt.execute();
                    stmt.close();

		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void remove(Quadrinho quadrinho) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from quadrinho where id=?");
			
			stmt.setInt(1, quadrinho.getId());
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
        



}
