package classes;

public class Main {

	public static void main(String[] args) throws Exception {
		Professor prof1 = new Professor("joao", 1000);
		Professor prof2 = new Professor("emanuel", 1001);
		Aluno aluno1 = new Aluno("dijay", 2000);
		Aluno aluno2 = new Aluno("pedro", 2001);
		Disciplina port = new Disciplina("português", 3000);
		Disciplina mat = new Disciplina("matemática", 3001);
		Horario segundaPrimeiro = new Horario("primeiro", "segunda");
		Coordenacao coordenacao = new Coordenacao();
		coordenacao.alocarTurma(prof1, port, segundaPrimeiro, 4000);
		coordenacao.addAlunoTurma(aluno1, 4000);
		coordenacao.addAlunoTurma(aluno2, 4000);
		
		System.out.println("a) Quais disciplinas um professor esta ministrando?");
		System.out.println(coordenacao.disciplinasProfessor(1000));
		
		System.out.println("b) Qual o horário de um professor?");
		System.out.println(coordenacao.horarioProfessor(1000) + "\n");
		
		System.out.println("c) Quais os alunos de uma dada disciplina?");
		System.out.println(coordenacao.alunosDisciplina(3000) + "\n");
		
		System.out.println("d) Quais as disciplinas de um aluno?");
		System.out.println(coordenacao.disciplinasAluno(2000) + "\n");
		
		System.out.println("e) Qual o horário de um aluno?");
		System.out.println(coordenacao.horarioAluno(2000) + "\n");
		
		System.out.println("f) Qual o número de alunos de uma disciplina?");
		System.out.println(coordenacao.qtdAlunoEmDisciplina(3000));
		
	}

}
