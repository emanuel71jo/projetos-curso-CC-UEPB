package tad.hashtable;

public interface Hashtable<T> {
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public int capacity();
	
	public int size();
	
	public void insert(T element);
	
	public void remove(T element);
	
	public T search(T element);
	
	/**
	 * Procura o elemento pelo índice na tabela hash. Retorna -1 caso o elemento não
	 *  esteja na tabela.
	 * @param element
	 * @return
	 */
	public int indexOf(T element);
	

}
