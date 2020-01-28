package sanduiche;

import ovo.OvoENUM;
import ovo.OvoFactory;
import ovo.OvoIF;
import pao.PaoENUM;
import pao.PaoFactory;
import pao.PaoIF;
import presunto.PresuntoENUM;
import presunto.PresuntoFactory;
import presunto.PresuntoIF;
import queijo.QueijoENUM;
import queijo.QueijoFactory;
import queijo.QueijoIF;

public class Sanduiche {
	
	private PaoIF fatiaSuperior;
	private PaoIF fatiaInferior;
	private QueijoIF fatiaQueijo;
	private PresuntoIF fatiaPresunto;
	private OvoIF ovo;
	private Tomate fatiaTomate;
	
	public Sanduiche() {
		
	}
	
	public Sanduiche(PaoENUM paoI, PaoENUM paoS, QueijoENUM queijo,
			PresuntoENUM presunto, OvoENUM ovo, boolean tomate) {
		this.fatiaInferior = new PaoFactory().criaFatiaPao(paoI);
		this.fatiaSuperior = new PaoFactory().criaFatiaPao(paoS);
		this.fatiaQueijo = new QueijoFactory().criaFatiaQueijo(queijo);
		this.fatiaPresunto = new PresuntoFactory().criarFatiaPresunto(presunto);
		this.ovo = new OvoFactory().criarOvo(ovo);
		if(tomate)
			this.fatiaTomate = new Tomate();
	}

	public void setFatiaPaoInferior(PaoENUM fatia) {
		this.fatiaInferior = new PaoFactory().criaFatiaPao(fatia);
	}
	
	public void setFatiaPaoSuperior(PaoENUM fatia) {
		this.fatiaSuperior = new PaoFactory().criaFatiaPao(fatia);
	}
	
	public void setFatiaQueijo(QueijoENUM fatia) {
		this.fatiaQueijo = new QueijoFactory().criaFatiaQueijo(fatia);
	}
	
	public void setFatiaPresunto(PresuntoENUM fatia) {
		this.fatiaPresunto = new PresuntoFactory().criarFatiaPresunto(fatia);
	}
	
	public void setOvo(OvoENUM ovo) {
		this.ovo = new OvoFactory().criarOvo(ovo);
	}
	
	public void addTomate() {
		this.fatiaTomate = new Tomate();
	}
	
	
	
	public PaoIF getFatiaSuperior() {
		return fatiaSuperior;
	}

	public PaoIF getFatiaInferior() {
		return fatiaInferior;
	}

	public QueijoIF getFatiaQueijo() {
		return fatiaQueijo;
	}

	public PresuntoIF getFatiaPresunto() {
		return fatiaPresunto;
	}

	public OvoIF getOvo() {
		return ovo;
	}

	public Tomate getFatiaTomate() {
		return fatiaTomate;
	}

	public String getInfoSanduiche() {
		String str = "SANDUICHE\n";
		str += this.fatiaSuperior.tipoFatia() + "\n";
		str += this.fatiaQueijo.tipoQueijo() + "\n";
		str += this.fatiaPresunto.fatiaPresunto() + "\n";
		str += this.ovo.tipoOvo() + "\n";
		if(this.fatiaTomate != null)
			str += this.fatiaTomate.fatiaTomate() + "\n";
		str += this.fatiaInferior.tipoFatia() + "\n";
		
		return str;
	}
	
}
