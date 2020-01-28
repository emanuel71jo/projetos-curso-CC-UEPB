package classes;

public interface MapIF {
	
	public void clear();
	public boolean containsKey(int indice);
	public boolean containsValue(int elemento);
	public boolean equals(Object elemento);
	public int get(int indice);
	public boolean isEmpty();
	public void put(int indice, int elemento);
	public boolean remove(int indice);
	public int size();
	public Object[] values();

}
