package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Aluno;
import classes.Coordenacao;
import classes.Disciplina;
import classes.Horario;
import classes.Professor;
import classes.Turma;

public class TestCoordenacao {
	String[] alunos =  {"aluno1","aluno2","aluno3","aluno4"};
	String[] professores = {"prof1","prof2","prof3","prof4"};
	String[] disciplinas = {"português", "matemática"};
	String[] horarios = {"primeiro","segundo"};
	String[] diaSemana = {"segunda","quinta"};
	Turma[] turmas = new Turma[2];
	Horario[] hrs= new Horario[4];
	Disciplina port, mat;
	Professor[] profs = new Professor[4];
	Aluno[] alu = new Aluno[4];
	Coordenacao coordenacao;
	
	@BeforeEach
	public void up() {
		inicializarProfessores();
		inicializarAlunos();
		inicializarDisciplinas();
		inicializarHorarios();
		coordenacao = new Coordenacao();
	}

	private void inicializarHorarios() {
		hrs[0] = new Horario(horarios[0], diaSemana[0]);
		hrs[1] = new Horario(horarios[0], diaSemana[1]);
		hrs[2] = new Horario(horarios[1], diaSemana[0]);
		hrs[3] = new Horario(horarios[1], diaSemana[1]);
	}
	private void inicializarDisciplinas() {
		port = new Disciplina(disciplinas[0], 3000);
		mat = new Disciplina(disciplinas[1], 3001);
		
	}

	private void inicializarAlunos() {
		for(int i = 0; i < 4; i++)
			alu[i] = new Aluno(alunos[i], 2000 + i);
	}

	private void inicializarProfessores() {
		for(int i = 0; i < 4; i++)
			profs[i] = new Professor(professores[i], 1000 + i);
	}
	
	@Test
	public void testInsercaoTurma() throws Exception {
		assertNotNull(coordenacao.getTurma());
		assertEquals(0, coordenacao.qtdTurmas());
		coordenacao.alocarTurma(profs[0], port, hrs[0], 5000);
		assertEquals(1, coordenacao.qtdTurmas());
		coordenacao.alocarTurma(profs[1], mat, hrs[2], 5001);
		assertEquals(2, coordenacao.qtdTurmas());
	}
	
	@Test
	public void testInsercaoAlunoNaTurma() throws Exception {
		assertNotNull(coordenacao.getTurma());
		assertEquals(0, coordenacao.qtdTurmas());
		coordenacao.alocarTurma(profs[0], port, hrs[0], 5000);
		assertEquals(1, coordenacao.qtdTurmas());
		coordenacao.alocarTurma(profs[1], mat, hrs[2], 5001);
		assertEquals(2, coordenacao.qtdTurmas());
		
		coordenacao.addAlunoTurma(alu[0], 5000);
		coordenacao.addAlunoTurma(alu[1], 5000);
		coordenacao.addAlunoTurma(alu[2], 5000);
		coordenacao.addAlunoTurma(alu[3], 5000);
		
		assertEquals(4, coordenacao.qtdAlunoEmDisciplina(3000));
		assertEquals(0, coordenacao.qtdAlunoEmDisciplina(3001));
		
	}
	
	@Test
	public void testDisciplinasAluno() throws Exception {
		assertNotNull(coordenacao.getTurma());
		assertEquals(0, coordenacao.qtdTurmas());
		coordenacao.alocarTurma(profs[0], port, hrs[0], 5000);
		assertEquals(1, coordenacao.qtdTurmas());
		coordenacao.alocarTurma(profs[1], mat, hrs[2], 5001);
		assertEquals(2, coordenacao.qtdTurmas());
		
		coordenacao.addAlunoTurma(alu[0], 5000);
		coordenacao.addAlunoTurma(alu[1], 5000);
		coordenacao.addAlunoTurma(alu[2], 5000);
		coordenacao.addAlunoTurma(alu[3], 5000);
		
		assertEquals(4, coordenacao.qtdAlunoEmDisciplina(3000));
		assertEquals(0, coordenacao.qtdAlunoEmDisciplina(3001));
		
		assertEquals("Disciplina: português", coordenacao.disciplinasAluno(2000));
		assertEquals("Disciplina: português", coordenacao.disciplinasAluno(2002));
		assertNotEquals("Disciplina: matemática", coordenacao.disciplinasAluno(2001));
		
	}
	
	@Test
	public void testDisciplinasProfessor() throws Exception {
		assertNotNull(coordenacao.getTurma());
		assertEquals(0, coordenacao.qtdTurmas());
		coordenacao.alocarTurma(profs[0], port, hrs[0], 5000);
		assertEquals(1, coordenacao.qtdTurmas());
		coordenacao.alocarTurma(profs[1], mat, hrs[2], 5001);
		assertEquals(2, coordenacao.qtdTurmas());
		
		coordenacao.addAlunoTurma(alu[0], 5000);
		coordenacao.addAlunoTurma(alu[1], 5000);
		coordenacao.addAlunoTurma(alu[2], 5000);
		coordenacao.addAlunoTurma(alu[3], 5000);
		
		assertEquals(4, coordenacao.qtdAlunoEmDisciplina(3000));
		assertEquals(0, coordenacao.qtdAlunoEmDisciplina(3001));
		
		assertEquals("Disciplina: português", coordenacao.disciplinasAluno(2000));
		assertEquals("Disciplina: português", coordenacao.disciplinasAluno(2002));
		assertNotEquals("Disciplina: matemática", coordenacao.disciplinasAluno(2001));
		
		assertEquals("Disciplina: português\n", coordenacao.disciplinasProfessor(1000));
		assertEquals("", coordenacao.disciplinasProfessor(1002));
	}
}
