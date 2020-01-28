package tad.listasEncadeadas;

import tad.pilha.PilhaCheiaException;
import tad.pilha.PilhaIF;
import tad.pilha.PilhaVaziaException;

public class PilhaListaEncadeada implements PilhaIF<NodoListaEncadeada<Integer>>{
	
	private ListaEncadeadaImpl<Integer> pilha;
	private NodoListaEncadeada<Integer> topo;
	
	@Override
	public void empilhar(NodoListaEncadeada<Integer> item) throws PilhaCheiaException {
		pilha.insert(item.getChave());
		topo = pilha.search(item.getChave());
	}

	@Override
	public NodoListaEncadeada<Integer> desempilhar() throws PilhaVaziaException, ListaVaziaException {
		Integer chave = topo.getChave();
		topo = pilha.predecessor(chave);
		pilha.remove(chave);
		return new NodoListaEncadeada<Integer>(chave);
	}

	@Override
	public NodoListaEncadeada<Integer> topo() {
		return this.topo;
	}

	@Override
	public PilhaIF<NodoListaEncadeada<Integer>> multitop(int k) throws PilhaCheiaException, PilhaVaziaException, ListaVaziaException {
		if(isEmpty() || k > pilha.size())
			return null;
		PilhaIF<NodoListaEncadeada<Integer>> aux = new PilhaListaEncadeada();
		
		for(int i = 0; i < k; i++) {
			aux.empilhar(this.topo);
			this.desempilhar();
		}
		
		return aux;
	}

	@Override
	public boolean isEmpty() {
		return this.topo == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}
	
}
