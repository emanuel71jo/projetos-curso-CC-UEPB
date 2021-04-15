package aluno;

import java.util.List;

/**
 * Classe Caderneta, que calcula e checa a aprovação dos alunos.
 * 
 * @author sabrinasouto
 */
public class Caderneta {
	
	private List<Aluno> alunos;
	
	public Caderneta(List<Aluno> alunosMatriculados){
		this.alunos = alunosMatriculados;
	}
	
	/**
	 * Calcula a média de uma aluno. 
	 * @param aluno
	 * @return
	 * @throws Exception
	 */
	public double calculaMedia(Aluno aluno) throws Exception{
		double media;
		if(alunos.contains(aluno)){
			media = (aluno.getNota1() + aluno.getNota2()) / 2;
			return media;
		} else throw new Exception("Aluno inexistente!");
	}
	
	/**
	 * Checa se um aluno foi aprovado, de acordo com as regras de aprovação.
	 * @param aluno
	 * @return
	 * @throws Exception
	 */
	public boolean verificaAprovacao(Aluno aluno) throws Exception{
		double media = calculaMedia(aluno);
		if(alunos.contains(aluno)){
			if(aluno.getFrequencia() < 75)
				return false;
			else if((aluno.frequencia >= 75) && media < 3.0)
				return false;
			else if((aluno.getFrequencia() >= 75) && media >= 7.0)
				return true;
			else if((aluno.getFrequencia() >= 75) && aluno.getMediaFinal() >= 5.0)
				return true;
			else if((aluno.getFrequencia() >= 75) && aluno.getMediaFinal() < 5.0)
				return false;
			else return false;
		} else throw new Exception("Aluno inexistente!");
	}
	
	
	

}
