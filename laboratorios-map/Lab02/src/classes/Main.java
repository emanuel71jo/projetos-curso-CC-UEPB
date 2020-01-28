package classes;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Coordenacao coordenacao = new Coordenacao();
		coordenacao.alocarTurma("Joao", 1000, "português", 3000,
				"segunda", "primeiro", 4000);
		coordenacao.addAlunoTurma("dijay", 2000, 4000);
		coordenacao.addAlunoTurma("pedro", 2001, 4000);
		
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
