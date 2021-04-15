package aluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe GerenciadorAluno, que faz o gerenciamento de mais de um aluno.
 * 
 * @author sabrinasouto
 */

public class GerenciadorAluno {
	
	private List<Aluno> alunos;
	
	
	/**
	 * Construtor de GerenciadorAluno. 
	 */
	public GerenciadorAluno(){
		this.alunos = new ArrayList<Aluno>();
	}
	
	/**
	 * Insere um aluno na lista de alunos, se essa lista 
	 * ainda não contém esse aluno (não insere repetido).
	 * @param aluno, o aluno a ser inserido;
	 * @return true, se a inserção for realizada; false, caso contrário.
	 */
	public boolean inserir(Aluno aluno){
		if(!alunos.contains(aluno)){
			alunos.add(aluno);
			return true;
		}
		return false;
	}
	
	/**
	 * Remove um aluno da lista de alunos, se essa lista 
	 * contém esse aluno.
	 * @param aluno, o aluno a ser removido.
	 * @return true, se a remoção for realizada; false, caso contrário.
	 */
	public boolean remover(Aluno aluno){
		if(alunos.contains(aluno)){
			alunos.add(aluno);
			return true;
		}
		return false;
	}
	
	/**
	 * @return a lista de alunos.
	 */
	public List<Aluno> getAlunos(){
		return this.alunos;
	}
	

}
