
package interfaces;

public interface Ordenador<T> {
    public void inserir(T element);
    public T localizar(String element);
    public T[] insertionSort();
    public T[] bubbleSort();
    public T[] bubbleSortDinamico();
    public T[] selectionSort();
    public T buscaBinaria(T element);
    public void inserirOrdenado(T element);
    public void removeOrdenado(T element);
    public T[] recuperaArray();
}
