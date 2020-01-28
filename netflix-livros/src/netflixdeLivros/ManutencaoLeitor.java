package netflixdeLivros;

import java.util.ArrayList;

/**
 * 
 * @author Dijay, JoÃ£o e Pedro.
 */
public class ManutencaoLeitor {

	/***Cria um novo leitor e adiciona ele em um ArrayList.
	 * 
	 * @param leitor Leitor contendo todo o conteúdo que será inserido no Array leitores.
	 * @param leitores Array List que contem todos os leitores cadastrados.
	 * @return Retorna true se o cadastro for relaizado de maneira correta, ou 
	 * 		   retorna false se o cadastro nao for realizado. 
	 */
	public boolean create(Leitor leitor, ArrayList<Leitor> leitores) {
		if (leitor != null) {
			leitores.add(leitor);
			return true; 
		}
		return false;
	}
	
	/***Exibe os dados de todos os leitores contidos no ArrayList, ou seja, criados.
	 * 
	 * @param leitores Array List contendo todos os leitores cadastrados.
	 * @return True se a listagem for realizada de maneira correta.
	 */
	public boolean read(ArrayList<Leitor> leitores) {
		int i = 1;
		for (Leitor l : leitores) {
			EntradaSaidaDados.printLeitor(l, i);
			i++;
		}

		return true;
	}

	/***Atualiza Nome.
	 * 
	 * @param cpf CPF do leitor que deseja atualizar cadastro.
	 * @param nome Novo nome que será inserido para que seja realizada a atualizacao de cadastro.
	 * @param leitores Array List contendo todos os leitores cadastrados.
	 * @return Retorna true se a atualizacao for relaizada de maneira correta, ou 
	 * 		   retorna false se a atualizacao nao for realizada. 
	 */
	public boolean updateLeitorNome(String cpf, String nome, ArrayList<Leitor> leitores) {

		for (Leitor l : leitores) {
			if (l.getCpf().equals(cpf)) {
				l.setNome(nome);
				// gal.Gravar_Array(leitores);
				return true;
			}
		}
		return false;
	}

	/***Atualiza email.
	 * 
	 * @param cpf CPF do leitor que deseja atualizar cadastro.
	 * @param email Novo email que será inserido para que seja realizada a atualizacao de cadastro.
	 * @param leitores Array List contendo todos os leitores cadastrados.
	 * @return Retorna true se a atualizacao for relaizada de maneira correta, ou 
	 * 		   retorna false se a atualizacao nao for realizada. 
	 */
	public boolean updateLeitorEmail(String cpf, String email,
			ArrayList<Leitor> leitores) {

		for (Leitor l : leitores) {
			if (l.getCpf().equals(cpf)) {
				l.setEmail(email);
				// gal.Gravar_Array(leitores);
				return true;
			}
		}
		return false;
	}

	/***Atualiza CPF.
	 * 
	 * @param cpf CPF do leitor que deseja atualizar cadastro.
	 * @param newcpf Novo CPF que será inserido para que seja realizada a atualizacao de cadastro.
	 * @param leitores Array List contendo todos os leitores cadastrados.
	 * @return Retorna true se a atualizacao for relaizada de maneira correta, ou 
	 * 		   retorna false se a atualizacao nao for realizada. 
	 */
	public boolean updateLeitorCPF(String cpf, String newcpf,
			ArrayList<Leitor> leitores) {

		for (Leitor l : leitores) {
			if (l.getCpf().equals(cpf)) {
				l.setCpf(newcpf);
				// gal.Gravar_Array(leitores);
				return true;
			}
		}
		return false;
	}

	/***Atualiza Data de nascimento.
	 * 
	 * @param cpf CPF do leitor que deseja atualizar cadastro.
	 * @param dn Nova Data de nascimento que será inserido para que seja realizada a atualizacao de cadastro.
	 * @param leitores Array List contendo todos os leitores cadastrados.
	 * @return Retorna true se a atualizacao for relaizada de maneira correta, ou 
	 * 		   retorna false se a atualizacao nao for realizada. 
	 */
	public boolean updateLeitorDataNascimento(String cpf, String dn,
			ArrayList<Leitor> leitores) {

		for (Leitor l : leitores) {
			if (l.getCpf().equals(cpf)) {
				l.setDataNascimento(dn);
				// gal.Gravar_Array(leitores);
				return true;
			}
		}
		return false;
	}


	/***Remove um leitor do sistema, ou seja, do ArrayList. 
	 * 
	 * @param cod Codigo do leitor que se deseja remover da lista de cadastrados.
	 * @param leitores Array List contendo todos os leitores cadastrados.
	 * @return Retorna true se a remocao do leitor for relaizada de maneira correta, ou 
	 * 		   retorna false se a remocao nao for realizada.
	 */
	public boolean delete(String cod, ArrayList<Leitor> leitores) {

		for (Leitor l : leitores) {
			if (l.getCpf().equals(cod)) {
				leitores.remove(l);
				// gal.Gravar_Array(leitores);
				return true;
			}
		}

		return false;
	}

	/***Adiciona um livro a um leitor que e passado por parâmetro.
	 * 
	 * @param isbn Codigo do livro que deseja adicionar a lista de livros do leitor.
	 * @param leitor Leitor na qual está sendo adicionado um novo livro a sua lista.
	 * @param leitores Array List contendo todos os leitores cadastrados.
	 * @param listBookr Array List contendo todos os livros cadastrados.
	 * @return Retorna true se o livro for adicionado a lista de livros do leitor for relaizado de maneira correta, ou 
	 * 		   retorna false se nao for adicionado.
	 */
	public boolean addBookLeitor(String isbn, Leitor leitor,
			ArrayList<Leitor> leitores, ArrayList<Livros> listBook) {
		ManutencaoLivros ml = new ManutencaoLivros();
		leitor.livros.add(ml.seachBook(isbn, listBook));
		// gal.Gravar_Array(leitores);
		return true;
	}

	/***Verifica a existencia de um leitor.
	 * 
	 * @param cpf CPF do leitor na qual deseja saber se ele está cadastrado ou nao.
	 * @param leitores Array List contendo todos os leitores cadastrados.
	 * @return Retorna true se o leitor estiver cadastrado, ou
	 * 		   retorna false se o leitor nao estiver cadastrado.
	 */
	public boolean findLeitor(String cpf, ArrayList<Leitor> leitores) {
		for (Leitor l : leitores) {
			if (l.getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	/***Verifica a senha do usuário para que ele possa acessar seu perfil.
	 * 
	 * @param senha Senha recebida pelo usuário para entrar no perfil.
	 * @param leitores Array List contendo todos os leitores cadastrados. 
	 * @param cpf CPF do usuario que fara o login.
	 * @return Retorna true se a senha for identica a senha passada, ou 
	 * 		   retorna false se nao existir senha igual.
	 */
	public boolean findLeitorSenha(String senha, ArrayList<Leitor> leitores, String cpf) {
		for (Leitor l : leitores) {
			if (l.getSenha().equals(senha) && l.getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	/***Verifica se um leitor exite e ele é retornado.
	 * 
	 * @param cpf CPF do leitor que sera retornado.
	 * @param leitores Array List contendo todos os leitores cadastrados.
	 * @return Retorna o leitor se ele estiver na lista de cadastrados, ou
	 * 	       retorna null se o leitor nao estiver cadastrado. 
	 */
	public Leitor findOneLeitor(String cpf, ArrayList<Leitor> leitores) {
		for (Leitor l : leitores) {
			if (l.getCpf().equals(cpf)) {
				return l;
			}
		}
		return null;
	}
	
	/***
	 * 
	 * @param leitores ArrayList de leitores.
	 * @param cpf CPF que deseja ser encontrado.
	 * @return Retorna true se o leitor for encontrado a senha passada, ou 
	 * 		   retorna false se o leitor nao existir.
	 */
	public boolean findLeitorSenha(ArrayList<Leitor> leitores, String cpf) {
		for (Leitor l : leitores) {
			if (l.getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

}