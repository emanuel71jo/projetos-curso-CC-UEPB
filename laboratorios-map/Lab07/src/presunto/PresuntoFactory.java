package presunto;

public class PresuntoFactory {
	public PresuntoIF criarFatiaPresunto(PresuntoENUM fatia) {
		if(fatia == PresuntoENUM.FRANGO)
			return new PresuntoFrango();
		return new PresuntoPeru();
	}
}
