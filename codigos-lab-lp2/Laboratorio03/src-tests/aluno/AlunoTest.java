package aluno;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlunoTest {
	
	Aluno aluno1;

	@Before
	public void setUp() throws Exception {
		aluno1 = new Aluno("10203055", "Joao Paulo", 7, 7, 0, 80);
	}
	
	@Test
	public void testNome() {
		assertEquals("Joao Paulo", aluno1.getNome());
		aluno1.setNome("Daniel");
		assertEquals("Daniel", aluno1.getNome());
		
	}
	
	@Test
	public void testMatricula(){
		assertEquals("10203055", aluno1.getMatricula());
	}

	@After
	public void tearDown() throws Exception {
	}

}
