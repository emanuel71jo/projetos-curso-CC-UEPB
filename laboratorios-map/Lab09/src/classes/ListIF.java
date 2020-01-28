package classes;

import java.util.Iterator;

public interface ListIF {

	public void add(int indice, int elemento);
	public void clear();
	public boolean contains(int elemento);
	public boolean equals(Object elemento);
	public int get(int indice);
	public boolean isEmpty();
	public Iterator<Integer> iterator();
	public boolean remove(int indice);
	public int size();
	public Object[] toArray();
	
}
