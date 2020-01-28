package adt.hashtable.hashfunction.open;

import adt.hashtable.Hashtable;

import adt.hashtable.hashfunction.closed.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.closed.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.closed.HashFunctionDivisionMethod;
import adt.hashtable.hashfunction.closed.HashFunctionMultiplicationMethod;

@SuppressWarnings("unused")
public class HashFunctionQuadraticProbing<T> implements
		HashFunctionOpenAddress<T> {

	private int tableCapacity;
	protected HashFunctionClosedAddress<T> originalHashFunction;
	protected int c1;
	protected int c2;

	public HashFunctionQuadraticProbing(int tableCapacity,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		this.tableCapacity = tableCapacity;
		if (method == HashFunctionClosedAddressMethod.DIVISION) {
			originalHashFunction = new HashFunctionDivisionMethod<T>(
					tableCapacity);
		} else {
			originalHashFunction = new HashFunctionMultiplicationMethod<T>(
					tableCapacity);
		}
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	public int hash(T element, int probe) {
		int generatedIndex = 0;
		
		generatedIndex = (originalHashFunction.hash(element) + this.c1*probe + this.c2*probe*probe) % this.tableCapacity;
		
		return generatedIndex;
	}

}
