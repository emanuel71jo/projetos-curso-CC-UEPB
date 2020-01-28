package classes;

import java.util.ArrayList;

public class Coordenacao {
	private ArrayList<Turma> turmas = new ArrayList<Turma>();
	
	public void alocarTurma(Professor prof, Disciplina dis, Horario h, int i) throws Exception {
		if(professorChoqueHorario(prof.getMatricula(), h))
			throw new Exception();
		this.turmas.add(new Turma(prof, dis, h, i));
	}
	
	private boolean professorChoqueHorario(int matricula, Horario h) {
		for(Turma t: turmas) {
			if(t.getProfessor().getMatricula() == matricula 
					&& t.getHorario().equals(h))
				return true;
		}
		return false;
	}

	public void addAlunoTurma(Aluno alu, int idTurma) throws Exception {
		if(turmaNaoExistente(idTurma))
			throw new Exception();
		if(alunoJaMatriculaNaTurma(alu.getMatricula()))
			throw new Exception();
		addAlunoTurma(idTurma, alu);
	}

	private boolean alunoJaMatriculaNaTurma(int matricula) {
		for(Turma t: turmas) {
			if(t.alunoNaTurma(matricula))
				return true;
		}
		return false;
	}

	private boolean turmaNaoExistente(int idTurma) {
		for(Turma t: turmas) {
			if(t.getIdTurma() == idTurma)
				return false;
		}
		return true;
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
