package tad.listasEncadeadas;

import tad.fila.FilaCheiaException;
import tad.fila.FilaIF;
import tad.fila.FilaVaziaException;

public class FilaListaEncadeada implements FilaIF<NodoListaEncadeada<Integer>> {
	
	private ListaEncadeadaIF<Integer> fila;
	private NodoListaEncadeada<Integer> cabeca;
	private NodoListaEncadeada<Integer> cauda;
	
	public FilaListaEncadeada() {
		fila = new ListaEncadeadaImpl<Integer>();
		this.cabeca = this.cauda = null;
	}
	
	@Override
	public void enfileirar(NodoListaEncadeada<Integer> item) throws FilaCheiaException {
		if(isEmpty()) {
			fila.insert(item.getChave());
			this.cabeca = this.cauda = fila.search(item.getChave());
		}else {
			fila.insert(item.getChave());
			this.cauda = fila.search(item.getChave());
		}
	}

	@Override
	public NodoListaEncadeada<Integer> desenfileirar() throws FilaVaziaException, ListaVaziaException {
		if(isEmpty())
			throw new FilaVaziaException();
		Integer chave = cabeca.getChave();
		cabeca = cabeca.getProximo();
		fila.remove(chave);
		return new NodoListaEncadeada<Integer>(chave);
	}

	@Override
	public NodoListaEncadeada<Integer> verificarCauda() {
		return cauda;
	}

	@Override
	public NodoListaEncadeada<Integer> verificarCabeca() {
		return cabeca;
	}

	@Override
	public boolean isEmpty() {
		return fila.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false;
	}

}
