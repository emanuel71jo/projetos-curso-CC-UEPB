package tad.hashtable;

import tad.hashFunction.HashFunction;

public abstract class AbstractHashtable<T> implements Hashtable<T> {

	protected Object[] table; 	// the internal table
	protected int elements; 	// the number of elements inserted into the hash table
	protected int COLLISIONS; 	// the number of collisions occurred in this hashtable
	protected HashFunction<T> hashFunction; // the hash function used by this hashtable.

	public AbstractHashtable() {
		elements = 0;
		COLLISIONS = 0;
	}

	protected void initiateInternalTable(int size) {
		this.table = new Object[size];
	}

	@Override
	public boolean isEmpty() {
		return (elements == 0);
	}

	@Override
	public boolean isFull() {
		return (elements == table.length);
	}

	@Override
	public int size() {
		return elements;
	}

	@Override
	public int capacity() {
		return this.table.length;
	}

	public int getCOLLISIONS() {
		return COLLISIONS;
	}

	public HashFunction<T> getHashFunction() {
		return hashFunction;
	}

	public void setHashFunction(HashFunction<T> hashFunction) {
		this.hashFunction = hashFunction;
	}

	public Object[] getTable() {
		return table;
	}

	public void setTable(Object[] table) {
		this.table = table;
	}

	public int getElements() {
		return elements;
	}

	public void setElements(int elements) {
		this.elements = elements;
	}

	public void setCOLLISIONS(int cOLLISIONS) {
		COLLISIONS = cOLLISIONS;
	}
	
	

}
