/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import model.Colecao;
import model.Emprestimo;
import model.Genero;
import model.Leitura;
import model.NotaFiscal;
import model.Quadrinho;
import model.Usuario;

/**
 *
 * @author joaoe
 */
public class ControleFuncoes implements UsuarioFuncaoIF{
    
        private static ControleFuncoes INSTANCE;
        
	private Usuario usuario;
	LeituraController leituraController;
	QuadrinhoController quadrinhoController;
	ColecaoController colecaoController;
	UsuarioController usuarioController;
	GeneroController generoController;
	EmprestimoController emprestimoController;
	
	private ControleFuncoes() {
            this.leituraController = new LeituraController();
            this.quadrinhoController = new QuadrinhoController();
            this.colecaoController = new ColecaoController();
            this.usuarioController = new UsuarioController();
            this.generoController = new GeneroController();
            this.emprestimoController = new EmprestimoController();
	}
        
        public static ControleFuncoes getInstance(){
            if(INSTANCE == null) {
                synchronized (ControleFuncoes.class) {
                    if(INSTANCE == null)
                        INSTANCE = new ControleFuncoes();
                }
            }
            return INSTANCE;
        }
        
        public Usuario getUsuario() {
            return usuario;
        }
        
        public void setUsuario(Usuario usu){
            this.usuario = usu;
        }
	
	@Override
	public void iniciarLeitura(int idQuadrinho){
            this.leituraController.inserir(idQuadrinho, this.usuario.getCpf());
	}

	@Override
	public void encerrarLeitura(String avaliacao, String dataL, int idQuadrinho) {
            this.leituraController.alterar(avaliacao, dataL, this.usuario.getCpf(), idQuadrinho);
	}

	@Override
	public void cancelarLeitura(String dataL, int idQuadrinho) {
            this.leituraController.remover(dataL, this.usuario.getCpf(), idQuadrinho);
	}

	@Override
	public List<Leitura> listarLeitura() {
            return this.leituraController.listar();
	}

	@Override
	public void inserirQuadrinho(double valor, String capa, String autor, int qtdPaginas, String subtitulo,
			String dataCompra, String sinopse, String titulo, int colecaoId) throws ParseException {
            this.quadrinhoController.inserir(valor, capa, autor, qtdPaginas, subtitulo, dataCompra, sinopse, titulo, colecaoId);	
	}

	@Override
	public void removerQuadrinho(int id) {
            this.quadrinhoController.remover(id);
	}

	@Override
	public void alterarQuadrinho(double valor, String capa, String autor, int qtdPaginas, String subtitulo, String dataCompra,
			String sinopse, String titulo, int colecaoId) throws ParseException {
            this.quadrinhoController.alterar(valor, capa, autor, qtdPaginas, subtitulo, dataCompra, sinopse, titulo, colecaoId);
	}

	@Override
	public List<Quadrinho> listarQuadrinho() {
            return this.quadrinhoController.listar();
	}

	@Override
	public void inserirColecao(String nome, String editora) {
            this.colecaoController.inserir(nome, editora);
	}

	@Override
	public void removerColecao(int id) {
            this.colecaoController.remover(id);
	}

	@Override
	public void alterarColecao(int id, String nome, String editora) {
            this.colecaoController.alterar(id, nome, editora);
	}

	@Override
	public List<Colecao> listarColecao() {
            return this.colecaoController.listar();
	}

	@Override
	public List<NotaFiscal> gastoMensal() {
            return this.quadrinhoController.despesas();
	}

	@Override
	public void cadastrarUsuario(String cpf, String nome, boolean tipoP, String login, String senha,
			boolean permissao) {
            this.usuarioController.inserir(cpf, nome, tipoP, login, senha, permissao);
	}

	@Override
	public void removerUsuario(String cpf) {
            this.usuarioController.remover(cpf);
	}

	@Override
	public void alterarUsuario(String cpf, String nome, boolean tipoP, String login, String senha, boolean permissao) {
            this.usuarioController.alterar(cpf, nome, tipoP, login, senha, permissao);
	}

	@Override
	public List<Usuario> listarUsuario() {
            return this.usuarioController.listar();
	}

	@Override
	public void realizarEmprestimo(String usuarioCpf, String pessoaCpf, int quadrinhoId) {
            this.emprestimoController.inserir(usuarioCpf, pessoaCpf, quadrinhoId);
	}

	@Override
	public void informaDevolucaoEmprestimo(String horaE, int idQ) {
            this.emprestimoController.alterar(new java.sql.Date(
	            Calendar.getInstance().getTimeInMillis()).toString(), horaE, idQ);
	}

	@Override
	public void cancelaEmprestimo(String horaE, int idQ) {
            this.emprestimoController.remover(horaE, idQ);
	}

	@Override
	public List<Emprestimo> listarEmprestimo() {
            return this.emprestimoController.listar();
	}

	@Override
	public void inserirGenero(String nome) {
            this.generoController.inserir(nome);
	}

	@Override
	public void removerGenero(int id) {
            this.generoController.remover(id);
	}

	@Override
	public void alterarGenero(String nome, int id) {
            this.generoController.alterar(nome, id);
	}

	@Override
	public List<Genero> listarGenero() {
            return this.generoController.listar();
	}
}
