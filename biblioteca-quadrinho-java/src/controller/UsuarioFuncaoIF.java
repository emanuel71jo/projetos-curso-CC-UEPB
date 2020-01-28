package controller;

import java.text.ParseException;
import java.util.List;

import model.Colecao;
import model.Emprestimo;
import model.Genero;
import model.Leitura;
import model.NotaFiscal;
import model.Quadrinho;
import model.Usuario;

public interface UsuarioFuncaoIF {

	public void iniciarLeitura(int idQuadrinho);
	public void encerrarLeitura(String avaliacao, String dataL, int idQuadrinho);
	public void cancelarLeitura(String dataL, int idQuadrinho);
	public List<Leitura> listarLeitura();
	public void inserirQuadrinho(double valor, String capa, String autor, int qtdPaginas, String subtitulo,
			String dataCompra, String sinopse, String titulo, int colecaoId) throws ParseException ;
	public void removerQuadrinho(int id);
	public void alterarQuadrinho(double valor, String capa, String autor, int qtdPaginas, String subtitulo,
			String dataCompra, String sinopse, String titulo, int colecaoId) throws ParseException ; 
	public List<Quadrinho> listarQuadrinho();
	public void inserirColecao(String nome, String editora);
	public void removerColecao(int id);
	public void alterarColecao(int id, String nome, String editora);
	public List<Colecao> listarColecao();
	public List<NotaFiscal> gastoMensal();
	public void cadastrarUsuario(String cpf, String nome, boolean tipoP, String login, String senha, boolean permissao);
	public void removerUsuario(String cpf);
	public void alterarUsuario(String cpf, String nome, boolean tipoP, String login, String senha, boolean permissao);
	public List<Usuario> listarUsuario();
	public void realizarEmprestimo(String usuarioCpf, String pessoaCpf, int quadrinhoId);
	public void informaDevolucaoEmprestimo(String horaE, int idQ);
	public void cancelaEmprestimo(String horaE, int idQ);
	public List<Emprestimo> listarEmprestimo();
	public void inserirGenero(String nome);
	public void removerGenero(int id);
	public void alterarGenero(String nome, int id);
	public List<Genero> listarGenero();
	
	
}
