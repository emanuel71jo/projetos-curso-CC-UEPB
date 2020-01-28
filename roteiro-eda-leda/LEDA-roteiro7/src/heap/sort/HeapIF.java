package heap.sort;

public interface HeapIF<T extends Comparable<T>> {
	
	public boolean isEmpty();
	public void insert(T chave);
	
	/**
	 * remoev e extrai o elemento raíz do heap. Deve retornar null se o heap estiver vazio
	 * @return
	 */
	public T extractRootElement();
	
	/**
	 * Obtem o elemento raíz sem removê-lo. Deve retornar null se o heap estiver vazio
	 * @return
	 */
	public T rootElement();
	
	/**
	 * Constroi o heap com os elementos do array passado como parâmetro.
	 * Se o heap possui elementos, eles serão destruídos.
	 * @param array
	 */
	public void buildHeap(T[] array);
	
	/**
	 * Gerar um array de elementos de acordo com a ordem atual do heap
	 * @return Array de elementos chave de acordo como está
	 */
	public T[] toArray(Class<T> clazz);
	
	/**
	 * tamanho atual do heap
	 * @return
	 */
	public int size();
	
	public T[] heapsort(T[] arrayInput);
	
	/**
	 * Remove um dado elemento do heap através da chave. Observe que após a remoção a condição de HEap
	 * precisa estar sempre satisfeita.
	 * @param element
	 */
	public void remove(T element);
	
	
	

}
