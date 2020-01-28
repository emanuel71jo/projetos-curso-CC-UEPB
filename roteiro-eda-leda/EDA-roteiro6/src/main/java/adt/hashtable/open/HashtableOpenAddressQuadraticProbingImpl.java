package adt.hashtable.open;

import adt.hashtable.hashfunction.closed.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.open.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size, HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		int probe = 0;
		while (this.table[this.hashFunction.hash(element, probe)] != null) {
			probe++;
			this.COLLISIONS++;
		}
		this.table[this.hashFunction.hash(element, probe)] = element;
		this.elements++;
	}

	@Override
	public void remove(T element) {
		int probe = 0;
		while (this.table[this.hashFunction.hash(element, probe)] != null) {
			if (this.table[this.hashFunction.hash(element, probe)].equals(element)) {break;}
			probe++;
		}
		if (this.table[this.hashFunction.hash(element, probe)] == null)
			return;
		this.table[this.hashFunction.hash(element, probe)] = null;
		this.elements--;
		if (probe != 1)
			this.COLLISIONS--;
	}

	@Override
	public T search(T element) {
		int probe = 0;
		while (this.table[this.hashFunction.hash(element, probe)] != null) {
			if (this.table[this.hashFunction.hash(element, probe)].equals(element)) {break;}
			probe++;
			if(this.hashFunction.hash(element, probe) < this.capacity())
				return null;
		}
		if (this.table[this.hashFunction.hash(element, probe)] == null)
			return null;
		return (T) this.table[this.hashFunction.hash(element, probe)];
	}

	@Override
	public int indexOf(T element) {
		int probe = 0;
		while (!this.table[this.hashFunction.hash(element, probe)].equals(element))
			probe++;
		return this.hashFunction.hash(element, probe);
	}
}
