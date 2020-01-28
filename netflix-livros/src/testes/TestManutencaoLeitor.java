package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import netflixdeLivros.Leitor;
import netflixdeLivros.ManutencaoLeitor;
import netflixdeLivros.Pacote;
import netflixdeLivros.PacoteBasic;

public class TestManutencaoLeitor {
	ManutencaoLeitor ml = new ManutencaoLeitor();
	
	/**
	 * Testando o m�todo create(); da Classe ManutencaoLeitor
	 */
	@Test
	public void testCreate() {
		
		/**
		 * Test add um leitor ao arraylist
		 */
		Pacote pb = new PacoteBasic(50);
		ArrayList<Leitor> leitores = new ArrayList<>();
		Leitor leitor = new Leitor(pb, "00", "0", "0", "0", "0");
		leitores.add(leitor);
		Assert.assertTrue(ml.create(leitor, leitores));
		
		/**
		 * Test de add um leitor=null ao arraylist
		 */
		Leitor l = null;
		leitores.add(l);
		Assert.assertFalse(ml.create(l, leitores));		
	}
	
	/**
	 * Testando o m�todo upDateLeitorNome();
	 */
	@Test
	public void testUpdateLeitorNome(){
		/**
		 * Testando se foi atualizado correto o nome
		 */
		Pacote pb = new PacoteBasic(50);
		Leitor leitor = new Leitor(pb, "00", "0", "0", "0", "0");
		ArrayList<Leitor> leitores = new ArrayList<>();
		leitores.add(leitor);
		
		Assert.assertTrue(ml.updateLeitorNome("00", "Z�", leitores));
		
		/**
		 * testando se n�o foi atualizado o nome
		 */
		
		Assert.assertFalse(ml.updateLeitorNome("123", "00", leitores));
				
	}
	/**
	 * Testando o m�todo updateLeitorEmail();
	 */
	@Test
	public void testUpdateLeitorEmail(){
		/**
		 * Testando se foi atualizado correto o email
		 */
		Pacote pb = new PacoteBasic(50);
		Leitor leitor = new Leitor(pb, "00", "0", "0", "0", "0");
		ArrayList<Leitor> leitores = new ArrayList<>();
		leitores.add(leitor);
		
		Assert.assertTrue(ml.updateLeitorEmail("00", "Z�", leitores));
		
		/**
		 * testando se n�o foi atualizado o email
		 */
		
		Assert.assertFalse(ml.updateLeitorEmail("123", "00", leitores));
	}
	
	/**
	 * Testando o m�todo updateLeitorCPF();
	 */
	@Test
	public void testUpdateLeitorCPF(){
		/**
		 * Testando se foi atualizado correto o cpf
		 */
		Pacote pb = new PacoteBasic(50);
		Leitor leitor = new Leitor(pb, "00", "0", "0", "0", "0");
		ArrayList<Leitor> leitores = new ArrayList<>();
		leitores.add(leitor);
		
		Assert.assertTrue(ml.updateLeitorCPF("00", "Z�", leitores));
		
		/**
		 * testando se n�o foi atualizado o cpf
		 */
		
		Assert.assertFalse(ml.updateLeitorCPF("123", "00", leitores));
	}
	
	/**
	 * Testando o m�todo updateLeitorDataNascimento();
	 */
	@Test
	public void testUpdateLeitorDataNascimento(){
		/**
		 * Testando se foi atualizado correto o data de nascimento
		 */
		Pacote pb = new PacoteBasic(50);
		Leitor leitor = new Leitor(pb, "00", "0", "0", "0", "0");
		ArrayList<Leitor> leitores = new ArrayList<>();
		leitores.add(leitor);
		
		Assert.assertTrue(ml.updateLeitorDataNascimento("00", "Z�", leitores));
		
		/**
		 * testando se n�o foi atualizado o data de nascimento
		 */
		
		Assert.assertFalse(ml.updateLeitorDataNascimento("123", "00", leitores));
	}
	
	/**
	 * Testando o m�tpdp delete();
	 */
	@Test
	public void testDelete(){
		/**
		 * Testando se foi removido correto o leitor
		 */
		Pacote pb = new PacoteBasic(50);
		Leitor leitor = new Leitor(pb, "00", "0", "0", "0", "0");
		ArrayList<Leitor> leitores = new ArrayList<>();
		leitores.add(leitor);
		
		Assert.assertTrue(ml.delete("00", leitores));
		
		/**
		 * testando se n�o foi removido o leitor
		 */
		
		Assert.assertFalse(ml.delete("123", leitores));
	}
	
	/**
	 * Testando o m�todo findLeitor();
	 */
	@Test
	public void testFindLeitor(){
		/**
		 * Testando se o leitor existe
		 */
		Pacote pb = new PacoteBasic(50);
		Leitor leitor = new Leitor(pb, "00", "0", "0", "0", "0");
		ArrayList<Leitor> leitores = new ArrayList<>();
		leitores.add(leitor);
		
		Assert.assertTrue(ml.findLeitor("00", leitores));
		
		/**
		 * testando se o leitor n�o existe
		 */
		
		Assert.assertFalse(ml.findLeitor("010", leitores));
	}
	
	/**
	 * testa o m�todo findLeitorSenha();
	 */
	@Test
	public void testFindLeitorSenha(){
		/**
		 * Testando se a senha � correta
		 */
		Pacote pb = new PacoteBasic(50);
		Leitor leitor = new Leitor(pb, "00", "0", "0", "0", "0");
		ArrayList<Leitor> leitores = new ArrayList<>();
		leitores.add(leitor);
		
		Assert.assertTrue(ml.findLeitorSenha(leitores, "00"));
		
		/**
		 * testando se a senha est� errada
		 */
		
		Assert.assertFalse(ml.findLeitorSenha(leitores, "100"));
	}
	
	
}
