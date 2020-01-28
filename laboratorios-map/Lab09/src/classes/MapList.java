package classes;

import java.util.Iterator;

public class MapList implements ListIF {
	
	Mapa mapa;

	public MapList() {
		mapa = new Mapa();
	}

	@Override
	public void add(int indice, int elemento) {
		try {
			mapa.put(indice, elemento);
			System.out.println(elemento + " adicionado.");
		} catch (Exception e) {
			System.out.println(elemento + " nao adicionado: " + e);
		} 
	}

	@Override
	public void clear() {
		mapa.clear();
	}

	@Override
	public boolean contains(int elemento) {
		boolean resposta = mapa.containsValue(elemento);
		if (resposta) {
			System.out.println(elemento + " estah presente.");
		}else {
			System.out.println(elemento + " nao estah presente.");
		}
		return resposta;
	}

	@Override
	public boolean equals(Object elemento) {
		boolean resposta = mapa.equals(elemento);
		if (resposta) {
			System.out.println(elemento + " eh igual.");
		}else {
			System.out.println(elemento + " nao eh igual.");
		}
		return resposta;
	}

	@Override
	public int get(int indice) {
		try {
			int resposta = mapa.get(indice);
			System.out.println("Elemento da chave " + indice + ": " + resposta);
			return resposta;			
		} catch (Exception e) {
			System.out.println("Chave " + indice + " nao existe: " + e);
			return -1;
		}  
	}

	@Override
	public boolean isEmpty() {
		boolean resposta = mapa.isEmpty();
		if (resposta) {
			System.out.println("Vazia.");
		}else {
			System.out.println("Nao vazia.");
		}
		return resposta;
	}

	@Override
	public Iterator<Integer> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(int indice) {
		try {
			mapa.remove(indice);
			System.out.println("elemento de chave " + indice + " removido.");
			return true;			
		} catch (Exception e) {
			System.out.println("elemento de chave " + indice + " nao removido: " + e);
			return false;
		}  
	}

	@Override
	public int size() {
		int tamanho = mapa.size();
		System.out.println("tamanho: " + tamanho);
		return tamanho;
	}

	@Override
	public Object[] toArray() {
		String arrayStr = "[";
		mapa.values().toArray();
		for (int i : mapa.values()) {
			arrayStr += i + ", ";
		}
		arrayStr += "]";
		System.out.println(arrayStr);
		return mapa.values().toArray();
	}

}
