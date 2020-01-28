package classes;

import java.util.ArrayList;

public class Turma {
	private int idTurma;
	private Professor professor;
	private Disciplina disciplina;
	private ArrayList<Aluno> alunos;
	private Horario horario;
	
	public Turma(Professor professor, Disciplina disciplina, Horario horario, int id ) {
		super();
		this.professor = professor;
		this.disciplina = disciplina;
		this.horario = horario;
		this.alunos = new ArrayList<Aluno>();
		this.idTurma = id;
	}
	
	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void addAluno(Aluno a) {
		this.alunos.add(a);
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	

	public String getAlunos() {
		String str = "";
		for(Aluno a: alunos) {
			str += "Nome: " + a.getNome() + "  ";
		}
		return str;
	}
	
	public ArrayList<Aluno> getAluno(){
		return this.alunos;
	}

	public String getHorario() {
		return horario.getHorario();
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public int getQtdAlunos() {
		return this.alunos.size();
	}
	
	public boolean alunoNaTurma(int mat) {
		for(Aluno a: alunos) {
			if(a.getMatricula() == mat)
				return true;
		}
		
		return false;
	}
	
}
