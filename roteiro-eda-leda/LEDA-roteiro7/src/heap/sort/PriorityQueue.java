package heap.sort;

/**
 * Interface que implementa os métodos de fila de prioirdade segundo o livro do Cormen
 * @author fabioleite
 *
 */
public interface PriorityQueue<T extends Comparable<T>> {
	
	public T extractMaximum();
	
	public T maximum();
	
	public void increaseKey(T key, Integer increment);

}
