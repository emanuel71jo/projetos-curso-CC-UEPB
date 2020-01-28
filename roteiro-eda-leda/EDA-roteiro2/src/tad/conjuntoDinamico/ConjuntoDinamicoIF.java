package tad.conjuntoDinamico;

public interface ConjuntoDinamicoIF<E> {
	
	public void inserir(E item);
	
	public E remover(E item) throws Exception;
	
	public E predecessor(E item) throws Exception;
	
	public E sucessor(E item) throws Exception;
	
	public int tamanho();
	
	public E buscar(E item) throws Exception;
	
	public E minimum() throws Exception;
	
	public E maximum() throws Exception;

}
