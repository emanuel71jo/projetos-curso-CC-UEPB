package tad.listasEncadeadas;

import org.hamcrest.core.CombinableMatcher;

import tad.util.Conversor;

public class ListaEncadeadaImpl<T> implements ListaEncadeadaIF<T>{
	
	NodoListaEncadeada<T> head = null;

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public int size() {
		if(isEmpty())
			return 0;
		NodoListaEncadeada<T> element = head.getProximo();
		int cont = 1;
		while(element != null) {
			element = element.getProximo();
			cont++;
		}
		return cont;
	}

	@Override
	public NodoListaEncadeada<T> search(T chave) {
		if(isEmpty())
			return null;
		if(head.equals(new NodoListaEncadeada<T>(chave)))
			return this.head;
		NodoListaEncadeada<T> element = head.getProximo();
		
		while(element != null) {
			if(element.equals(new NodoListaEncadeada<T>(chave)))
				return element;
			element = element.getProximo();
		}
		return null;
	}

	@Override
	public void insert(T chave) {
		if(isEmpty())
			head = new NodoListaEncadeada<T>(chave);
		else {
			NodoListaEncadeada<T> element = head;
			
			while(element.getProximo() != null)
				element = element.getProximo();
			
			element.setProximo(new NodoListaEncadeada<T>(chave));
		}
		
	}

	@Override
	public NodoListaEncadeada<T> remove(T chave) throws ListaVaziaException {
		if(isEmpty())
			throw new ListaVaziaException();
		
		if(head.getProximo() == null) {
			if(head.equals(new NodoListaEncadeada<T>(chave))) {
				NodoListaEncadeada<T> element = head;
				head = null;
				return element;
			}else
				return null;
		}
		if(head.equals(new NodoListaEncadeada<T>(chave))) {
			NodoListaEncadeada<T> element = head;
			head = head.getProximo();
			return element;
		}
		NodoListaEncadeada<T> anterior = head;
		NodoListaEncadeada<T> element = head.getProximo();
		NodoListaEncadeada<T> posterior = element.getProximo();
		
		while(element != null) {
			if(element.equals(new NodoListaEncadeada<T>(chave))) {
				anterior.setProximo(posterior);
				return element;
			}
			anterior = element;
			element = posterior;
			posterior = posterior.getProximo();
		}
		return null;
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[size() + 1];
		NodoListaEncadeada<T> element = head;
		int i = 0;
		while(element != null) {
			array[i++] = element.getChave();
			element = element.getProximo();
		}
		return array;
	}

	@Override
	public String imprimeEmOrdem() {
		String str = "";
		if(isEmpty())
			return str;
		str += head.getChave();
		
		NodoListaEncadeada<T> element = head.getProximo();
		while(element != null) {
			str += ", " + element.getChave();
			element = element.getProximo();
		}
		return str;
		
	}

	@Override
	public String imprimeInverso() {
		String str = "";
		if(isEmpty())
			return str;
		str += head.getChave();
		
		NodoListaEncadeada<T> element = head.getProximo();
		while(element != null) {
			str += ";" + element.getChave();
			element = element.getProximo();
		}
		
		String[] strA = str.split(";");
		str = strA[strA.length - 1];
		for(int i = strA.length - 2; i >= 0; i--) {
			str += ", " + strA[i];
		}
		return str;
	}

	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		if(isEmpty() || head.getProximo() == null)
			return null;
		
		NodoListaEncadeada<T> element = head;
		while(element != null) {
			if(element.equals(new NodoListaEncadeada<T>(chave)))
				return element.getProximo();
			element = element.getProximo();
		}
		return null;	
	}

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		if(isEmpty() || head.getProximo() == null)
			return null;
		
		NodoListaEncadeada<T> element = head.getProximo();
		NodoListaEncadeada<T> anterior = head;
		while(element != null) {
			if(element.equals(new NodoListaEncadeada<T>(chave)))
				return anterior;
			anterior = element;
			element = element.getProximo();
		}
		return null;
	}

	@Override
	public T[] toArray(Class<T> clazz) {
		
		NodoListaEncadeada<T> element = head;
		Conversor<T> c = new Conversor<T>();
		T[] array = c.gerarArray(clazz, size());
		
		int i = 0;
		if(isEmpty())
			return null;
		
		while(element != null) {
			array[i++] = element.getChave();
			element = element.getProximo();
		}
		
		return array;
	}

}
