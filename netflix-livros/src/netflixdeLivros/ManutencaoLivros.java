/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixdeLivros;

import java.util.ArrayList;

/**
 * 
 * @author Dijay, JoÃ£o e Pedro.
 */
public class ManutencaoLivros {
	
	/***METODO CREATE
	 * 
	 * Cria um novo Objeto do tipo livro.
	 * 
	 * @param l Recebe um livro que será inserido criado sendo inserido na lista de Livros.
	 * @return TRUE: Se livro for inserido corretamente.
	 * 		   FALSE: Caso o livro não seja inserido.
	 */
	public boolean create(Livros l, ArrayList<Livros> listBook) {
		if (l != null){
			listBook.add(l);
			return true;
		}
		return false;
	}
	
	/***METODO READ
	 * 
	 * Exibicao da dos dados cadastrados.
	 * 
	 * @param livros Recebe uma lista de livros.
	 *
	 * @return TRUE: Se os livros forem listados corretamente.
	 */
	public boolean read(ArrayList<Livros> listBook) {
		int i = 1;
		for (Livros l : listBook) {
			EntradaSaidaDados.printLivro(l,i);
			i++;
		}

		return true;
	}
	
	/***METODO UPDATE IDIOMA
	 * 
	 * Atualiza o atributo Idioma.
	 * 
	 * @param cod Codigo do livro que deseja alterar o idioma.
	 * @param id O novo idioma a ser inserido.
	 * @return TRUE: Se atualizacao for realizada corretamente.
	 * 		   FALSE: Caso o livro não seja atualizado.
	 */
	public boolean updateLivroIdioma(String cod, String id, ArrayList<Livros> listBook) {
		for (Livros l : listBook) {
			if (l.getISBN().equals(cod)) {
				l.setIdioma(id);
				//gal.Gravar_Array(listBook);
				return true;
			}
		}
		return false;
	}
	
	/***METODO UPDATE ASSUNTO
	 * 
	 * Atualiza o atributo Assunto.
	 * 
	 * @param cod Codigo do livro que deseja alterar o assunto.
	 * @param as Novo assunto do livro.
	 * @return TRUE: Se atualizacao for realizada corretamente.
	 * 		   FALSE: Caso o livro não seja atualizado.
	 */
	public boolean updateLivroAssunto(String cod, String as, ArrayList<Livros> listBook) {
		for (Livros l : listBook) {
			if (l.getISBN().equals(cod)) {
				l.setAssunto(as);
				//gal.Gravar_Array(listBook);
				return true;
			}
		}
		return false;
	}

	/***METODO UPDATE DESCRICAO
	 * 
	 * Atualiza o atributo Descricao.
	 * 
	 * @param cod Codigo do livro que deseja alterar o descricao.
	 * @param des Nova descricao do livro.
	 * @return TRUE: Se atualizacao for realizada corretamente.
	 * 		   FALSE: Caso o livro não seja atualizado.
	 */
	public boolean updateLivroDescricao(String cod, String des, ArrayList<Livros> listBook) {
		for (Livros l : listBook) {
			if (l.getISBN().equals(cod)) {
				l.setDescricao(des);
				//gal.Gravar_Array(listBook);
				return true;
			}
		}
		return false;
	}

	/***METODO UPDATE EDICAO
	 * 
	 * Atualiza o atributo Edicao.
	 * 
	 * @param cod Codigo do livro que deseja alterar o edicao.
	 * @param ed Nova edicao do livro.
	 * @return TRUE: Se atualizacao for realizada corretamente.
	 * 		   FALSE: Caso o livro não seja atualizado.
	 */
	public boolean updateLivroEdicao(String cod, String ed, ArrayList<Livros> listBook) {
		for (Livros l : listBook) {
			if (l.getISBN().equals(cod)) {
				l.setEdicao(ed);
				//gal.Gravar_Array(listBook);
				return true;
			}
		}
		return false;
	}

	/***METODO UPDATE TITULO
	 * 
	 * Atualiza o atributo Titulo.
	 * 
	 * @param cod Codigo do livro que deseja alterar o titulo.
	 * @param titulo Novo titulo do livro.
	 * @return TRUE: Se atualizacao for realizada corretamente.
	 * 		   FALSE: Caso o livro não seja atualizado.
	 */
	public boolean updateLivroTitulo(String cod, String titulo, ArrayList<Livros> listBook) {
		for (Livros l : listBook) {
			if (l.getISBN().equals(cod)) {
				l.setTitulo(titulo);
				//gal.Gravar_Array(listBook);
				return true;
			}
		}
		return false;
	}

	/***METODO UPDATE EDITORA
	 * 
	 * Atualiza o atributo Editora.
	 * 
	 * @param cod Codigo do livro que deseja alterar o editora.
	 * @param ed Nova editora do livro.
	 * @return TRUE: Se atualizacao for realizada corretamente.
	 * 		   FALSE: Caso o livro não seja atualizado.
	 */
	public boolean updateLivroEditora(String cod, String ed, ArrayList<Livros> listBook) {
		for (Livros l : listBook) {
			if (l.getISBN().equals(cod)) {
				l.setEditora(ed);
				//gal.Gravar_Array(listBook);
				return true;
			}
		}
		return false;
	}

	/***METODO UPDATE CODIGO
	 * 
	 * Atualiza o atributo ISBN.
	 * 
	 * @param cod Codigo do livro que deseja alterar o Codigo.
	 * @param isbn Novo codigo do livro.
	 * @return TRUE: Se atualizacao for realizada corretamente.
	 * 		   FALSE: Caso o livro não seja atualizado.
	 */
	public boolean updateLivroCodigo(String cod, String isbn, ArrayList<Livros> listBook) {
		for (Livros l : listBook) {
			if (l.getISBN().equals(cod)) {
				l.setISBN(isbn);
				//gal.Gravar_Array(listBook);
				return true;
			}
		}
		return false;
	}

	/***METODO UPDATE ANO
	 * 
	 * Atualiza o atributo Ano.
	 * 
	 * @param cod Codigo do livro que deseja alterar o ano.
	 * @param ano Novo ano do livro.
	 * @return TRUE: Se atualizacao for realizada corretamente.
	 * 		   FALSE: Caso o livro não seja atualizado.
	 */
	public boolean updateLivroAno(String cod, int ano, ArrayList<Livros> listBook) {
		for (Livros l : listBook) {
			if (l.getISBN().equals(cod)) {
				l.setAno(ano);
				//gal.Gravar_Array(listBook);
				return true;
			}
		}
		return false;
	}

	public boolean update() {
		return true;
	}

	/***METODO DELETE
	 * 
	 * Remove um livro do ArrayList.
	 * 
	 * @param cod Codigo do livro que deseja remover.
	 * @return TRUE: Se o livro for removido corretamente.
	 * 		   FALSE: Caso o livro não seja removido.
	 */
	public boolean delete(String cod, ArrayList<Livros> listBook) {
		for (Livros l : listBook) {
			if (l.getISBN().equals(cod)) {
				listBook.remove(l);
				//gal.Gravar_Array(listBook);
				return true;
			}
		}

		return false;
	}
		
	/*** SEACH BOOK
	 * 
	 * Procura por um livro.
	 * 
	 * @param isbn Código do livro que deseja encontrar.
	 * @param livros Array List de livros na qual será feita a busca.
	 * @return Retorna o livro que será encontrado a partir do código passado.
	 */
	public Livros seachBook(String isbn, ArrayList<Livros> livros){
		for (Livros l : livros) {
			if (l.getISBN().equals(isbn)) {
				EntradaSaidaDados.printLivro(l, 1);
				return l;
			}
		} 
		return null;
	}
	
	/***SEACH BOOK
	 * 
	 * Procura por um livro.
	 * 
	 * @param isbn Código do livro que deseja encontrar.
	 * @param livros Array List de livros na qual será feita a busca.
	 * @return Retorna o livro que será encontrado a partir do código passado.
	 *
	 */
	public boolean seachBook(String isbn, ArrayList<Livros> livros, int i){
		for (Livros l : livros) {
			if (l.getISBN().equals(isbn)) {
				return true;
			}
		} 
		return false;
	}
	
}