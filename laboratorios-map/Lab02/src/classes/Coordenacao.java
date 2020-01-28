package classes;

import java.util.ArrayList;

public class Coordenacao {
	private ArrayList<Turma> turmas = new ArrayList<Turma>();
	
	public void alocarTurma(String nomeProfessor, int matriculaProfessor,
			String nomeDisciplina, int idDisciplina,
			String dia, String horario, int i){
		
		this.turmas.add(new Turma(nomeProfessor, matriculaProfessor,
				nomeDisciplina, idDisciplina, dia, horario, i));
	}

	public void addAlunoTurma(String nomeAluno, int matriculaAluno, int idTurma){
		addAlunoTurma(idTurma, new Aluno(nomeAluno, matriculaAluno));
	}
	
	private void addAlunoTurma(int idTurma, Aluno alu) {
		for(Turma t: turmas) {
			if(t.getIdTurma() == idTurma) {
				t.addAluno(alu);
				break;
			}
		}
	}

	public String disciplinasProfessor(int mat) {
		String str = "";
		for(Turma t: turmas) {
			if(t.getProfessor().getMatricula() == mat) {
				str += "Disciplina: " + t.getDisciplina().getNome() + "\n";
			}
		}
		return str;
	}

	public String horarioProfessor(int mat) {
		String str = "";
		for(Turma t: turmas) {
			if(t.getProfessor().getMatricula() == mat) {
				str += t.getHorario();
			}
		}
		return str;
	}

	public String alunosDisciplina(int idDis) {
		for(Turma t: turmas) {
			if(t.getDisciplina().equals(idDis))
				return t.getAlunos();
		}
		return "";
	}

	public String disciplinasAluno(int mat) {
		String str = "";
		
		for(Turma t: turmas) {
			if(alunoNessaTurma(mat, t))
				str += "Disciplina: " + t.getDisciplina().getNome();
		}
		return str;
	}

	private boolean alunoNessaTurma(int mat, Turma t) {
		for(Aluno a: t.getAluno()) {
			if(a.getMatricula() == mat)
				return true;
		}
		return false;
	}

	public String horarioAluno(int i) {
		String str = "";
		
		for(Turma t: turmas) {
			if(alunoNessaTurma(i, t))
				str += t.getHorario();
		}
		return str;
	}

	public int qtdAlunoEmDisciplina(int id) {
		for(Turma t: turmas) {
			if(t.getDisciplina().getIdDisciplina() == id)
				return t.getQtdAlunos();
		}
		return 0;
	}
	
	public ArrayList<Turma> getTurma(){
		return this.turmas;
	}
	
	public int qtdTurmas() {
		return this.turmas.size();
	}
}
