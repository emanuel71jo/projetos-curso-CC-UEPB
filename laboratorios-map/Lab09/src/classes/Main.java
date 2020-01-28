package classes;

public class Main {

	public static void main(String[] args) {
		
		ListIF lista = new MapList();
		ListIF lista2 = new MapList();
		ListIF lista3 = new MapList();
		
		MapIF mapa = new ListMap();
		MapIF mapa2 = new ListMap();
		MapIF mapa3 = new ListMap();

		lista2.add(0, 2);
		lista2.add(1, 3);
		lista2.add(1, 3);
		
		mapa2.put(0, 4);
		mapa2.put(1, 6);
		mapa2.put(1, 6);
		
		//add elementos na lista
		int cont = 0;
		for (int i = 17; i >= 0; i--) {
			lista.add(cont, i);
			lista3.add(cont, i);
			cont++;
		}
		
		//put elementos no mapa
		cont = 0;
		for (int i = 17; i >= 0; i--) {
			mapa.put(cont, i);
			mapa3.put(cont, i);
			cont++;
		}
		
		//verificando se o elemento existe
		lista.contains(3);
		lista.contains(17);
		lista.contains(900);
		
		//verificando se o elemento existe
		mapa.containsValue(6);
		mapa.containsValue(17);
		mapa.containsValue(900);
		
		//comparando as listas
		lista.equals(lista2);
		
		//comparando os mapas
		mapa.equals(mapa2);
		
		//pegando elemento da lista por indice
		lista.get(5);
		lista.get(100);
		
		//pegando elemento do mapa por indice
		mapa.get(5);
		mapa.get(100);
		
		//verificando se a lista esta vazia
		lista.isEmpty();
		lista2.isEmpty();
		lista2.clear();
		lista2.isEmpty();
		
		//verificando se o mapa esta vazia
		mapa.isEmpty();
		mapa2.isEmpty();
		mapa2.clear();
		mapa2.isEmpty();
		
		//verificando o tamanho da lista
		lista.size();
		lista2.size();
		lista3.size();
		
		//verificando o tamanho do mapa
		mapa.size();
		mapa2.size();
		mapa3.size();
		
		//removendo elementos da lista
		lista.remove(2);
		lista.remove(5);
		lista.remove(60);
		lista.remove(5);
		
		//removendo elementos do mapa
		mapa.remove(2);
		mapa.remove(5);
		mapa.remove(60);
		mapa.remove(5);
		
		//toArray
		lista.toArray();
		mapa.values();
		
		//tentando iterator
		lista.iterator();
		
		//tentando containsKey
		mapa.containsKey(0);
		
	}

}
