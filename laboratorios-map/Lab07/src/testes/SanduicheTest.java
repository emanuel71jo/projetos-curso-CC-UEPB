package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ovo.OvoCapoeira;
import ovo.OvoENUM;
import ovo.OvoGranja;
import pao.PaoBola;
import pao.PaoENUM;
import pao.PaoFrances;
import pao.PaoIntegral;
import presunto.PresuntoENUM;
import presunto.PresuntoFrango;
import presunto.PresuntoPeru;
import queijo.QueijoCheddar;
import queijo.QueijoENUM;
import queijo.QueijoMussarela;
import queijo.QueijoPrato;
import sanduiche.Sanduiche;

class SanduicheTest {

	Sanduiche sanduiche;
	
	@BeforeEach
	public void setUp() {
		this.sanduiche = new Sanduiche();
	}
	
	@Test
	public void testQueijo() {
		
		assertNull(this.sanduiche.getFatiaQueijo());
		
		this.sanduiche.setFatiaQueijo(QueijoENUM.MUSSARELA);
		assertEquals(new QueijoMussarela().tipoQueijo(),
				this.sanduiche.getFatiaQueijo().tipoQueijo());
		
		this.sanduiche.setFatiaQueijo(QueijoENUM.CHEDDAR);
		assertEquals(new QueijoCheddar().tipoQueijo(),
				this.sanduiche.getFatiaQueijo().tipoQueijo());
		
		this.sanduiche.setFatiaQueijo(QueijoENUM.PRATO);
		assertEquals(new QueijoPrato().tipoQueijo(),
				this.sanduiche.getFatiaQueijo().tipoQueijo());
	}
	
	@Test
	public void testPresunto() {
		
		assertNull(this.sanduiche.getFatiaPresunto());
		
		this.sanduiche.setFatiaPresunto(PresuntoENUM.FRANGO);
		assertEquals(new PresuntoFrango().fatiaPresunto(),
				this.sanduiche.getFatiaPresunto().fatiaPresunto());
		
		this.sanduiche.setFatiaPresunto(PresuntoENUM.PERU);
		assertEquals(new PresuntoPeru().fatiaPresunto(),
				this.sanduiche.getFatiaPresunto().fatiaPresunto());
		
	}
	
	@Test
	public void testPao() {
		
		assertNull(this.sanduiche.getFatiaInferior());
		assertNull(this.sanduiche.getFatiaSuperior());
		
		this.sanduiche.setFatiaPaoInferior(PaoENUM.BOLA);
		this.sanduiche.setFatiaPaoSuperior(PaoENUM.BOLA);
		assertEquals(new PaoBola().tipoFatia(),
				this.sanduiche.getFatiaInferior().tipoFatia());
		assertEquals(new PaoBola().tipoFatia(),
				this.sanduiche.getFatiaSuperior().tipoFatia());
		
		this.sanduiche.setFatiaPaoInferior(PaoENUM.FRANCES);
		this.sanduiche.setFatiaPaoSuperior(PaoENUM.FRANCES);
		assertEquals(new PaoFrances().tipoFatia(),
				this.sanduiche.getFatiaInferior().tipoFatia());
		assertEquals(new PaoFrances().tipoFatia(),
				this.sanduiche.getFatiaSuperior().tipoFatia());
		
		this.sanduiche.setFatiaPaoInferior(PaoENUM.INTEGRAL);
		this.sanduiche.setFatiaPaoSuperior(PaoENUM.INTEGRAL);
		assertEquals(new PaoIntegral().tipoFatia(),
				this.sanduiche.getFatiaInferior().tipoFatia());
		assertEquals(new PaoIntegral().tipoFatia(),
				this.sanduiche.getFatiaSuperior().tipoFatia());
		
	}
	
	@Test
	public void testOvo() {
		
		assertNull(this.sanduiche.getOvo());
		
		this.sanduiche.setOvo(OvoENUM.CAPOEIRA);
		assertEquals(new OvoCapoeira().tipoOvo(),
				this.sanduiche.getOvo().tipoOvo());
		
		this.sanduiche.setOvo(OvoENUM.GRANJA);
		assertEquals(new OvoGranja().tipoOvo(),
				this.sanduiche.getOvo().tipoOvo());
		
	}
	
	@Test
	public void testTomate() {
		
		assertNull(this.sanduiche.getFatiaTomate());
		
		this.sanduiche.addTomate();
		
		assertNotNull(this.sanduiche.getFatiaTomate());
		
	}
	
	@Test
	public void testTipoSanduiche() {
		
		this.sanduiche = new Sanduiche(PaoENUM.BOLA, PaoENUM.BOLA,
				QueijoENUM.MUSSARELA, PresuntoENUM.PERU, OvoENUM.GRANJA, true);
		String str = "SANDUICHE\n" + 
				"FATIA DE PAO BOLA\n" + 
				"FATIA DE QUEIJO MUSSARELA\n" + 
				"FATIA DE PRESUNTO DE PERU\n" + 
				"OVO DE GRANJA\n" + 
				"FATIA DE TOMATE\n" + 
				"FATIA DE PAO BOLA\n";
		
		assertEquals(this.sanduiche.getInfoSanduiche(), str);
		
	}
	

}










