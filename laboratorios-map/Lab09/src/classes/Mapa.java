package classes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Mapa {

	private Map<Integer, Integer> mapa;
	
	public Mapa() {
		mapa = new HashMap<>();
	}
	
	public void clear() {
		mapa.clear();		
	}
	
	public boolean containsKey(int chave) {
		return mapa.containsKey(chave);
	}
	
	public boolean containsValue(int valor) {
		return mapa.containsValue(valor);
	}
	
	public boolean equals(Object o) {
		return mapa.equals(o);
	}
	
	public int get(int chave) {
		if (mapa.get(chave) != null) {
			return mapa.get(chave);
		}else {
			throw new NullPointerException();
		}
	}
	
	public boolean isEmpty() {
		return mapa.isEmpty();
	}
	
	public int put(int chave, int valor) {
		if (!mapa.containsKey(chave)) {
			if ((chave / 1 == chave) && (valor / 1 == valor)) {
				mapa.put(chave, valor);
				return valor;
			}else {
				throw new ClassCastException(); 
			}
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	public int remove(int chave) {
		if (mapa.remove(chave) != null || mapa.containsKey(chave)) {
			return chave;
		}else {
			throw new NullPointerException();
		}
	}
	
	public int size() {
		return mapa.size();
	}
	
	public Collection<Integer> values(){
		return mapa.values();
	}
}
