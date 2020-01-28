package pao;

public class PaoFactory {
	
	public PaoIF criaFatiaPao(PaoENUM fatia) {
		if(fatia == PaoENUM.BOLA)
			return new PaoBola();
		else if(fatia == PaoENUM.FRANCES)
			return new PaoFrances();
		return new PaoIntegral();
	}
}
