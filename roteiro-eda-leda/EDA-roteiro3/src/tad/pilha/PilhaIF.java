package tad.pilha;

import tad.listasEncadeadas.ListaVaziaException;

public interface PilhaIF<E> {
	
	public void empilhar(E item) throws PilhaCheiaException;
	
	public E desempilhar() throws PilhaVaziaException, ListaVaziaException;
	
	public E topo();
	
	public PilhaIF<E> multitop(int k) throws PilhaCheiaException, PilhaVaziaException, ListaVaziaException;
	
	public boolean isEmpty();
	
	public boolean isFull();

}
