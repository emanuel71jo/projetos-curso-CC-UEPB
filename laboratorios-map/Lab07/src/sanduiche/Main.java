package sanduiche;

import ovo.OvoENUM;
import pao.PaoENUM;
import presunto.PresuntoENUM;
import queijo.QueijoENUM;

public class Main {

	public static void main(String[] args) {
		
		
		//Construtor Sanduiche
		// Tipo Pao Inferior, Tipo Pao Superior, Queijo, Presunto, Ovo, Tomate
		
		// PRIMEIRO TIPO DE SANDUICHE
		Sanduiche sanduiche1 = new Sanduiche(PaoENUM.BOLA, PaoENUM.BOLA,
				QueijoENUM.MUSSARELA, PresuntoENUM.PERU, OvoENUM.GRANJA, true);
		System.out.println(sanduiche1.getInfoSanduiche());
		
		//SEGUNDO TIPO DE SANDUICHE
		Sanduiche sanduiche2 = new Sanduiche(PaoENUM.FRANCES, PaoENUM.BOLA,
				QueijoENUM.PRATO, PresuntoENUM.PERU, OvoENUM.CAPOEIRA, false);
		System.out.println(sanduiche2.getInfoSanduiche());
		
		//TERCEIRO TIPO DE SANDUICHE
		Sanduiche sanduiche3 = new Sanduiche(PaoENUM.INTEGRAL, PaoENUM.INTEGRAL,
				QueijoENUM.CHEDDAR, PresuntoENUM.FRANGO, OvoENUM.CAPOEIRA, true);
		System.out.println(sanduiche3.getInfoSanduiche());

		

	}

}
