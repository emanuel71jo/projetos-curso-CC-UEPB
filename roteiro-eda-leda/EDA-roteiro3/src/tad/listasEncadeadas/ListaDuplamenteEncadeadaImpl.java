package tad.listasEncadeadas;

import tad.util.Conversor;

public class ListaDuplamenteEncadeadaImpl<T> implements ListaDuplamenteEncadeadaIF<T> {

	NodoListaDuplamenteEncadeada<T> head = null; //cabeca
	NodoListaDuplamenteEncadeada<T> tail = null; //cauda
	
	public ListaDuplamenteEncadeadaImpl() {
		head.setProximo(tail);
		tail.setAnterior(head);
	}
	
	@Override
	public boolean isEmpty() {
		return head.getProximo() == null;
	}

	@Override
	public int size() {
		if(isEmpty())
			return 0;
		
		int cont = 0;
		NodoListaDuplamenteEncadeada<T> element = 
				(NodoListaDuplamenteEncadeada<T>) head.getProximo();
		while(element != null) {
			cont++;
			element = (NodoListaDuplamenteEncadeada<T>) element.getProximo();
		}
		
		return cont;
	}

	@Override
	public NodoListaEncadeada<T> search(T chave) {
		if(isEmpty())
			return null;
		
		NodoListaDuplamenteEncadeada<T> element =
				(NodoListaDuplamenteEncadeada<T>) head.getProximo();
		while(element != null) {
			if(element.equals(chave))
				return element;
			element = (NodoListaDuplamenteEncadeada<T>) element.getProximo();
		}
		return null;
	}

	@Override
	public void insert(T chave) {
		NodoListaDuplamenteEncadeada<T> element = new NodoListaDuplamenteEncadeada<T>(chave);
		if(isEmpty()) {
			head.setProximo(element);
			tail.setAnterior(element);
			element.setProximo(tail);
			element.setAnterior(head);
		}else {
			element.setAnterior(tail.getAnterior());
			element.setProximo(tail);
			tail.getAnterior().setProximo(element);
			tail.setAnterior(element);
		}
	}

	@Override
	public NodoListaEncadeada<T> remove(T chave) throws ListaVaziaException {
		if(isEmpty())
			throw new ListaVaziaException();
		NodoListaDuplamenteEncadeada<T> element = 
				(NodoListaDuplamenteEncadeada<T>) head.getProximo();
		
		while(element != null) {
			if(element.equals(chave)) {
				element.getAnterior().setProximo(element.getProximo());
				((NodoListaDuplamenteEncadeada<T>) 
						element.getProximo()).setAnterior(element.getAnterior());
	
				return new NodoListaEncadeada<T>(chave);			
			}
			element = (NodoListaDuplamenteEncadeada<T>) element.getProximo();
		}
		
		return null;
		
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[size() + 1];
		
		NodoListaDuplamenteEncadeada<T> element = 
				(NodoListaDuplamenteEncadeada<T>) head.getProximo();
		int i = 0;
		while(element != null) {
			array[i++] = element.getChave();
			element = (NodoListaDuplamenteEncadeada<T>) element.getProximo();
		}
		return array;
	}

	@Override
	public String imprimeEmOrdem() {
		String str = "";
		if(isEmpty())
			return str;
		NodoListaDuplamenteEncadeada<T> element = 
				(NodoListaDuplamenteEncadeada<T>) head.getProximo();
		str += element.getChave();
		while(element.getProximo() != null) {
			str += ", " + element.getChave();
			element = (NodoListaDuplamenteEncadeada<T>) element.getProximo();
		}
		return str;
	}

	@Override
	public String imprimeInverso() {
		String str = "";
		if(isEmpty())
			return str;
		
		NodoListaDuplamenteEncadeada<T> element = tail.getAnterior();
		str += element.getChave();
		while(element.getAnterior() != null) {
			str += ", " + element.getChave();
			element = element.getAnterior();
		}
		return str;
	}

	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		if(isEmpty())
			return null;
		
		NodoListaDuplamenteEncadeada<T> element = 
				(NodoListaDuplamenteEncadeada<T>) head.getProximo();
		while(element != null) {
			if(element.equals(chave))
				return element.getProximo();
			element = (NodoListaDuplamenteEncadeada<T>) element.getProximo();
		}
		return null;
	}

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		if(isEmpty())
			return null;
		
		NodoListaDuplamenteEncadeada<T> element = tail.getAnterior();
		while(element != null) {
			if(element.equals(chave))
				return element.getAnterior();
			element = element.getAnterior();
		}
		
		return null;
	}

	@Override
	public T[] toArray(Class<T> clazz) {
		NodoListaDuplamenteEncadeada<T> element = 
				(NodoListaDuplamenteEncadeada<T>) head.getProximo();
		Conversor<T> c = new Conversor<T>();
		T[] array = c.gerarArray(clazz, size());
		
		int i = 0;
		if(isEmpty())
			return null;
		
		while(element != null) {
			array[i++] = element.getChave();
			element = (NodoListaDuplamenteEncadeada<T>) element.getProximo();
		}
		
		return array;
	}

	@Override
	public void inserePrimeiro(T elemento) {
		NodoListaDuplamenteEncadeada<T> element = 
				new NodoListaDuplamenteEncadeada<T>(elemento);
		
		element.setAnterior(head);
		element.setProximo(head.getProximo());
		((NodoListaDuplamenteEncadeada<T>) head.getProximo()).setAnterior(element);
		head.setProximo(element);
		
		
	}

	@Override
	public NodoListaDuplamenteEncadeada<T> removeUltimo() {
		if(isEmpty())
			return null;
		NodoListaDuplamenteEncadeada<T> element = tail.getAnterior();
		
		tail.setAnterior(element.getAnterior());
		element.getAnterior().setProximo(tail);
		
		return element;
	}

	@Override
	public NodoListaDuplamenteEncadeada<T> removePrimeiro() {
		if(isEmpty())
			return null;
		
		NodoListaDuplamenteEncadeada<T> element = 
				(NodoListaDuplamenteEncadeada<T>) head.getProximo();
		
		head.setProximo(element.getProximo());
		((NodoListaDuplamenteEncadeada<T>) head.getProximo()).setAnterior(head);
		
		return element;
	}
	
	
}







