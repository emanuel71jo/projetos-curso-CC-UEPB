package aluno;

/**
 * Classe Aluno, que contém apenas os atributos de um aluno.
 * 
 * @author sabrinasouto
 */
public class Aluno {
	
	private String matricula;
	private String nome;
	private double nota1;
	private double nota2;
	private double mediaFinal;
	int frequencia;
	
	/**
	 * Construtor de Aluno.
	 * @param nomeAluno
	 * @param n1
	 * @param n2
	 * @param freq
	 */
	public Aluno(String matAluno, String nomeAluno, float n1, float n2, float mfinal, int freq){
		this.matricula = matAluno;
		this.nome = nomeAluno;
		this.nota1 = n1;
		this.nota2 = n2;
		this.mediaFinal = mfinal;
		this.frequencia = freq;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	
	public double getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

}
