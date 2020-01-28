package tad.listasEncadeadas;

public interface ListaEncadeadaIF<T> {
	
	public boolean isEmpty();
	public int size();
	public NodoListaEncadeada<T> search(T chave);
	public void add(T chave);
	public NodoListaEncadeada<T> remove(T chave);
	public T[] toArray();
	public String imprimeEmOrdem();
	public String imprimeInverso();
	public NodoListaEncadeada<T> sucessor(T chave);
	public NodoListaEncadeada<T> predecessor(T chave);
	T[] toArray(Class<T> clazz);

}
