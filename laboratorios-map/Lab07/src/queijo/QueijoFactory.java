package queijo;

public class QueijoFactory {

	public QueijoIF criaFatiaQueijo(QueijoENUM fatia) {
		if(fatia == QueijoENUM.CHEDDAR)
			return new QueijoCheddar();
		else if (fatia == QueijoENUM.PRATO)
			return new QueijoPrato();
		return new QueijoMussarela();
	}
	
}
