package heap.sort;

import java.util.Comparator;

public class HeapImpl<T extends Comparable<T>> implements HeapIF<T>, PriorityQueue<T> {
	
	protected T[] heap;
	protected int index = 0;
	
	/**
	 * utilizado para implementar a comparação no heap. Util para implementar max-heap ou min-heap.
	 */
	protected Comparator<T> comparator;
	
	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;
	
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.comparator = comparator;
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
	}
	
	/**
	 * TODO:IMPLEMENTAR
	 * retornar índice do nodo pai.
	 * @param i
	 * @return
	 */
	private int parent(int i) {
		return i % 2 == 0 ? (i / 2) - 1 : i / 2;
	}
	
	/**
	 * TODO:Implementar
	 * retornar indice do filho a esquerda
	 * @param i
	 * @return
	 */
	private int left(int i) {
		return (2 * i) + 1;
	}
	
	/**
	 * retornar indice do filho a direita
	 * TODO:Implementar
	 * @param i
	 * @return
	 */
	private int right(int i) {
		return (2 * i) + 2;
	}
	
	/**
	 * Verificar o invariante do heap a partir de uma determinada posição.
	 * @param position
	 */
	private void heapify(int position) {
		int l = this.left(position);
		int r = this.right(position);
		int largest;
		if(l < this.size() && 
				this.comparator.compare(this.heap[l], this.heap[position]) > 0)
			largest = l;
		else
			largest = position;
		
		if(r < this.size() && 
				this.comparator.compare(this.heap[r], this.heap[largest]) > 0)

			largest = r;
		if(largest != position) {
			troca(position, largest);
			this.heapify(largest);
		}
	}
	
	private void troca(int position, int largest) {
		T aux = this.heap[position];
		this.heap[position] = this.heap[largest];
		this.heap[largest] = aux;
	}

	/**
	 * Aplicar o método de odenação do heapsort
	 * @param arrayInput
	 * @return
	 */
	public T[] heapsort(T[] arrayInput) {
		this.buildHeap(arrayInput);
		for(int i = this.size() - 1; i > 0 ; i--) {
			troca(i,0);
			this.index--;
			this.heapify(0);
		}
		
		return heap;
	}
	
	@Override
	public boolean isEmpty() {
		return this.index == 0;
	}
	
	@Override
	public void insert(T chave) {
		if(this.size() == this.heap.length - 1)
			doubleSize();
		int pos = ++this.index;
		for(; pos > 1 && this.comparator.compare(chave, this.heap[pos/2]) > 0;
				pos/=2)
			this.heap[pos] = this.heap[pos/2];
		this.heap[pos] = chave;
		
	}
	
	private void doubleSize() {
		T[] aux = (T[]) new Comparable[this.size() * 2];
		int tam = this.heap.length;
		for(int i = 0; i < tam; i++)
			aux[i] = this.heap[i];		
		this.heap = aux;
		
	}

	@Override
	public T extractRootElement() {
		T aux = this.heap[0];
		this.heap[0] = this.heap[--this.index];
		this.heapify(0);
		return aux;
	}
	
	@Override
	public T rootElement() {
		return this.heap[0];
	}
	
	@Override
	public void buildHeap(T[] array) {
		this.heap = array;
		this.index = this.heap.length;
		for(int i = (array.length / 2) ; i >= 0 ; i--)
			this.heapify(i);
	}
	
	@Override
	public T[] toArray(Class<T> clazz) {
		int cont = 0;
		
		T[] aux = (T[]) new Comparator[this.size() + 1];
		
		for(int i = 0; i < this.heap.length; i++)
			if(this.heap[i] != null)
				aux[cont++] = this.heap[i];
		
		return aux;
	}
	
	@Override
	public int size() {
		return this.index;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public void remove(T element) {
		
		
	}

	@Override
	public T extractMaximum() {
		T max = this.heap[0];
		
		this.heap[0] = this.heap[this.size()];
		this.index--;
		this.heapify(1);
		return max;
	}

	@Override
	public T maximum() {
		return this.heap[0];
	}

	@Override
	public void increaseKey(T key, Integer increment) {
		
		this.heap[increment] = key;
		
		while(increment > 0 && 
				this.comparator.compare(this.heap[this.parent(increment)], this.heap[increment]) > 0) {
			troca(increment,this.parent(increment));
			increment = this.parent(increment);
		}
		
	}
	
	

}
