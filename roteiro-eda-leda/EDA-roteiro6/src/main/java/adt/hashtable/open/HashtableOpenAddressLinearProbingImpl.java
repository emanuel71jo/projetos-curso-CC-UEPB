package adt.hashtable.open;

import adt.hashtable.hashfunction.closed.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.open.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		int probe = 0;
		while(this.table[this.hashFunction.hash(element, probe)] != null) {
			probe++;
			this.COLLISIONS++;
		}
		this.table[this.hashFunction.hash(element, probe)] = element;
		this.elements++;
	}

	@Override
	public void remove(T element) {
		int probe = 0;
		while( this.table[this.hashFunction.hash(element, probe)] != null) {
			if(this.table[this.hashFunction.hash(element, probe)].equals(element)) {break;}
			probe++;
		}
		if(this.table[this.hashFunction.hash(element, probe)] == null)
			return;
		this.table[this.hashFunction.hash(element, probe)] = null;
		this.elements--;
		if(probe != 1)
			this.COLLISIONS--;
	}

	@Override
	public T search(T element) {
		int probe = 0;
		
		while( this.table[this.hashFunction.hash(element, probe)] != null) {
			if(this.table[this.hashFunction.hash(element, probe)].equals(element)) {break;}
			probe++;
		}
		if(this.table[this.hashFunction.hash(element, probe)] == null)
			return null;
		return (T) this.table[this.hashFunction.hash(element, probe)];
	}

	@Override
	public int indexOf(T element) {
		int probe = 0;
		while(!this.table[this.hashFunction.hash(element, probe)].equals(element))
			probe++;
		return this.hashFunction.hash(element, probe);
	}
	


}
