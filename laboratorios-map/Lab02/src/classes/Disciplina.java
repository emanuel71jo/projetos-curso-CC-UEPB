package classes;

public class Disciplina {
	private int idDisciplina;
	private String nome;
	
	

	public Disciplina(String nome, int idDisciplina) {
		super();
		this.idDisciplina = idDisciplina;
		this.nome = nome;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean equals(int id) {
		if(id == idDisciplina)
			return true;
		return false;
	}
	
}
