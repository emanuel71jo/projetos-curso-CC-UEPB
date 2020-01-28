package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.ColecaoDao;
import dao.QuadrinhoDao;
import java.text.ParseException;
import model.Colecao;
import model.Genero;
import model.NotaFiscal;
import model.Quadrinho;

public class QuadrinhoController {
	
	QuadrinhoDao daoQ;
	
	public QuadrinhoController() {
		this.daoQ = new QuadrinhoDao();
	}
	
	public void inserir(double valor, String capa, String autor, int qtdPaginas, String subtitulo,
			String dataCompra, String sinopse, String titulo, int colecaoId) throws ParseException {
		Quadrinho quadrinho;
                if(colecaoId != -1){
                    ColecaoDao daoC = new ColecaoDao();
                    Colecao colecao = daoC.getColecao(new Quadrinho(new Colecao(colecaoId)));
                    quadrinho = new Quadrinho(capa, autor, qtdPaginas, subtitulo, sinopse, titulo, colecao);
                }else
                    quadrinho = new Quadrinho(capa, autor, qtdPaginas, subtitulo, sinopse, titulo, new Colecao(colecaoId));
                
		NotaFiscal notaFiscal = new NotaFiscal(valor, dataCompra, quadrinho);
		quadrinho.setNotaFiscal(notaFiscal);
		
		daoQ.adiciona(quadrinho, notaFiscal);
		
	}
	
	public void remover(int id) {
		Quadrinho quadrinho = new Quadrinho(id);
		daoQ.remove(quadrinho);
	}
	
	public void alterar(double valor, String capa, String autor, int qtdPaginas, String subtitulo,
			String dataCompra, String sinopse, String titulo, int colecaoId) throws ParseException {
//		ColecaoDao daoC = new ColecaoDao();
//		Colecao colecao = daoC.getColecao(new Quadrinho(new Colecao(colecaoId)));
//		
//		Quadrinho quadrinho = new Quadrinho(capa, autor, qtdPaginas, subtitulo, sinopse, titulo, colecao);
//		NotaFiscal notaFiscal = new NotaFiscal(valor, dataCompra, quadrinho);
//		quadrinho.setNotaFiscal(notaFiscal);
//		
//		daoQ.altera(quadrinho, notaFiscal);
                Quadrinho quadrinho;
                if(colecaoId != -1){
                    ColecaoDao daoC = new ColecaoDao();
                    Colecao colecao = daoC.getColecao(new Quadrinho(new Colecao(colecaoId)));
                    quadrinho = new Quadrinho(capa, autor, qtdPaginas, subtitulo, sinopse, titulo, colecao);
                }else
                    quadrinho = new Quadrinho(capa, autor, qtdPaginas, subtitulo, sinopse, titulo, new Colecao(colecaoId));
                
		NotaFiscal notaFiscal = new NotaFiscal(valor, dataCompra, quadrinho);
		quadrinho.setNotaFiscal(notaFiscal);
		
		daoQ.altera(quadrinho, notaFiscal);
	}
	
	public List<Quadrinho> listar(){
		return daoQ.getLista();
	}
        
        public List<NotaFiscal> despesas(){
            return daoQ.getGastos();
        }

}
