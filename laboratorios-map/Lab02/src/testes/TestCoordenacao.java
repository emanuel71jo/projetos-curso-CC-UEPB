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
	Coordenacao coordenacao;
	
	@BeforeEach
	public void up() {
		coordenacao = new Coordenacao();
	}

	@Test
	public void testInsercaoTurma() throws Exception {
		assertNotNull(coordenacao.getTurma());
		assertEquals(0, coordenacao.qtdTurmas());
		coordenacao.alocarTurma("joao", 1000, "português", 3000,
				"segunda", "segundo", 5000);
		assertEquals(1, coordenacao.qtdTurmas());
		coordenacao.alocarTurma("emanuel", 1001, "matemática", 3001,
				"terca", "primeiro", 5001);
		assertEquals(2, coordenacao.qtdTurmas());
	}
	
	@Test
	public void testInsercaoAlunoNaTurma() throws Exception {
		assertNotNull(coordenacao.getTurma());
		assertEquals(0, coordenacao.qtdTurmas());
		coordenacao.alocarTurma("joao", 1000, "português", 3000,
				"segunda", "segundo", 5000);
		assertEquals(1, coordenacao.qtdTurmas());
		coordenacao.alocarTurma("emanuel", 1001, "matemática", 3001,
				"terca", "primeiro", 5001);
		assertEquals(2, coordenacao.qtdTurmas());
		
		coordenacao.addAlunoTurma("joao", 4000, 5000);
		coordenacao.addAlunoTurma("emanuel", 4001, 5000);
		coordenacao.addAlunoTurma("dijay", 4002, 5000);
		coordenacao.addAlunoTurma("pedro", 4003, 5000);
		
		assertEquals(4, coordenacao.qtdAlunoEmDisciplina(3000));
		assertEquals(0, coordenacao.qtdAlunoEmDisciplina(3001));
		
	}
	
	@Test
	public void testDisciplinasAluno() throws Exception {
		assertNotNull(coordenacao.getTurma());
		assertEquals(0, coordenacao.qtdTurmas());
		coordenacao.alocarTurma("joao", 1000, "português", 3000,
				"segunda", "segundo", 5000);
		assertEquals(1, coordenacao.qtdTurmas());
		coordenacao.alocarTurma("emanuel", 1001, "matemática", 3001,
				"terca", "primeiro", 5001);
		assertEquals(2, coordenacao.qtdTurmas());
		
		coordenacao.addAlunoTurma("joao", 4000, 5000);
		coordenacao.addAlunoTurma("emanuel", 4001, 5000);
		coordenacao.addAlunoTurma("dijay", 4002, 5000);
		coordenacao.addAlunoTurma("pedro", 4003, 5000);
		
		assertEquals(4, coordenacao.qtdAlunoEmDisciplina(3000));
		assertEquals(0, coordenacao.qtdAlunoEmDisciplina(3001));
		
		assertEquals("Disciplina: português", coordenacao.disciplinasAluno(4000));
		assertEquals("Disciplina: português", coordenacao.disciplinasAluno(4001));
		assertNotEquals("Disciplina: matemática", coordenacao.disciplinasAluno(4002));
		
	}
	
	@Test
	public void testDisciplinasProfessor() throws Exception {
		assertNotNull(coordenacao.getTurma());
		assertEquals(0, coordenacao.qtdTurmas());
		coordenacao.alocarTurma("joao", 1000, "português", 3000,
				"segunda", "segundo", 5000);
		assertEquals(1, coordenacao.qtdTurmas());
		coordenacao.alocarTurma("emanuel", 1001, "matemática", 3001,
				"terca", "primeiro", 5001);
		assertEquals(2, coordenacao.qtdTurmas());
		
		coordenacao.addAlunoTurma("joao", 4000, 5000);
		coordenacao.addAlunoTurma("emanuel", 4001, 5000);
		coordenacao.addAlunoTurma("dijay", 4002, 5000);
		coordenacao.addAlunoTurma("pedro", 4003, 5000);
		
		assertEquals(4, coordenacao.qtdAlunoEmDisciplina(3000));
		assertEquals(0, coordenacao.qtdAlunoEmDisciplina(3001));
		
		assertEquals("Disciplina: português", coordenacao.disciplinasAluno(4000));
		assertEquals("Disciplina: português", coordenacao.disciplinasAluno(4001));
		assertNotEquals("Disciplina: matemática", coordenacao.disciplinasAluno(4002));
		
		assertEquals("Disciplina: português\n", coordenacao.disciplinasProfessor(1000));
		assertEquals("", coordenacao.disciplinasProfessor(1002));
	}
}
