package tad.fila;

import tad.listasEncadeadas.ListaVaziaException;

public interface FilaIF<E> {
	
	public void enfileirar(E item) throws FilaCheiaException;
	
	public E desenfileirar() throws FilaVaziaException, ListaVaziaException;
	
	public E verificarCauda();
	
	public E verificarCabeca();
	
	public boolean isEmpty();
	
	public boolean isFull();

}
