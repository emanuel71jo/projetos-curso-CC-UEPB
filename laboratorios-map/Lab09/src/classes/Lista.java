package classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lista {
	
	private List<Integer> lista;
	
	public Lista() {
		lista = new ArrayList<Integer>();
	}
	
	public int add(int chave, int valor) {
		if (!lista.contains(valor)) {
			if ((chave / 1 == chave) && (valor / 1 == valor)) {
				lista.add(chave, valor);
				return valor;
			}else {
				throw new ClassCastException(); 
			}
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	public void clear() {
		lista.clear();
	}
	
	public boolean contains(int chave) {
		return lista.contains(chave);
	}
	
	public boolean equals(Object elemento) {
		return lista.equals(elemento);
	}
	
	public int get(int indice) {
		if (lista.get(indice) != null) {
			return (int) lista.get(indice);
		}else {
			throw new NullPointerException();
		}
	}
	
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	
	public Iterator<Integer> iterator(){
		return lista.iterator();
	}
	
	public int remove(int chave) {
		if (lista.remove(chave) != null || lista.contains(chave)) {
			return chave;
		}else {
			throw new NullPointerException();
		}
	}
	
	public int size() {
		return lista.size();
	}
	
	public Object[] toArray(){
		return lista.toArray();
	}

}
