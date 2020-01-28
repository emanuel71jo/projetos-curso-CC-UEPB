package adt.hashtable.open;

import adt.hashtable.AbstractHashtable;
import adt.hashtable.hashfunction.open.HashFunctionOpenAddress;

public abstract class AbstractHashtableOpenAddress<T extends Storable> extends
		AbstractHashtable<T> {
	
	protected HashFunctionOpenAddress<T> hashFunction = (HashFunctionOpenAddress<T>) this.hashFunction; 

	@SuppressWarnings("unused")
	private int tableSize;

	public AbstractHashtableOpenAddress(int size) {
		this.tableSize = size;
		this.initiateInternalTable(size);
	}

	@Override
	protected void initiateInternalTable(int size) {
		this.table = new Storable[size];
	}
}
