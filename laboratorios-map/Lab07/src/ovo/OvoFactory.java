package ovo;

public class OvoFactory {
	public OvoIF criarOvo(OvoENUM tipo) {
		if(tipo == OvoENUM.CAPOEIRA)
			return new OvoCapoeira();
		return new OvoGranja();
	}
}
