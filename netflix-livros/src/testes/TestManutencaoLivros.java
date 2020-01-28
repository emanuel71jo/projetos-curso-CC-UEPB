package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import netflixdeLivros.Livros;
import netflixdeLivros.ManutencaoLivros;
import netflixdeLivros.Pacote;
import netflixdeLivros.PacoteBasic;

public class TestManutencaoLivros {
	ManutencaoLivros ml = new ManutencaoLivros();
	
	/**
	 * Testando o método create();
	 */
	@Test
	public void testCreate() {
		
		/**
		 * Test add um livro ao arraylist
		 */
		Pacote pb = new PacoteBasic(50);
		ArrayList<Livros> livros = new ArrayList<>();
		ArrayList<String> autores = new ArrayList<>();
		ArrayList<String> comentario = new ArrayList<>();
		ArrayList<String> justificativa = new ArrayList<>();
		autores.add("0");
		comentario.add("0");
		justificativa.add("0");
		Livros livro = new Livros(autores, comentario, justificativa, "00", "00", "00", "00", "00", "0", "0", 1);
		
		livros.add(livro);
		
		
		Assert.assertTrue(ml.create(livro, livros));
		
		/**
		 * Test de add um livro=null ao arraylist
		 */
		Livros l = null;
		livros.add(l);
		Assert.assertFalse(ml.create(l, livros));		
	}
	
	/**
	 * Testando o método upLivroIdioma();
	 */
	@Test
	public void testUpdateLeitorNome(){
		/**
		 * Testando se foi atualizado correto 
		 */
		Pacote pb = new PacoteBasic(50);
		ArrayList<Livros> livros = new ArrayList<>();
		ArrayList<String> autores = new ArrayList<>();
		ArrayList<String> comentario = new ArrayList<>();
		ArrayList<String> justificativa = new ArrayList<>();
		autores.add("0");
		comentario.add("0");
		justificativa.add("0");
		Livros livro = new Livros(autores, comentario, justificativa, "00", "00", "00", "00", "00", "0", "0", 1);
		
		livros.add(livro);
		
		
		Assert.assertTrue(ml.updateLivroIdioma("0", "Zé", livros));
		
		/**
		 * testando se não foi atualizado
		 */
		
		Assert.assertFalse(ml.updateLivroIdioma("010", "Zé", livros));
				
	}
	
	/**
	 * testando o método updateLivroAssunto();
	 */
	@Test
	public void testUpdateLivroAssunto(){
		/**
		 * Testando se foi atualizado correto 
		 */
		Pacote pb = new PacoteBasic(50);
		ArrayList<Livros> livros = new ArrayList<>();
		ArrayList<String> autores = new ArrayList<>();
		ArrayList<String> comentario = new ArrayList<>();
		ArrayList<String> justificativa = new ArrayList<>();
		autores.add("0");
		comentario.add("0");
		justificativa.add("0");
		Livros livro = new Livros(autores, comentario, justificativa, "00", "00", "00", "00", "00", "0", "0", 1);
		
		livros.add(livro);
		
		
		Assert.assertTrue(ml.updateLivroAssunto("0", "Zé", livros));
		
		/**
		 * testando se não foi atualizado
		 */
		
		Assert.assertFalse(ml.updateLivroAssunto("1110", "Zé", livros));
	}

	/**
	 * testando o método updateLivroDescricao();
	 */
	@Test
	public void testUpdateLivroDescricao(){
		/**
		 * Testando se foi atualizado correto 
		 */
		Pacote pb = new PacoteBasic(50);
		ArrayList<Livros> livros = new ArrayList<>();
		ArrayList<String> autores = new ArrayList<>();
		ArrayList<String> comentario = new ArrayList<>();
		ArrayList<String> justificativa = new ArrayList<>();
		autores.add("0");
		comentario.add("0");
		justificativa.add("0");
		Livros livro = new Livros(autores, comentario, justificativa, "00", "00", "00", "00", "00", "0", "0", 1);
		
		livros.add(livro);
		
		
		Assert.assertTrue(ml.updateLivroDescricao("0", "Zé", livros));
		
		/**
		 * testando se não foi atualizado
		 */
		
		Assert.assertFalse(ml.updateLivroDescricao("1110", "Zé", livros));
	}
	
	/**
	 * testando o método updateLivroEdicao();
	 */
	@Test
	public void testUpdateLivroEdicao(){
		/**
		 * Testando se foi atualizado correto 
		 */
		Pacote pb = new PacoteBasic(50);
		ArrayList<Livros> livros = new ArrayList<>();
		ArrayList<String> autores = new ArrayList<>();
		ArrayList<String> comentario = new ArrayList<>();
		ArrayList<String> justificativa = new ArrayList<>();
		autores.add("0");
		comentario.add("0");
		justificativa.add("0");
		Livros livro = new Livros(autores, comentario, justificativa, "00", "00", "00", "00", "00", "0", "0", 1);
		
		livros.add(livro);
		
		
		Assert.assertTrue(ml.updateLivroEdicao("0", "Zé", livros));
		
		/**
		 * testando se não foi atualizado
		 */
		
		Assert.assertFalse(ml.updateLivroEdicao("1110", "Zé", livros));
	}
	
	/**
	 * testando o método updateLivroTitulo();
	 */
	@Test
	public void testUpdateLivroTitulo(){
		/**
		 * Testando se foi atualizado correto 
		 */
		Pacote pb = new PacoteBasic(50);
		ArrayList<Livros> livros = new ArrayList<>();
		ArrayList<String> autores = new ArrayList<>();
		ArrayList<String> comentario = new ArrayList<>();
		ArrayList<String> justificativa = new ArrayList<>();
		autores.add("0");
		comentario.add("0");
		justificativa.add("0");
		Livros livro = new Livros(autores, comentario, justificativa, "00", "00", "00", "00", "00", "0", "0", 1);
		
		livros.add(livro);
		
		
		Assert.assertTrue(ml.updateLivroTitulo("0", "Zé", livros));
		
		/**
		 * testando se não foi atualizado
		 */
		
		Assert.assertFalse(ml.updateLivroTitulo("1110", "Zé", livros));
	}
	
	/**
	 * testando o método updateLivroEditora();
	 */
	@Test
	public void testUpdateLivroEditora(){
		/**
		 * Testando se foi atualizado correto 
		 */
		Pacote pb = new PacoteBasic(50);
		ArrayList<Livros> livros = new ArrayList<>();
		ArrayList<String> autores = new ArrayList<>();
		ArrayList<String> comentario = new ArrayList<>();
		ArrayList<String> justificativa = new ArrayList<>();
		autores.add("0");
		comentario.add("0");
		justificativa.add("0");
		Livros livro = new Livros(autores, comentario, justificativa, "00", "00", "00", "00", "00", "0", "0", 1);
		
		livros.add(livro);
		
		
		Assert.assertTrue(ml.updateLivroEditora("0", "Zé", livros));
		
		/**
		 * testando se não foi atualizado
		 */
		
		Assert.assertFalse(ml.updateLivroEditora("1110", "Zé", livros));
	}
	
	/**
	 * testando o método updateLivroCódigo();
	 */
	@Test
	public void testUpdateLivroCodigo(){
		/**
		 * Testando se foi atualizado correto 
		 */
		Pacote pb = new PacoteBasic(50);
		ArrayList<Livros> livros = new ArrayList<>();
		ArrayList<String> autores = new ArrayList<>();
		ArrayList<String> comentario = new ArrayList<>();
		ArrayList<String> justificativa = new ArrayList<>();
		autores.add("0");
		comentario.add("0");
		justificativa.add("0");
		Livros livro = new Livros(autores, comentario, justificativa, "00", "00", "00", "00", "00", "0", "0", 1);
		
		livros.add(livro);
		
		
		Assert.assertTrue(ml.updateLivroCodigo("0", "Zé", livros));
		
		/**
		 * testando se não foi atualizado
		 */
		
		Assert.assertFalse(ml.updateLivroCodigo("1110", "Zé", livros));
	}
	
	/**
	 * testando o método updateLivroAno();
	 */
	@Test
	public void testUpdateLivroAno(){
		/**
		 * Testando se foi atualizado correto 
		 */
		Pacote pb = new PacoteBasic(50);
		ArrayList<Livros> livros = new ArrayList<>();
		ArrayList<String> autores = new ArrayList<>();
		ArrayList<String> comentario = new ArrayList<>();
		ArrayList<String> justificativa = new ArrayList<>();
		autores.add("0");
		comentario.add("0");
		justificativa.add("0");
		Livros livro = new Livros(autores, comentario, justificativa, "00", "00", "00", "00", "00", "0", "0", 1);
		
		livros.add(livro);
		
		
		Assert.assertTrue(ml.updateLivroAno("0", 1, livros));
		
		/**
		 * testando se não foi atualizado
		 */
		
		Assert.assertFalse(ml.updateLivroAno("1110", 1, livros));
	}
	
	/**
	 * testando o método delete();
	 */
	@Test
	public void testDelete(){
		/**
		 * Testando se foi deletado correto 
		 */
		Pacote pb = new PacoteBasic(50);
		ArrayList<Livros> livros = new ArrayList<>();
		ArrayList<String> autores = new ArrayList<>();
		ArrayList<String> comentario = new ArrayList<>();
		ArrayList<String> justificativa = new ArrayList<>();
		autores.add("0");
		comentario.add("0");
		justificativa.add("0");
		Livros livro = new Livros(autores, comentario, justificativa, "00", "00", "00", "00", "00", "0", "0", 1);
		
		livros.add(livro);
		
		
		Assert.assertTrue(ml.delete("0", livros));
		
		/**
		 * testando se não foi deletado
		 */
		
		Assert.assertFalse(ml.delete("1110", livros));
	}
	
	
}
